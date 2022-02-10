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
@Table(name = "s_userAccount")
@Where(clause = "del = 1")
//生成时间戳,@CreatedDate
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
public class UserAccount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date accountDate;
    private String stat;
    private String baseIn;
    private String baseOut;
    private String baseBalance;
    private String repeatIn;
    private String repeatOut;
    private String repeatBalance;
    private Double freePv;
    private Double alreadyPv;
    private Double buyPv;
    private Integer del;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(Date accountDate) {
        this.accountDate = accountDate;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getBaseIn() {
        return baseIn;
    }

    public void setBaseIn(String baseIn) {
        this.baseIn = baseIn;
    }

    public String getBaseOut() {
        return baseOut;
    }

    public void setBaseOut(String baseOut) {
        this.baseOut = baseOut;
    }

    public String getBaseBalance() {
        return baseBalance;
    }

    public void setBaseBalance(String baseBalance) {
        this.baseBalance = baseBalance;
    }

    public String getRepeatIn() {
        return repeatIn;
    }

    public void setRepeatIn(String repeatIn) {
        this.repeatIn = repeatIn;
    }

    public String getRepeatOut() {
        return repeatOut;
    }

    public void setRepeatOut(String repeatOut) {
        this.repeatOut = repeatOut;
    }

    public String getRepeatBalance() {
        return repeatBalance;
    }

    public void setRepeatBalance(String repeatBalance) {
        this.repeatBalance = repeatBalance;
    }

    public Double getFreePv() {
        return freePv;
    }

    public void setFreePv(Double freePv) {
        this.freePv = freePv;
    }

    public Double getAlreadyPv() {
        return alreadyPv;
    }

    public void setAlreadyPv(Double alreadyPv) {
        this.alreadyPv = alreadyPv;
    }

    public Double getBuyPv() {
        return buyPv;
    }

    public void setBuyPv(Double buyPv) {
        this.buyPv = buyPv;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "id=" + id +
                ", userId=" + userId +
                ", accountDate=" + accountDate +
                ", stat='" + stat + '\'' +
                ", baseIn='" + baseIn + '\'' +
                ", baseOut='" + baseOut + '\'' +
                ", baseBalance='" + baseBalance + '\'' +
                ", repeatIn='" + repeatIn + '\'' +
                ", repeatOut='" + repeatOut + '\'' +
                ", repeatBalance='" + repeatBalance + '\'' +
                ", freePv=" + freePv +
                ", alreadyPv=" + alreadyPv +
                ", buyPv=" + buyPv +
                ", del=" + del +
                '}';
    }
}
