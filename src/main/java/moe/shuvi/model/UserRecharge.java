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
@Table(name = "s_userRecharge")
@Where(clause = "del = 1")
//生成时间戳,@CreatedDate
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
public class UserRecharge implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date rechargeTime;
    private Integer rechargeNum;
    private Integer userId;
    private String cirrency;
    private Double rechargeMoney;
    private String note;
    private Double creditedMoney;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date creditedTime;
    private String auditUser;
    private String pvRete;
    private String pv;
    private String bankName;
    private String bankAccount;
    private String platform;
    private String param;
    private Integer del;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRechargeTime() {
        return rechargeTime;
    }

    public void setRechargeTime(Date rechargeTime) {
        this.rechargeTime = rechargeTime;
    }

    public Integer getRechargeNum() {
        return rechargeNum;
    }

    public void setRechargeNum(Integer rechargeNum) {
        this.rechargeNum = rechargeNum;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCirrency() {
        return cirrency;
    }

    public void setCirrency(String cirrency) {
        this.cirrency = cirrency;
    }

    public Double getRechargeMoney() {
        return rechargeMoney;
    }

    public void setRechargeMoney(Double rechargeMoney) {
        this.rechargeMoney = rechargeMoney;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public String getAuditUser() {
        return auditUser;
    }

    public void setAuditUser(String auditUser) {
        this.auditUser = auditUser;
    }

    public String getPvRete() {
        return pvRete;
    }

    public void setPvRete(String pvRete) {
        this.pvRete = pvRete;
    }

    public String getPv() {
        return pv;
    }

    public void setPv(String pv) {
        this.pv = pv;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    @Override
    public String toString() {
        return "UserRecharge{" +
                "id=" + id +
                ", rechargeTime=" + rechargeTime +
                ", rechargeNum=" + rechargeNum +
                ", userId=" + userId +
                ", cirrency='" + cirrency + '\'' +
                ", rechargeMoney=" + rechargeMoney +
                ", note='" + note + '\'' +
                ", creditedMoney=" + creditedMoney +
                ", creditedTime=" + creditedTime +
                ", auditUser='" + auditUser + '\'' +
                ", pvRete='" + pvRete + '\'' +
                ", pv='" + pv + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", platform='" + platform + '\'' +
                ", param='" + param + '\'' +
                ", del=" + del +
                '}';
    }
}
