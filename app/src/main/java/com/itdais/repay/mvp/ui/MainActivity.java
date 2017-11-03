package com.itdais.repay.mvp.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.itdais.repay.R;
import com.itdais.repay.app.function.FunctionManager;
import com.itdais.repay.app.function.FunctionNoParamAndResult;
import com.itdais.repay.app.function.FunctionWithParam;
import com.itdais.repay.base.BaseActivity;

public class MainActivity extends BaseActivity {
    private FragmentManager fm;
    private FragmentTransaction ft;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    private MainFragment mainFragment;

    @Override
    protected void initViews() {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        mainFragment = new MainFragment();
        ft.add(R.id.fragment_container, mainFragment, "main").addToBackStack("main").hide(mainFragment).show(mainFragment);
        ft.commit();
    }

    public static final String FRAGMENT_SWITCH = "switch";
    public static final String BUNDLE_FRGNAME = "frgName";
    public static final String BUNDLE_STACK = "addToBackStack";

    @Override
    public void setFunctionsForFragment(String tag) {
        FunctionManager.getInstance()
                .addFunction(new FunctionWithParam<Bundle>(FRAGMENT_SWITCH) {
                    @Override
                    public void function(Bundle bundle) {
                        try {
                            ft = fm.beginTransaction();
                            String frgName = bundle.getString(BUNDLE_FRGNAME);
                            Fragment fragment = fm.findFragmentByTag(frgName);
                            if (fragment != null) {
                                fm.popBackStackImmediate(frgName, 0);
                                return;
                            } else {
                                fragment = (Fragment) Class.forName(frgName).newInstance();
                            }

                            Fragment fragmentContainer = fm.findFragmentById(R.id.fragment_container);
                            if (fragmentContainer != null) {
                                ft.hide(fragmentContainer);
                            }
                            ft.add(R.id.fragment_container, fragment, frgName);
                            if (bundle.getBoolean(BUNDLE_STACK)) {
                                ft.addToBackStack(frgName);
                            } else {
                                ft.addToBackStack(null);
                            }
                            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commitAllowingStateLoss();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
