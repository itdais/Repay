package com.itdais.repay.mvp.ui;


import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.itdais.repay.AppApplication;
import com.itdais.repay.R;
import com.itdais.repay.base.BaseFragment;
import com.itdais.repay.data.bean.BankCardDao;
import com.itdais.repay.data.bean.RemindDao;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 设置
 *
 * @author 丁军伟
 * @date 2017/10/19
 */
public class AddRemindFragment extends BaseFragment {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_remind)
    TextView tvRemind;
    @BindView(R.id.tv_remind_date)
    TextView tvRemindDate;
    @BindView(R.id.et_money)
    EditText etMoney;
    @BindView(R.id.et_cycle)
    EditText etCycle;
    @BindView(R.id.tv_type)
    TextView tvType;
    @BindView(R.id.tv_userName)
    EditText tvUserName;
    @BindView(R.id.tv_bank)
    TextView tvBank;
    @BindView(R.id.et_bankNumber)
    EditText etBankNumber;
    @BindView(R.id.et_mobile)
    EditText etMobile;
    @BindView(R.id.et_remark)
    EditText etRemark;
    @BindView(R.id.btn_save)
    Button btnSave;
    private RemindDao remindDao;
    private BankCardDao bankCardDao;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_add_remind;
    }

    @Override
    protected void initParams() {
        remindDao = AppApplication.getInstance().getDaoSession().getRemindDao();
        bankCardDao = AppApplication.getInstance().getDaoSession().getBankCardDao();
    }

    @Override
    protected void initView(View view) {
        setToolbarWithBack(toolbar, "添加");
    }

    @OnClick({R.id.tv_remind, R.id.tv_remind_date, R.id.tv_type, R.id.tv_bank, R.id.btn_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_remind:
                break;
            case R.id.tv_remind_date:
                break;
            case R.id.tv_type:
                break;
            case R.id.tv_bank:
                break;
            case R.id.btn_save:

                break;
        }
    }
}
