package com.itdais.repay.base;

import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.itdais.repay.app.function.FunctionManager;
import com.itdais.repay.mvp.ui.MainFragment;
import com.itdais.repay.util.AppManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Activity的基类
 * author  fanchunlei
 */
public abstract class BaseActivity extends AppCompatActivity {
    private Unbinder unbinder;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);// 锁定竖屏
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        setStatusBar();
        initViews();
        initListener();
        initDate();
        AppManager.getAppManager().addActivity(this);
    }

    protected void setStatusBar() {

    }

    protected abstract int getLayoutId();

    protected abstract void initViews();

    protected void initListener() {

    }

    protected void initDate() {

    }

    public void setToolbar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
    }

    public void setToolbarWithBack(Toolbar toolbar, String title) {
        setToolbarWithBack(toolbar, title, null);
    }

    public void setToolbarWithBack(Toolbar toolbar, String title, View.OnClickListener mListener) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        if (mListener != null) {
            toolbar.setNavigationOnClickListener(mListener);
        } else {
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //设置返回键
            actionBar.setDisplayHomeAsUpEnabled(true);
            //设置Title不可用
//            actionBar.setDisplayShowTitleEnabled(false);
        }
    }

    public void showProgressDialog() {
        showProgressDialog("加载中...");
    }

    public void showProgressDialog(String msg) {
        if (progressDialog == null) {
            progressDialog = ProgressDialog.show(this, "", msg);
        }
        if (progressDialog.isShowing()) {
            progressDialog.setMessage(msg);
            return;
        }
        progressDialog.show();
    }

    public void hideProgressDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        hideProgressDialog();
        unbinder.unbind();
        AppManager.getAppManager().finishActivity();
    }

    public void setFunctionsForFragment(String tag) {
    }
}
