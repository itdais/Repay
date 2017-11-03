package com.itdais.repay.data.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @描述  收入支付
 * @作者 丁军伟
 * @时间 2017/10/23
 */
@Entity
public class IncomeExpense {
    @Id(autoincrement = true)
    private Long _id;

    private String date;

    private String money;
    /**
     *  分类 1 收入 2支出
     */
    private int type;
    /**
     * 小的分类
     * 1 收入:  10工资 11个人所得 12兼职 13奖金  14福利 99其他
     * 2 支出:  20房贷 33车贷 34信用贷 21消费 22转账 23餐饮 24交通 25娱乐 26购物 17通讯 28红包 29生活 30租房 31一楼 32教育    99其他
     */
    private int smallType;
    /**
     * 消费地址
     */
    private String address;
    /**
     * 消费店铺
     */
    private String shop;

    /**
     * 支付类型
     * 1现金 2支付宝 3微信 4银行卡 5信用卡 6其他
     */
    private int payType;
    /**
     * 备注
     */
    private String remarks;
    @Generated(hash = 1929992582)
    public IncomeExpense(Long _id, String date, String money, int type, int smallType, String address,
            String shop, int payType, String remarks) {
        this._id = _id;
        this.date = date;
        this.money = money;
        this.type = type;
        this.smallType = smallType;
        this.address = address;
        this.shop = shop;
        this.payType = payType;
        this.remarks = remarks;
    }
    @Generated(hash = 1357755156)
    public IncomeExpense() {
    }
    public Long get_id() {
        return this._id;
    }
    public void set_id(Long _id) {
        this._id = _id;
    }
    public String getDate() {
        return this.date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getMoney() {
        return this.money;
    }
    public void setMoney(String money) {
        this.money = money;
    }
    public int getType() {
        return this.type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public int getSmallType() {
        return this.smallType;
    }
    public void setSmallType(int smallType) {
        this.smallType = smallType;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getShop() {
        return this.shop;
    }
    public void setShop(String shop) {
        this.shop = shop;
    }
    public int getPayType() {
        return this.payType;
    }
    public void setPayType(int payType) {
        this.payType = payType;
    }
    public String getRemarks() {
        return this.remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}
