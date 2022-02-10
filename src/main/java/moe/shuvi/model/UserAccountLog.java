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
@Table(name = "s_userAccountLog")
@Where(clause = "del = 1")
//生成时间戳,@CreatedDate
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
public class UserAccountLog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date actionTime;
    private String actionDesc;
    private String actionType;
    private String baseIn;
    private String baseOut;
    private String baseBalance;
    private String repeatIn;
    private String repeatOut;
    private String repeatBalance;
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

    public Date getActionTime() {
        return actionTime;
    }

    public void setActionTime(Date actionTime) {
        this.actionTime = actionTime;
    }

    public String getActionDesc() {
        return actionDesc;
    }

    public void setActionDesc(String actionDesc) {
        this.actionDesc = actionDesc;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
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

    public String getRepratIn() {
        return repeatIn;
    }

    public void setRepratIn(String repratIn) {
        this.repeatIn = repratIn;
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

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    @Override
    public String toString() {
        return "UserAccountLog{" +
                "id=" + id +
                ", userId=" + userId +
                ", actionTime=" + actionTime +
                ", actionDesc='" + actionDesc + '\'' +
                ", actionType='" + actionType + '\'' +
                ", baseIn='" + baseIn + '\'' +
                ", baseOut='" + baseOut + '\'' +
                ", baseBalance='" + baseBalance + '\'' +
                ", repratIn='" + repeatIn + '\'' +
                ", repeatOut='" + repeatOut + '\'' +
                ", repeatBalance='" + repeatBalance + '\'' +
                ", del=" + del +
                '}';
    }
}
