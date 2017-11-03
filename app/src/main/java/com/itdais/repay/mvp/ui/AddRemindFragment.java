package com.itdais.repay.mvp.ui;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.itdais.repay.R;
import com.itdais.repay.base.BaseFragment;
import com.itdais.repay.receiver.AlarmReceiver;
import com.itdais.repay.util.DateUtils;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

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
    @BindView(R.id.et_remark)
    EditText etRemark;
    @BindView(R.id.img_bank)
    ImageView imgBank;
    @BindView(R.id.tv_bankName)
    TextView tvBankName;
    @BindView(R.id.tv_bankNumber)
    TextView tvBankNumber;
    @BindView(R.id.btn_save)
    Button btnSave;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_add_remind;
    }

    @Override
    protected void initParams() {
//        remindDao = AppApplication.getInstance().getDaoSession().getRemindDao();
//        bankCardDao = AppApplication.getInstance().getDaoSession().getBankCardDao();
    }

    @Override
    protected void initView(View view) {
//        setToolbarWithBack(toolbar, "添加");
    }

    @OnClick({R.id.tv_remind, R.id.tv_remind_date, R.id.tv_type, R.id.btn_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_remind:
                break;
            case R.id.tv_remind_date:
                break;
            case R.id.tv_type:
                break;
            case R.id.btn_save:
//                得到AlarmManager实例
                Intent intent = new Intent(getActivity(), AlarmReceiver.class);
                PendingIntent pi = PendingIntent.getBroadcast(getActivity(), 0, intent, 0);
                AlarmManager am = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    am.setExact(AlarmManager.ELAPSED_REALTIME, DateUtils.addSecond(new Date(), 30).getTime(), pi);
                } else {
                    am.set(AlarmManager.ELAPSED_REALTIME, DateUtils.addSecond(new Date(), 30).getTime(), pi);
                }
                break;
            default:
                break;
        }
    }

}
