package com.itdais.repay.data.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @描述
 * @作者 丁军伟
 * @时间 2017/10/23
 */
@Entity
public class BankCard {
    @Id(autoincrement = true)
    private Long _id;
    /**
     * 1 花呗 2白条 3信用卡
     */
    private int bankId;
    private String bank;
    private String cardNumber;
    private String cardType;
    private String userName;
    private String userMobile;
    private String userIdCard;
    /**
     * 账单日
     */
    private String statementDate;
    /**
     * 还款日
     */
    private String repaymentDate;
    /**
     * 备注
     */
    private String remark;
    @Generated(hash = 869675415)
    public BankCard(Long _id, int bankId, String bank, String cardNumber,
            String cardType, String userName, String userMobile, String userIdCard,
            String statementDate, String repaymentDate, String remark) {
        this._id = _id;
        this.bankId = bankId;
        this.bank = bank;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.userName = userName;
        this.userMobile = userMobile;
        this.userIdCard = userIdCard;
        this.statementDate = statementDate;
        this.repaymentDate = repaymentDate;
        this.remark = remark;
    }
    @Generated(hash = 1025789730)
    public BankCard() {
    }
    public Long get_id() {
        return this._id;
    }
    public void set_id(Long _id) {
        this._id = _id;
    }
    public int getBankId() {
        return this.bankId;
    }
    public void setBankId(int bankId) {
        this.bankId = bankId;
    }
    public String getBank() {
        return this.bank;
    }
    public void setBank(String bank) {
        this.bank = bank;
    }
    public String getCardNumber() {
        return this.cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public String getCardType() {
        return this.cardType;
    }
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserMobile() {
        return this.userMobile;
    }
    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }
    public String getUserIdCard() {
        return this.userIdCard;
    }
    public void setUserIdCard(String userIdCard) {
        this.userIdCard = userIdCard;
    }
    public String getStatementDate() {
        return this.statementDate;
    }
    public void setStatementDate(String statementDate) {
        this.statementDate = statementDate;
    }
    public String getRepaymentDate() {
        return this.repaymentDate;
    }
    public void setRepaymentDate(String repaymentDate) {
        this.repaymentDate = repaymentDate;
    }
    public String getRemark() {
        return this.remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
}
