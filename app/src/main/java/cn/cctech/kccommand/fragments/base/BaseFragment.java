package cn.cctech.kccommand.fragments.base;

import android.os.Bundle;

import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;

public class BaseFragment extends LazyFragment {

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        try {
            EventBus.getDefault().register(this);
        } catch (Exception e) {
            Logger.e(e, e.getMessage());
        }
    }

    @Override
    protected void onDestroyViewLazy() {
        super.onDestroyViewLazy();
        try {
            EventBus.getDefault().unregister(this);
        } catch (Exception e) {
            Logger.e(e, e.getMessage());
        }
    }
}
