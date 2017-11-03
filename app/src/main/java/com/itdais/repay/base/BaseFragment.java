package com.itdais.repay.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.itdais.repay.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by fcl13761179064 on 2016/8/2.
 */
public abstract class BaseFragment extends Fragment {
    private ProgressDialog progressDialog;
    protected BaseActivity mBaseActivity;
    private Unbinder unbinder;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof BaseActivity) {
            mBaseActivity = (BaseActivity) activity;
            mBaseActivity.setFunctionsForFragment(getClass().getSimpleName());
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initParams();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        initView(view);
        initListener();
    }

    protected void initParams() {
    }

    protected abstract int getLayoutId();

    protected abstract void initView(View view);

    protected void initListener() {

    }

    protected void initData() {

    }

    public void setToolbar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        setHasOptionsMenu(true);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
    }

    public void setToolbarWithBack(Toolbar toolbar, String title) {
        setToolbarWithBack(toolbar, title, null);
    }

    public void setToolbarWithBack(Toolbar toolbar, String title, View.OnClickListener mListener) {
        setToolbar(toolbar, title);
        if (mListener != null) {
            toolbar.setNavigationOnClickListener(mListener);
        } else {
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getFragmentManager().popBackStack();
                }
            });
        }
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            //设置返回键
            actionBar.setDisplayHomeAsUpEnabled(true);
            //设置Title不可用
//            actionBar.setDisplayShowTitleEnabled(false);
        }
    }

    public int getMenuId() {
        return 0;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        if (getMenuId() > 0) {
            inflater.inflate(getMenuId(), menu);
        }
    }

    public void showProgressDialog() {
        showProgressDialog("加载中...");
    }

    public void showProgressDialog(String msg) {
        if (progressDialog == null) {
            progressDialog = ProgressDialog.show(getActivity(), "", msg);
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
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        hideProgressDialog();
    }

}