package moe.shuvi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author qianjianyu
 */
@Entity
@Table(name = "s_userCash")
@Where(clause = "del = 1")
//生成时间戳,@CreatedDate
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
public class UserCash implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date cashTime;
    private Integer cashNum;
    private Integer userId;
    private Double cashPv;
    private String currency;
    private Double cashMoney;
    private String note;
    private Double fee;
    private Double tax;
    private Double otherFee;
    private String bankName;
    private String bankBrance;
    private String bankAccount;
    private String accountName;
    private Integer stat;
    private Double creditedMoney;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date creditedTime;
    private String operator;
    private Integer del;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCashTime() {
        return cashTime;
    }

    public void setCashTime(Date cashTime) {
        this.cashTime = cashTime;
    }

    public Integer getCashNum() {
        return cashNum;
    }

    public void setCashNum(Integer cashNum) {
        this.cashNum = cashNum;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getCashPv() {
        return cashPv;
    }

    public void setCashPv(Double cashPv) {
        this.cashPv = cashPv;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getCashMoney() {
        return cashMoney;
    }

    public void setCashMoney(Double cashMoney) {
        this.cashMoney = cashMoney;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getOtherFee() {
        return otherFee;
    }

    public void setOtherFee(Double otherFee) {
        this.otherFee = otherFee;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankBrance() {
        return bankBrance;
    }

    public void setBankBrance(String bankBrance) {
        this.bankBrance = bankBrance;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Integer getStat() {
        return stat;
    }

    public void setStat(Integer stat) {
        this.stat = stat;
    }

    public Double getCreditedMoney() {
        return creditedMoney;
    }

    public void setCreditedMoney(Double creditedMoney) {
        this.creditedMoney = creditedMoney;
    }

    public Date getCreditedTime() {
        return creditedTime;
    }

    public void setCreditedTime(Date creditedTime) {
        this.creditedTime = creditedTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    @Override
    public String toString() {
        return "UserCash{" +
                "id=" + id +
                ", cashTime=" + cashTime +
                ", cashNum=" + cashNum +
                ", userId=" + userId +
                ", cashPv=" + cashPv +
                ", currency='" + currency + '\'' +
                ", cashMoney=" + cashMoney +
                ", note='" + note + '\'' +
                ", fee=" + fee +
                ", tax=" + tax +
                ", otherFee=" + otherFee +
                ", bankName='" + bankName + '\'' +
                ", bankBrance='" + bankBrance + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", accountName='" + accountName + '\'' +
                ", stat=" + stat +
                ", creditedMoney=" + creditedMoney +
                ", creditedTime=" + creditedTime +
                ", operator='" + operator + '\'' +
                ", del=" + del +
                '}';
    }
}
