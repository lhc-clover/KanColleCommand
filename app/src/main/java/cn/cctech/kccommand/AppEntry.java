package cn.cctech.kccommand;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import com.adobe.air.InstallOfferPingUtils;
import com.adobe.air.ResourceIdMap;

import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.Date;

import dalvik.system.DexClassLoader;

@SuppressWarnings("ALL")
public class AppEntry extends AppCompatActivity {
    private static final String LOG_TAG = "AppEntry";
    private static final String RESOURCE_BUTTON_EXIT = "string.button_exit";
    private static final String RESOURCE_BUTTON_INSTALL = "string.button_install";
    private static final String RESOURCE_CLASS = "com.dmm.dmmlabo.kancolle.R";
    private static final String RESOURCE_TEXT_RUNTIME_REQUIRED = "string.text_runtime_required";
    private static final String RESOURCE_TITLE_ADOBE_AIR = "string.title_adobe_air";
    private static String AIR_PING_URL = null;
    private static String RUNTIME_PACKAGE_ID;
    private static Object sAndroidActivityWrapper;
    private static Class sAndroidActivityWrapperClass;
    private static DexClassLoader sDloader;
    private static boolean sRuntimeClassesLoaded;
    private static AppEntry sThis;

    static {
        AppEntry.sRuntimeClassesLoaded = false;
        AppEntry.sAndroidActivityWrapper = null;
        AppEntry.sThis = null;
        AppEntry.RUNTIME_PACKAGE_ID = "com.adobe.air";
        AppEntry.AIR_PING_URL = "http://airdownload2.adobe.com/air?";
    }

    public AppEntry() {
        super();
    }

    private static void KillSelf() {
        Process.killProcess(Process.myPid());
    }

//    static void access$000(AppEntry x0) {
//        x0.launchMarketPlaceForAIR();
//    }
//
//    static AppEntry access$100() {
//        return AppEntry.sThis;
//    }
//
//    static String access$200() {
//        return AppEntry.AIR_PING_URL;
//    }
//
//    static void access$300(AppEntry x0) {
//        x0.loadSharedRuntimeDex();
//    }
//
//    static void access$400(AppEntry x0, boolean x1) {
//        x0.createActivityWrapper(x1);
//    }
//
//    static boolean access$500() {
//        return AppEntry.sRuntimeClassesLoaded;
//    }
//
//    static void access$600(AppEntry x0) {
//        x0.InvokeWrapperOnCreate();
//    }
//
//    static void access$700() {
//        AppEntry.KillSelf();
//    }

    private void BroadcastIntent(String action, String data) {
        try {
            this.startActivity(Intent.parseUri(data, 0).setAction(action).addFlags(268435456));
        } catch (URISyntaxException var4) {
            var4.printStackTrace();
        } catch (ActivityNotFoundException var5) {
            var5.printStackTrace();
        }

    }

    private Object InvokeMethod(Method method, Object... args) {
        if (!sRuntimeClassesLoaded) {
            return null;
        } else {
            Object retval = null;

            try {
                if (args != null) {
                    retval = method.invoke(sAndroidActivityWrapper, args);
                } else {
                    retval = method.invoke(sAndroidActivityWrapper, new Object[0]);
                }
            } catch (Exception var5) {
                var5.printStackTrace();
            }

            return retval;
        }
    }

    private void InvokeWrapperOnCreate() {
        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onCreate", new Class[]{Activity.class, String[].class});
            String xmlPath = "";
            String rootDirectory = "";
            String extraArgs = "-nodebug";
            Boolean isADL = new Boolean(false);
            Boolean isDebuggerMode = new Boolean(false);
            String[] args = new String[]{xmlPath, rootDirectory, extraArgs, isADL.toString(), isDebuggerMode.toString()};
            this.InvokeMethod(e, new Object[]{this, args});
        } catch (Exception var8) {
            var8.printStackTrace();
        }

    }

    private void createActivityWrapper(boolean hasCaptiveRuntime) {
        try {
            Method e;
            if (hasCaptiveRuntime) {
                e = sAndroidActivityWrapperClass.getMethod("CreateAndroidActivityWrapper", new Class[]{Activity.class, Boolean.class});
                sAndroidActivityWrapper = e.invoke((Object) null, new Object[]{this, Boolean.valueOf(hasCaptiveRuntime)});
            } else {
                e = sAndroidActivityWrapperClass.getMethod("CreateAndroidActivityWrapper", new Class[]{Activity.class});
                sAndroidActivityWrapper = e.invoke((Object) null, new Object[]{this});
            }
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    public boolean dispatchGenericMotionEvent(MotionEvent event) {
        boolean handled = false;

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("dispatchGenericMotionEvent", new Class[]{MotionEvent.class, Boolean.TYPE});
            this.InvokeMethod(e, new Object[]{event, Boolean.valueOf(handled)});
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return handled || super.dispatchGenericMotionEvent(event);
    }

    public boolean dispatchKeyEvent(KeyEvent event) {
        boolean handled = false;

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("dispatchKeyEvent", new Class[]{KeyEvent.class, Boolean.TYPE});
            this.InvokeMethod(e, new Object[]{event, Boolean.valueOf(handled)});
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return handled || super.dispatchKeyEvent(event);
    }

    public void finishActivityFromChild(Activity child, int requestCode) {
        super.finishActivityFromChild(child, requestCode);

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("finishActivityFromChild", new Class[]{Activity.class, Integer.TYPE});
            this.InvokeMethod(e, new Object[]{child, Integer.valueOf(requestCode)});
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    public void finishFromChild(Activity child) {
        super.finishFromChild(child);

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("finishFromChild", new Class[]{Activity.class});
            this.InvokeMethod(e, new Object[]{child});
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    private boolean isRuntimeInstalled() {
        PackageManager pkgMgr = this.getPackageManager();

        try {
            pkgMgr.getPackageInfo(RUNTIME_PACKAGE_ID, PackageManager.GET_GIDS);
            return true;
        } catch (PackageManager.NameNotFoundException var3) {
            return false;
        }
    }

    private boolean isRuntimeOnExternalStorage() {
        PackageManager pkgMgr = this.getPackageManager();

        try {
            ApplicationInfo nfe = pkgMgr.getApplicationInfo(RUNTIME_PACKAGE_ID, PackageManager.GET_SHARED_LIBRARY_FILES/*8192*/);
            if ((nfe.flags & 262144) == 262144) {
                return true;
            }
        } catch (PackageManager.NameNotFoundException var3) {
            var3.printStackTrace();
        }

        return false;
    }

    protected void launchAIRService() {
        try {
            Intent e = new Intent("com.adobe.air.AIRServiceAction");
            e.setClassName(RUNTIME_PACKAGE_ID, "com.adobe.air.AIRService");
            ServiceConnection conn = new ServiceConnection() {
                public void onServiceConnected(ComponentName name, IBinder service) {
                    AppEntry.this.unbindService(this);
                    AppEntry.this.loadSharedRuntimeDex();
                    AppEntry.this.createActivityWrapper(false);
                    if (AppEntry.sRuntimeClassesLoaded) {
                        AppEntry.this.InvokeWrapperOnCreate();
                    } else {
                        AppEntry.KillSelf();
                    }

                }

                public void onServiceDisconnected(ComponentName name) {
                }
            };
            this.bindService(e, conn, Context.BIND_AUTO_CREATE);
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    private void launchMarketPlaceForAIR() {
        String airDownloadURL = null;

        try {
            ActivityInfo marketPlaceURL = this.getPackageManager().getActivityInfo(this.getComponentName(), PackageManager.GET_META_DATA);
            Bundle e = marketPlaceURL.metaData;
            if (e != null) {
                airDownloadURL = (String) e.get("airDownloadURL");
            }
        } catch (PackageManager.NameNotFoundException var5) {
            var5.printStackTrace();
        }

        String marketPlaceURL1 = airDownloadURL;
        if (airDownloadURL == null) {
            marketPlaceURL1 = "market://details?id=" + RUNTIME_PACKAGE_ID;
        }

        try {
            this.BroadcastIntent("android.intent.action.VIEW", marketPlaceURL1);
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    private boolean loadCaptiveRuntimeClasses() {
        boolean hasCaptiveRuntime = false;

        try {
            sAndroidActivityWrapperClass = Class.forName("com.adobe.air.AndroidActivityWrapper");
            hasCaptiveRuntime = true;
            if (sAndroidActivityWrapperClass != null) {
                sRuntimeClassesLoaded = true;
            }
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        return hasCaptiveRuntime;
    }

    private void loadSharedRuntimeDex() {
        try {
            if (!sRuntimeClassesLoaded) {
                Context e = this.createPackageContext(RUNTIME_PACKAGE_ID, Context.CONTEXT_INCLUDE_CODE | Context.CONTEXT_IGNORE_SECURITY);
                sDloader = new DexClassLoader(RUNTIME_PACKAGE_ID, this.getFilesDir().getAbsolutePath(), (String) null, e.getClassLoader());
                sAndroidActivityWrapperClass = sDloader.loadClass("com.adobe.air.AndroidActivityWrapper");
                if (sAndroidActivityWrapperClass != null) {
                    sRuntimeClassesLoaded = true;
                }
            }
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            if (sRuntimeClassesLoaded) {
                Method e = sAndroidActivityWrapperClass.getMethod("onActivityResult", new Class[]{Integer.TYPE, Integer.TYPE, Intent.class});
                this.InvokeMethod(e, new Object[]{Integer.valueOf(requestCode), Integer.valueOf(resultCode), data});
            }
        } catch (Exception var5) {
            var5.printStackTrace();
        }

    }

    protected void onApplyThemeResource(Resources.Theme theme, int resid, boolean first) {
        super.onApplyThemeResource(theme, resid, first);

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onApplyThemeResource", new Class[]{Resources.Theme.class, Integer.TYPE, Boolean.TYPE});
            this.InvokeMethod(e, new Object[]{theme, Integer.valueOf(resid), Boolean.valueOf(first)});
        } catch (Exception var5) {
            var5.printStackTrace();
        }

    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onAttachedToWindow", new Class[0]);
            this.InvokeMethod(e, new Object[0]);
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    public void onBackPressed() {
        super.onBackPressed();

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onBackPressed", new Class[0]);
            this.InvokeMethod(e, new Object[0]);
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    protected void onChildTitleChanged(Activity childActivity, CharSequence title) {
        super.onChildTitleChanged(childActivity, title);

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onChildTitleChanged", new Class[]{Activity.class, CharSequence.class});
            this.InvokeMethod(e, new Object[]{childActivity, title});
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onConfigurationChanged", new Class[]{Configuration.class});
            this.InvokeMethod(e, new Object[]{newConfig});
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    public void onContentChanged() {
        super.onContentChanged();

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onContentChanged", new Class[0]);
            this.InvokeMethod(e, new Object[0]);
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    public boolean onContextItemSelected(MenuItem item) {
        boolean retval = super.onContextItemSelected(item);

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onContextItemSelected", new Class[]{MenuItem.class, Boolean.TYPE});
            return ((Boolean) this.InvokeMethod(e, new Object[]{item, Boolean.valueOf(retval)})).booleanValue();
        } catch (Exception var4) {
            var4.printStackTrace();
            return retval;
        }
    }

    public void onContextMenuClosed(Menu menu) {
        super.onContextMenuClosed(menu);

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onContextMenuClosed", new Class[]{Menu.class});
            this.InvokeMethod(e, new Object[]{menu});
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sThis = this;
        Date hasCaptiveRuntime = new Date();
        long millis = hasCaptiveRuntime.getTime();
        Log.i("StartupTime1", ":" + millis);
        boolean hasCaptiveRuntime1 = this.loadCaptiveRuntimeClasses();
        if (!hasCaptiveRuntime1) {
            if (!sRuntimeClassesLoaded && !this.isRuntimeInstalled()) {
                if (this.isRuntimeOnExternalStorage()) {
                    this.showRuntimeOnExternalStorageDialog();
                } else {
                    this.showRuntimeNotInstalledDialog();
                }

                return;
            }

            this.loadSharedRuntimeDex();
        }

        if (sRuntimeClassesLoaded) {
            this.createActivityWrapper(hasCaptiveRuntime1);
            this.InvokeWrapperOnCreate();
        } else if (hasCaptiveRuntime1) {
            KillSelf();
        } else {
            this.launchAIRService();
        }

    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onCreateContextMenu", new Class[]{ContextMenu.class, View.class, ContextMenu.ContextMenuInfo.class});
            this.InvokeMethod(e, new Object[]{menu, v, menuInfo});
        } catch (Exception var5) {
            var5.printStackTrace();
        }

    }

    public CharSequence onCreateDescription() {
        CharSequence retval = super.onCreateDescription();

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onCreateDescription", new Class[]{CharSequence.class});
            return (CharSequence) this.InvokeMethod(e, new Object[]{retval});
        } catch (Exception var3) {
            var3.printStackTrace();
            return retval;
        }
    }

    protected Dialog onCreateDialog(int id) {
        Dialog retval = super.onCreateDialog(id);

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onCreateDialog", new Class[]{Integer.TYPE, Dialog.class});
            return (Dialog) this.InvokeMethod(e, new Object[]{Integer.valueOf(id), retval});
        } catch (Exception var4) {
            var4.printStackTrace();
            return retval;
        }
    }

    protected Dialog onCreateDialog(int id, Bundle args) {
        Dialog retval = super.onCreateDialog(id, args);

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onCreateDialog", new Class[]{Integer.TYPE, Bundle.class, Dialog.class});
            return (Dialog) this.InvokeMethod(e, new Object[]{Integer.valueOf(id), args, retval});
        } catch (Exception var5) {
            var5.printStackTrace();
            return retval;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        boolean retval = super.onCreateOptionsMenu(menu);

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onCreateOptionsMenu", new Class[]{Menu.class, Boolean.TYPE});
            return ((Boolean) this.InvokeMethod(e, new Object[]{menu, Boolean.valueOf(retval)})).booleanValue();
        } catch (Exception var4) {
            var4.printStackTrace();
            return retval;
        }
    }

    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        boolean retval = super.onCreatePanelMenu(featureId, menu);

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onCreatePanelMenu", new Class[]{Integer.TYPE, Menu.class, Boolean.TYPE});
            return ((Boolean) this.InvokeMethod(e, new Object[]{Integer.valueOf(featureId), menu, Boolean.valueOf(retval)})).booleanValue();
        } catch (Exception var5) {
            var5.printStackTrace();
            return retval;
        }
    }

    public View onCreatePanelView(int featureId) {
        View retval = super.onCreatePanelView(featureId);

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onCreatePanelView", new Class[]{Integer.TYPE, View.class});
            return (View) this.InvokeMethod(e, new Object[]{Integer.valueOf(featureId), retval});
        } catch (Exception var4) {
            var4.printStackTrace();
            return retval;
        }
    }

    public boolean onCreateThumbnail(Bitmap outBitmap, Canvas canvas) {
        boolean retval = super.onCreateThumbnail(outBitmap, canvas);

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onCreateThumbnail", new Class[]{Bitmap.class, Canvas.class, Boolean.TYPE});
            return ((Boolean) this.InvokeMethod(e, new Object[]{outBitmap, canvas, Boolean.valueOf(retval)})).booleanValue();
        } catch (Exception var5) {
            var5.printStackTrace();
            return retval;
        }
    }

    public View onCreateView(String name, Context context, AttributeSet attrs) {
        View retval = super.onCreateView(name, context, attrs);

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onCreateView", new Class[]{String.class, Context.class, AttributeSet.class, View.class});
            return (View) this.InvokeMethod(e, new Object[]{name, context, attrs, retval});
        } catch (Exception var6) {
            var6.printStackTrace();
            return retval;
        }
    }

    public void onDestroy() {
        super.onDestroy();

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onDestroy", new Class[0]);
            this.InvokeMethod(e, new Object[0]);
        } catch (Exception var2) {
            var2.printStackTrace();
        }

        sThis = null;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onDetachedFromWindow", new Class[0]);
            this.InvokeMethod(e, new Object[0]);
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        boolean retval = super.onKeyDown(keyCode, event);

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onKeyDown", new Class[]{Integer.TYPE, KeyEvent.class, Boolean.TYPE});
            return ((Boolean) this.InvokeMethod(e, new Object[]{Integer.valueOf(keyCode), event, Boolean.valueOf(retval)})).booleanValue();
        } catch (Exception var5) {
            var5.printStackTrace();
            return retval;
        }
    }

    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        boolean retval = super.onKeyLongPress(keyCode, event);

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onKeyLongPress", new Class[]{Integer.TYPE, KeyEvent.class, Boolean.TYPE});
            return ((Boolean) this.InvokeMethod(e, new Object[]{Integer.valueOf(keyCode), event, Boolean.valueOf(retval)})).booleanValue();
        } catch (Exception var5) {
            var5.printStackTrace();
            return retval;
        }
    }

    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        boolean retval = super.onKeyMultiple(keyCode, repeatCount, event);

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onKeyMultiple", new Class[]{Integer.TYPE, Integer.TYPE, KeyEvent.class, Boolean.TYPE});
            return ((Boolean) this.InvokeMethod(e, new Object[]{Integer.valueOf(keyCode), Integer.valueOf(repeatCount), event, Boolean.valueOf(retval)})).booleanValue();
        } catch (Exception var6) {
            var6.printStackTrace();
            return retval;
        }
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        boolean retval = super.onKeyUp(keyCode, event);

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onKeyUp", new Class[]{Integer.TYPE, KeyEvent.class, Boolean.TYPE});
            return ((Boolean) this.InvokeMethod(e, new Object[]{Integer.valueOf(keyCode), event, Boolean.valueOf(retval)})).booleanValue();
        } catch (Exception var5) {
            var5.printStackTrace();
            return retval;
        }
    }

    public void onLowMemory() {
        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onLowMemory", new Class[0]);
            this.InvokeMethod(e, new Object[0]);
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

//    public boolean onMenuItemSelected(int featureId, MenuItem item) {
//        boolean retval = super.onMenuItemSelected(featureId, item);
//
//        try {
//            Method e = sAndroidActivityWrapperClass.getMethod("onMenuItemSelected", new Class[]{Integer.TYPE, MenuItem.class, Boolean.TYPE});
//            return ((Boolean) this.InvokeMethod(e, new Object[]{Integer.valueOf(featureId), item, Boolean.valueOf(retval)})).booleanValue();
//        } catch (Exception var5) {
//            var5.printStackTrace();
//            return retval;
//        }
//    }

    public boolean onMenuOpened(int featureId, Menu menu) {
        boolean retval = super.onMenuOpened(featureId, menu);

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onMenuOpened", new Class[]{Integer.TYPE, Menu.class, Boolean.TYPE});
            return ((Boolean) this.InvokeMethod(e, new Object[]{Integer.valueOf(featureId), menu, Boolean.valueOf(retval)})).booleanValue();
        } catch (Exception var5) {
            var5.printStackTrace();
            return retval;
        }
    }

    protected void onNewIntent(Intent aIntent) {
        Intent ii = aIntent;
        super.onNewIntent(aIntent);

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onNewIntent", new Class[]{Intent.class});
            this.InvokeMethod(e, new Object[]{ii});
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        boolean retval = super.onOptionsItemSelected(item);

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onOptionsItemSelected", new Class[]{MenuItem.class, Boolean.TYPE});
            return ((Boolean) this.InvokeMethod(e, new Object[]{item, Boolean.valueOf(retval)})).booleanValue();
        } catch (Exception var4) {
            var4.printStackTrace();
            return retval;
        }
    }

    public void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onOptionsMenuClosed", new Class[]{Menu.class});
            this.InvokeMethod(e, new Object[]{menu});
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    public void onPanelClosed(int featureId, Menu menu) {
        super.onPanelClosed(featureId, menu);

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onPanelClosed", new Class[]{Integer.TYPE, Menu.class});
            this.InvokeMethod(e, new Object[]{Integer.valueOf(featureId), menu});
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    public void onPause() {
        super.onPause();

        try {
            if (sRuntimeClassesLoaded) {
                Method e = sAndroidActivityWrapperClass.getMethod("onPause", new Class[0]);
                this.InvokeMethod(e, new Object[0]);
            }
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        try {
            this.InvokeMethod(AppEntry.sAndroidActivityWrapperClass.getMethod("onPostCreate", Bundle
                    .class), new Object[]{savedInstanceState});
        } catch (Exception v1) {
            v1.printStackTrace();
        }
    }

    protected void onPostResume() {
        super.onPostResume();

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onPostResume", new Class[0]);
            this.InvokeMethod(e, new Object[0]);
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    protected void onPrepareDialog(int id, Dialog dialog) {
        super.onPrepareDialog(id, dialog);

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onPrepareDialog", new Class[]{android.R.id.class, Dialog.class});
            this.InvokeMethod(e, new Object[]{Integer.valueOf(id), dialog});
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    protected void onPrepareDialog(int id, Dialog dialog, Bundle args) {
        super.onPrepareDialog(id, dialog, args);

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onPrepareDialog", new Class[]{android.R.id.class, Dialog.class, Bundle.class});
            this.InvokeMethod(e, new Object[]{Integer.valueOf(id), dialog, args});
        } catch (Exception var5) {
            var5.printStackTrace();
        }

    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean retval = super.onPrepareOptionsMenu(menu);

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onPrepareOptionsMenu", new Class[]{Menu.class, Boolean.TYPE});
            return ((Boolean) this.InvokeMethod(e, new Object[]{menu, Boolean.valueOf(retval)})).booleanValue();
        } catch (Exception var4) {
            var4.printStackTrace();
            return retval;
        }
    }

    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        boolean retval = super.onPreparePanel(featureId, view, menu);

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onPreparePanel", new Class[]{Integer.TYPE, View.class, Menu.class, Boolean.TYPE});
            return ((Boolean) this.InvokeMethod(e, new Object[]{Integer.valueOf(featureId), view, menu, Boolean.valueOf(retval)})).booleanValue();
        } catch (Exception var6) {
            var6.printStackTrace();
            return retval;
        }
    }

    public void onRestart() {
        super.onRestart();

        try {
            if (sRuntimeClassesLoaded) {
                Method e = sAndroidActivityWrapperClass.getMethod("onRestart", new Class[0]);
                this.InvokeMethod(e, new Object[0]);
            }
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onRestoreInstanceState", new Class[]{Bundle.class});
            this.InvokeMethod(e, new Object[]{savedInstanceState});
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    public void onResume() {
        super.onResume();

        try {
            if (sRuntimeClassesLoaded) {
                Method e = sAndroidActivityWrapperClass.getMethod("onResume", new Class[0]);
                this.InvokeMethod(e, new Object[0]);
            }
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

//    public Object onRetainNonConfigurationInstance() {
//        Object retval = super.onRetainNonConfigurationInstance();
//
//        try {
//            Method e = sAndroidActivityWrapperClass.getMethod("onRetainNonConfigurationInstance", new Class[]{Object.class});
//            return this.InvokeMethod(e, new Object[]{retval});
//        } catch (Exception var3) {
//            var3.printStackTrace();
//            return retval;
//        }
//    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onSaveInstanceState", new Class[]{Bundle.class});
            this.InvokeMethod(e, new Object[]{outState});
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    public boolean onSearchRequested() {
        boolean retval = super.onSearchRequested();

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onSearchRequested", new Class[]{Boolean.TYPE});
            return ((Boolean) this.InvokeMethod(e, new Object[]{Boolean.valueOf(retval)})).booleanValue();
        } catch (Exception var3) {
            var3.printStackTrace();
            return retval;
        }
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onStop", new Class[0]);
            this.InvokeMethod(e, new Object[0]);
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onTitleChanged", new Class[]{CharSequence.class, Integer.TYPE});
            this.InvokeMethod(e, new Object[]{title, Integer.valueOf(color)});
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    public boolean onTouchEvent(MotionEvent event) {
        boolean retval = super.onTouchEvent(event);

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onTouchEvent", new Class[]{MotionEvent.class, Boolean.TYPE});
            return ((Boolean) this.InvokeMethod(e, new Object[]{event, Boolean.valueOf(retval)})).booleanValue();
        } catch (Exception var4) {
            var4.printStackTrace();
            return retval;
        }
    }

    public boolean onTrackballEvent(MotionEvent event) {
        boolean retval = super.onTrackballEvent(event);

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onTrackballEvent", new Class[]{MotionEvent.class, Boolean.TYPE});
            return ((Boolean) this.InvokeMethod(e, new Object[]{event, Boolean.valueOf(retval)})).booleanValue();
        } catch (Exception var4) {
            var4.printStackTrace();
            return retval;
        }
    }

    public void onUserInteraction() {
        super.onUserInteraction();

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onUserInteraction", new Class[0]);
            this.InvokeMethod(e, new Object[0]);
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    protected void onUserLeaveHint() {
        super.onUserLeaveHint();

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onUserLeaveHint", new Class[0]);
            this.InvokeMethod(e, new Object[0]);
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams params) {
        super.onWindowAttributesChanged(params);

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onWindowAttributesChanged", new Class[]{WindowManager.LayoutParams.class});
            this.InvokeMethod(e, new Object[]{params});
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        try {
            Method e = sAndroidActivityWrapperClass.getMethod("onWindowFocusChanged", new Class[]{Boolean.TYPE});
            this.InvokeMethod(e, new Object[]{Boolean.valueOf(hasFocus)});
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    private void registerForNotifications() {
        Intent serviceIntent = new Intent("com.adobe.air.AndroidGcmRegistrationService");
        serviceIntent.setClassName(RUNTIME_PACKAGE_ID, "com.adobe.air.AndroidGcmRegistrationService");
        this.startService(serviceIntent);
    }

    private void showDialog(int titleId, String text, int positiveButtonId, int negativeButtonId) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(titleId);
        alertDialogBuilder.setMessage(text);
        alertDialogBuilder.setPositiveButton(positiveButtonId, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                AppEntry.this.launchMarketPlaceForAIR();
                InstallOfferPingUtils.PingAndExit(AppEntry.sThis, AppEntry.AIR_PING_URL, true, false, true);
            }
        });
        alertDialogBuilder.setNegativeButton(negativeButtonId, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                InstallOfferPingUtils.PingAndExit(AppEntry.sThis, AppEntry.AIR_PING_URL, false, false, true);
            }
        });
        alertDialogBuilder.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialog) {
                InstallOfferPingUtils.PingAndExit(AppEntry.sThis, AppEntry.AIR_PING_URL, false, false, true);
            }
        });
        alertDialogBuilder.show();
    }

    private void showRuntimeNotInstalledDialog() {
        ResourceIdMap v0 = new ResourceIdMap("com.dmm.dmmlabo.kancolle.R");
        this.showDialog(v0.getId("string.title_adobe_air"), this.getString(v0.getId("string.text_runtime_required"))
                        + this.getString(v0.getId("string.text_install_runtime")), v0.getId("string.button_install"),
                v0.getId("string.button_exit"));
    }

    private void showRuntimeOnExternalStorageDialog() {
        ResourceIdMap v0 = new ResourceIdMap("com.dmm.dmmlabo.kancolle.R");
        this.showDialog(v0.getId("string.title_adobe_air"), this.getString(v0.getId("string.text_runtime_required"))
                        + this.getString(v0.getId("string.text_runtime_on_external_storage")), v0.getId("string.button_install"),
                v0.getId("string.button_exit"));
    }
}

