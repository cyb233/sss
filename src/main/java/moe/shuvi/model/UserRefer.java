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
@Table(name = "s_userRefer")
@Where(clause = "del = 1")
//生成时间戳,@CreatedDate
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
public class UserRefer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date referTime;
    private Integer referId;
    private Double buyPv;
    private Double bonusRate;
    private Double bonusPv;
    private Integer del;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getReferTime() {
        return referTime;
    }

    public void setReferTime(Date referTime) {
        this.referTime = referTime;
    }

    public Integer getReferId() {
        return referId;
    }

    public void setReferId(Integer referId) {
        this.referId = referId;
    }

    public Double getBuyPv() {
        return buyPv;
    }

    public void setBuyPv(Double buyPv) {
        this.buyPv = buyPv;
    }

    public Double getBonusRate() {
        return bonusRate;
    }

    public void setBonusRate(Double bonusRate) {
        this.bonusRate = bonusRate;
    }

    public Double getBonusPv() {
        return bonusPv;
    }

    public void setBonusPv(Double bonusPv) {
        this.bonusPv = bonusPv;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    @Override
    public String toString() {
        return "UserRefer{" +
                "id=" + id +
                ", referTime=" + referTime +
                ", referId=" + referId +
                ", buyPv=" + buyPv +
                ", bonusRate=" + bonusRate +
                ", bonusPv=" + bonusPv +
                ", del=" + del +
                '}';
    }
}
