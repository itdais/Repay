package com.itdais.repay.mvp.ui;


import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.itdais.repay.R;
import com.itdais.repay.app.function.FunctionManager;
import com.itdais.repay.app.function.NoFunctionException;
import com.itdais.repay.base.BaseFragment;

import butterknife.BindView;

/**
 * 设置
 *
 * @author 丁军伟
 * @date 2017/10/19
 */
public class SettingFragment extends BaseFragment {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_setting;
    }

    @Override
    protected void initView(View view) {
        setToolbarWithBack(toolbar, "设置");
    }
}
