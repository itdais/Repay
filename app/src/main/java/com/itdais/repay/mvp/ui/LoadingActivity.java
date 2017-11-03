package com.itdais.repay.mvp.ui;

import android.content.Intent;
import android.os.Handler;

import com.itdais.repay.R;
import com.itdais.repay.base.BaseActivity;
import com.itdais.repay.util.StatusBarUtil;

/**
 * @author user
 */
public class LoadingActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_loading;
    }

    @Override
    protected void setStatusBar() {
        StatusBarUtil.setTransparentForWindow(this);
    }

    @Override
    protected void initViews() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LoadingActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }, 1600);
    }

}
