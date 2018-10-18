package cn.cctech.kccommand

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.content.res.ResourcesCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.View.LAYER_TYPE_HARDWARE
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.RelativeLayout
import cn.cctech.kancolle.oyodo.Oyodo
import cn.cctech.kancolle.oyodo.managers.Battle
import cn.cctech.kancolle.oyodo.managers.Fleet
import cn.cctech.kancolle.oyodo.managers.isFleetBadlyDamage
import cn.cctech.kccommand.databinding.InfoPanelBinding
import cn.cctech.kccommand.entities.Info
import cn.cctech.kccommand.fragments.*
import cn.cctech.kccommand.proxy.VpnService
import cn.cctech.kccommand.utils.NotifyManager
import cn.cctech.kccommand.utils.findView
import com.orhanobut.logger.Logger
import com.pgyersdk.crash.PgyCrashManager
import com.pgyersdk.update.PgyUpdateManager
import com.pgyersdk.update.UpdateManagerListener
import com.tencent.smtt.export.external.interfaces.WebResourceRequest
import com.tencent.smtt.export.external.interfaces.WebResourceResponse
import com.tencent.smtt.sdk.WebSettings
import com.tencent.smtt.sdk.WebView
import com.tencent.smtt.sdk.WebViewClient
import net.lucode.hackware.magicindicator.MagicIndicator
import net.lucode.hackware.magicindicator.ViewPagerHelper
import net.lucode.hackware.magicindicator.buildins.UIUtil
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.TriangularPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView

class MainActivity : AppCompatActivity(), NotifyManager.Callback {

    private val kRequestVpn = 666
    private val mResetPgyerUpdateStr = "{\"code\":0,\"message\":\"\",\"data\":{\"lastBuild\":\"1\",\"versionCode\":\"1\",\"versionName\":1,\"appUrl\":\"\",\"build\":\"1\",\"releaseNote\":\"\"}}"

    private var mTabs: Array<String>? = null
    private var mViewPager: ViewPager? = null
    private var mInfoPanelBinding: InfoPanelBinding? = null

    private var mCollapseAll: ImageButton? = null
    private var mExpandAll: ImageButton? = null
    private var mInfoPanel: View? = null
    private var mMainPanel: View? = null
    private var mBloodBorder: View? = null
    private var mWebView: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        mInfoPanelBinding?.info = Info()
        PgyCrashManager.register(this)
        checkVersion()
        NotifyManager.setup(this)
    }

    override fun onResume() {
        super.onResume()
        if (Oyodo.attention().checkStart() && !VpnService.checkOn()) {
            startProxy()
        }
        mWebView?.onResume()
        mWebView?.resumeTimers()
    }

    override fun onPause() {
        super.onPause()
        mWebView?.onPause()
        mWebView?.pauseTimers()
    }

    override fun onDestroy() {
        mWebView?.loadUrl("about:blank")
        mWebView?.destroy()
        mWebView = null
        super.onDestroy()
    }

    private fun startProxy() {
        try {
            val prepare = VpnService.prepare(this)
            if (prepare == null) {
                Logger.i("Prepare done")
                onActivityResult(kRequestVpn, Activity.RESULT_OK, null)
            } else {
                startActivityForResult(prepare, kRequestVpn)
            }
        } catch (ex: Throwable) {
            // Prepare failed
            Logger.e(ex, "Prepare failed")
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initViews() {
        val gameContainer = findView<ViewGroup>(R.id.rl_flash)
        mWebView = WebView(getContext())
        gameContainer.addView(mWebView, RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT))
        //设置支持js
        mWebView?.settings?.javaScriptEnabled = true
        //设置渲染效果优先级，高
        mWebView?.settings?.setRenderPriority(WebSettings.RenderPriority.HIGH)
        //设置缓存模式
        mWebView?.settings?.cacheMode = WebSettings.LOAD_DEFAULT
        //设置数据库缓存路径
        mWebView?.settings?.databaseEnabled = true
        mWebView?.settings?.databasePath = cacheDir.absolutePath + "/cc_db"
        //开启 应用缓存 功能
        mWebView?.settings?.setAppCacheEnabled(true)
        //设置 应用 缓存目录
        mWebView?.settings?.setAppCachePath(cacheDir.absolutePath + "/cc_cache")
        mWebView?.settings?.setAppCacheMaxSize(Long.MAX_VALUE)
        //开启 DOM 存储功能
        mWebView?.settings?.domStorageEnabled = true
        //开启 数据库 存储功能
        mWebView?.settings?.databaseEnabled = true
        mWebView?.setLayerType(LAYER_TYPE_HARDWARE, null)
        mWebView?.webViewClient = object : WebViewClient() {

            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
//                Log.d("Override2", request?.url?.toString())
                view?.loadUrl(request?.url?.toString())
                return true
            }

            override fun shouldInterceptRequest(view: WebView?, request: WebResourceRequest?): WebResourceResponse? {
                Log.d("Intercept2", request?.url?.toString())
                if (gameLoaded(request?.url?.toString())) {
                    gameStart(view)
                }
                return super.shouldInterceptRequest(view, request)
            }

            private fun gameLoaded(url: String?): Boolean = url?.contains("kcs2/resources/world") == true

            private fun gameStart(view: WebView?) {
                val script = "javascript:((\$,_)=>{const html=\$.documentElement,gf=\$.getElementById('game_frame'),gs=gf.style,gw=gf.offsetWidth,gh=gw*.6;let vp=\$.querySelector('meta[name=viewport]'),t=0;vp||(vp=\$.createElement('meta'),vp.name='viewport',\$.querySelector('head').appendChild(vp));html.style.overflow='hidden';\$.body.style.cssText='min-width:0;overflow:hidden;margin:0';\$.querySelector('.dmm-ntgnavi').style.display='none';\$.querySelector('.area-naviapp').style.display='none';\$.getElementById('ntg-recommend').style.display='none';gs.position='fixed';gs.marginRight='auto';gs.marginLeft='auto';gs.top='-16px';gs.right='0';gs.zIndex='100';gs.transformOrigin='50% 16px';if(!_.kancolleFit){const k=()=>{const w=html.clientWidth,h=_.innerHeight;w/h<1/.6?gs.transform='scale('+w/gw+')':gs.transform='scale('+h/gh+')';w<gw?gs.left='-'+(gw-w)/2+'px':gs.left='0'};_.addEventListener('resize',()=>{clearTimeout(t);t=setTimeout(k,10)});_.kancolleFit=k}kancolleFit()})(document,window)"
                view?.post { view.loadUrl(script) }
                startProxy()
            }
        }
        mWebView?.loadUrl("http://www.dmm.com/netgame/social/-/gadgets/=/app_id=854854/")
        mTabs = resources.getStringArray(R.array.main_tabs)
        mViewPager = findView(R.id.main_pager)
        mViewPager?.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment {
                return when (position) {
                    0 -> FleetFragment.newInstance()
                    1 -> BattleFragment.newInstance()
                    2 -> DockFragment.newInstance()
                    3 -> QuestFragment.newInstance()
                    else -> TestFragment.newInstance(position)
                }
            }

            override fun getCount(): Int {
                return mTabs?.size ?: 0
            }
        }
        mViewPager?.offscreenPageLimit = 3
        val magicIndicator = findView<MagicIndicator>(R.id.main_indicator)
        val commonNavigator = CommonNavigator(this)
        commonNavigator.adapter = object : CommonNavigatorAdapter() {

            override fun getCount(): Int {
                return mTabs?.size ?: 0
            }

            override fun getTitleView(context: Context, index: Int): IPagerTitleView {
                val colorTransitionPagerTitleView = ColorTransitionPagerTitleView(context)
                colorTransitionPagerTitleView.normalColor = ResourcesCompat.getColor(resources, R.color.tabTextColorNormal, theme)
                colorTransitionPagerTitleView.selectedColor = ResourcesCompat.getColor(resources, R.color.tabTextColorSelect, theme)
                colorTransitionPagerTitleView.text = mTabs?.get(index)
                colorTransitionPagerTitleView.textSize = 12f
                colorTransitionPagerTitleView.setOnClickListener { mViewPager?.currentItem = index }
                return colorTransitionPagerTitleView
            }

            override fun getIndicator(context: Context): IPagerIndicator {
                val indicator = TriangularPagerIndicator(context)
                indicator.lineColor = ResourcesCompat.getColor(resources, R.color.colorPrimary, theme)
                indicator.lineHeight = UIUtil.dip2px(context, 2.0)
                indicator.triangleHeight = UIUtil.dip2px(context, 4.0)
                return indicator
            }
        }
        commonNavigator.isAdjustMode = true
        magicIndicator.navigator = commonNavigator
        ViewPagerHelper.bind(magicIndicator, mViewPager)

        val infoPanelGroup = findView<FrameLayout>(R.id.fl_info_panel)
        mInfoPanelBinding = DataBindingUtil.inflate(layoutInflater, R.layout.info_panel, infoPanelGroup, true)

        mInfoPanel = findView(R.id.fl_info_panel)
        mMainPanel = findView(R.id.rl_main_panel)
        mCollapseAll = findView(R.id.btn_collapse_all)
        mCollapseAll?.setOnClickListener { collapseAll() }
        mExpandAll = findView(R.id.btn_expand_all)
        mExpandAll?.setOnClickListener { expandAll() }
        mBloodBorder = findView(R.id.blood_border)

        setBloodBorder()
    }

    private fun collapseAll() {
        mCollapseAll?.visibility = View.GONE
        mInfoPanel?.visibility = View.GONE
        mMainPanel?.visibility = View.GONE
        mExpandAll?.visibility = View.VISIBLE
    }

    private fun expandAll() {
        mCollapseAll?.visibility = View.VISIBLE
        mInfoPanel?.visibility = View.VISIBLE
        mMainPanel?.visibility = View.VISIBLE
        mExpandAll?.visibility = View.GONE
    }

    private fun setBloodBorder() {
        Oyodo.attention().watch(Fleet.shipWatcher) {
            val show = Battle.friendIndex >= 0 && isFleetBadlyDamage(Battle.friendIndex)
            runOnUiThread {
                mBloodBorder!!.visibility = if (show) View.VISIBLE else View.GONE
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == kRequestVpn) {
            if (resultCode == Activity.RESULT_OK) {
                VpnService.start("prepared", this)
            } else if (resultCode == Activity.RESULT_CANCELED) {
                // Canceled
                Logger.e("Prepare canceled")
            }
        }
    }

    override fun getContext(): Context = this

    override fun dispatchKeyEvent(event: KeyEvent?): Boolean {
        if (event?.keyCode == KeyEvent.KEYCODE_BACK) {
            val intent = Intent()
            intent.action = Intent.ACTION_MAIN
            intent.addCategory(Intent.CATEGORY_HOME)
            startActivity(intent)
            return true
        }
        return super.dispatchKeyEvent(event)
    }

    private fun checkVersion() {
        UpdateManagerListener.updateLocalBuildNumber(mResetPgyerUpdateStr)
        PgyUpdateManager.register(this, object : UpdateManagerListener() {
            override fun onUpdateAvailable(result: String?) {
                Logger.json(result)
                val localVersion = try {
                    val packageInfo = packageManager.getPackageInfo(packageName, 0)
                    packageInfo.versionCode
                } catch (e: Exception) {
                    Int.MAX_VALUE
                }
                val resultBean = getAppBeanFromString(result)
                val remoteVersion = try {
                    resultBean.versionCode.toInt()
                } catch (e: Exception) {
                    -1
                }
                if (remoteVersion > localVersion) {
                    AlertDialog.Builder(getContext())
                            .setTitle(getString(R.string.dialog_update_title, resultBean.versionName))
                            .setMessage(resultBean.releaseNote)
                            .setPositiveButton(R.string.dialog_update_positive) { _, _ -> startDownloadTask(this@MainActivity, resultBean.downloadURL) }
                            .setNegativeButton(R.string.dialog_update_negative, null)
                            .show()
                }
            }

            override fun onNoUpdateAvailable() {
                Logger.d("onNoUpdateAvailable")
            }
        })
    }

}
