package com.itdais.repay.mvp.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.itdais.repay.R;
import com.itdais.repay.app.function.FunctionManager;
import com.itdais.repay.app.function.NoFunctionException;
import com.itdais.repay.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 设置
 *
 * @author 丁军伟
 * @date 2017/10/19
 */
public class MainFragment extends BaseFragment {
    public static final String FUNCTION_SETTING = "setting";
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btn_add)
    ImageView btnAdd;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView(View view) {
        setToolbar(toolbar, "还贷");
    }

    @OnClick({R.id.btn_add})
    public void onViewClicked(View v) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString(MainActivity.BUNDLE_FRGNAME, AddRemindFragment.class.getName());
            FunctionManager.getInstance().invokeFunc(MainActivity.FRAGMENT_SWITCH, bundle);
        } catch (NoFunctionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getMenuId() {
        return R.menu.main;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_setting:
                try {
                    Bundle bundle = new Bundle();
                    bundle.putString(MainActivity.BUNDLE_FRGNAME, SettingFragment.class.getName());
                    FunctionManager.getInstance().invokeFunc(MainActivity.FRAGMENT_SWITCH, bundle);
                } catch (NoFunctionException e) {
                    e.printStackTrace();
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
