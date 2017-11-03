package com.itdais.repay.data.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @描述 账单
 * @作者 丁军伟
 * @时间 2017/10/19
 */
@Entity
public class Remind {
    @Id(autoincrement = true)
    private Long _id;
    private Long bankCardId;
    /**
     * 还款总金额
     */
    private String totalMoney;
    /**
     * 每次还款金额
     */
    private String money;
    /**
     * 已还金额
     */
    private String repaidMoney;
    /**
     * 还款总期数
     */
    private int payCycle;
    /**
     * 剩余期数
     */
    private int residualCycle;
    /**
     * 提醒日期
     */
    private String remindDate;
    /**
     * 提醒方式
     */
    private int remindMode;
    /**
     * 提醒类型
     */
    private int type;
    /**
     * 额外类型
     */
    private String typeExtra;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 0 有效 1无效
     */
    private int overdue;
    @Generated(hash = 1628303206)
    public Remind(Long _id, Long bankCardId, String totalMoney, String money,
            String repaidMoney, int payCycle, int residualCycle, String remindDate,
            int remindMode, int type, String typeExtra, String remarks,
            int overdue) {
        this._id = _id;
        this.bankCardId = bankCardId;
        this.totalMoney = totalMoney;
        this.money = money;
        this.repaidMoney = repaidMoney;
        this.payCycle = payCycle;
        this.residualCycle = residualCycle;
        this.remindDate = remindDate;
        this.remindMode = remindMode;
        this.type = type;
        this.typeExtra = typeExtra;
        this.remarks = remarks;
        this.overdue = overdue;
    }
    @Generated(hash = 1173539496)
    public Remind() {
    }
    public Long get_id() {
        return this._id;
    }
    public void set_id(Long _id) {
        this._id = _id;
    }
    public Long getBankCardId() {
        return this.bankCardId;
    }
    public void setBankCardId(Long bankCardId) {
        this.bankCardId = bankCardId;
    }
    public String getTotalMoney() {
        return this.totalMoney;
    }
    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }
    public String getMoney() {
        return this.money;
    }
    public void setMoney(String money) {
        this.money = money;
    }
    public String getRepaidMoney() {
        return this.repaidMoney;
    }
    public void setRepaidMoney(String repaidMoney) {
        this.repaidMoney = repaidMoney;
    }
    public int getPayCycle() {
        return this.payCycle;
    }
    public void setPayCycle(int payCycle) {
        this.payCycle = payCycle;
    }
    public int getResidualCycle() {
        return this.residualCycle;
    }
    public void setResidualCycle(int residualCycle) {
        this.residualCycle = residualCycle;
    }
    public String getRemindDate() {
        return this.remindDate;
    }
    public void setRemindDate(String remindDate) {
        this.remindDate = remindDate;
    }
    public int getRemindMode() {
        return this.remindMode;
    }
    public void setRemindMode(int remindMode) {
        this.remindMode = remindMode;
    }
    public int getType() {
        return this.type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public String getTypeExtra() {
        return this.typeExtra;
    }
    public void setTypeExtra(String typeExtra) {
        this.typeExtra = typeExtra;
    }
    public String getRemarks() {
        return this.remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public int getOverdue() {
        return this.overdue;
    }
    public void setOverdue(int overdue) {
        this.overdue = overdue;
    }

}
