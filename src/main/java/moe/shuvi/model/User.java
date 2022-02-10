package moe.shuvi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.mapping.ToOne;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author qianjianyu
 * @date 2022/1/23 0023  17:00
 */
@Entity
@Table(name = "s_user")
//@SQLDelete(sql = "/")
@Where(clause = "del = 1")
//生成时间戳,@CreatedDate
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String loginCode;
    private String password;
    private String password2;
    private String username;
    private Integer sex;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private Integer cardType;
    private String cardTypeName;
    private String idCard;
    private String country;
    private String mobile;
    private String email;
    private String userAddress;
    private Integer postCode;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @CreatedDate
    @Column(name = "createTime", updatable = false, nullable = false)
    private Date createTime;
    private Integer referId;
    private String referCode;
    private Integer roleId;
    //    private String roleName;
    private Integer userType;
    //    private String userTYpeName;
    private Integer isStart;
    //    @Column(name = "del", updatable = false,nullable = false)
//    @Transient
//    private Integer del;'
    @OneToOne
    @JoinColumn(name = "userType",referencedColumnName="typeCode",insertable = false,updatable = false)
    private Dictionary dictionary;
    @OneToOne
    @JoinColumn(name = "roleId",referencedColumnName="roleCode",insertable = false,updatable = false)
    private Role role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginCode() {
        return loginCode;
    }

    public void setLoginCode(String loginCode) {
        this.loginCode = loginCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public String getCardTypeName() {
        return cardTypeName;
    }

    public void setCardTypeName(String cardTypeName) {
        this.cardTypeName = cardTypeName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public Integer getPostCode() {
        return postCode;
    }

    public void setPostCode(Integer postCode) {
        this.postCode = postCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getReferId() {
        return referId;
    }

    public void setReferId(Integer referId) {
        this.referId = referId;
    }

    public String getReferCode() {
        return referCode;
    }

    public void setReferCode(String referCode) {
        this.referCode = referCode;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

//    public String getRoleName() {
//        return roleName;
//    }
//
//    public void setRoleName(String roleName) {
//        this.roleName = roleName;
//    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }
//
//    public String getUserTYpeName() {
//        return userTYpeName;
//    }
//
//    public void setUserTYpeName(String userTYpeName) {
//        this.userTYpeName = userTYpeName;
//    }

    public Integer getIsStart() {
        return isStart;
    }

    public void setIsStart(Integer isStart) {
        this.isStart = isStart;
    }

//    public Integer getDel() {
//        return del;
//    }
//
//    public void setDel(Integer del) {
//        this.del = del;
//    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", loginCode='" + loginCode + '\'' +
                ", password='" + password + '\'' +
                ", password2='" + password2 + '\'' +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", cardType=" + cardType +
                ", cardTypeName='" + cardTypeName + '\'' +
                ", idCard='" + idCard + '\'' +
                ", country='" + country + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", postCode=" + postCode +
                ", createTime=" + createTime +
                ", referId=" + referId +
                ", referCode='" + referCode + '\'' +
                ", roleId=" + roleId +
                ", userType=" + userType +
                ", isStart=" + isStart +
                ", dictionary=" + dictionary +
                ", role=" + role +
                '}';
    }
}
