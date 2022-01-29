package moe.shuvi.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author qianjianyu
 */
@Entity(name = "ORDER")
@Table(name = "s_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date orderTime;
    private String orderSN;
    private Integer pickUserId;
    private Integer buyUserId;
    private Double repeatPv;
    private Double basePv;
    private Double serviceFee;
    private Double shipFre;
    private Double tax;
    private String country;
    private String email;
    private String userAddress;
    private Integer postcode;
    private Integer stat;
    private String shipType;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date shipTime;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date receiveTime;
    private String shipNote;
    private Integer del;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderSN() {
        return orderSN;
    }

    public void setOrderSN(String orderSN) {
        this.orderSN = orderSN;
    }

    public Integer getPickUserId() {
        return pickUserId;
    }

    public void setPickUserId(Integer pickUserId) {
        this.pickUserId = pickUserId;
    }

    public Integer getBuyUserId() {
        return buyUserId;
    }

    public void setBuyUserId(Integer buyUserId) {
        this.buyUserId = buyUserId;
    }

    public Double getRepeatPv() {
        return repeatPv;
    }

    public void setRepeatPv(Double repeatPv) {
        this.repeatPv = repeatPv;
    }

    public Double getBasePv() {
        return basePv;
    }

    public void setBasePv(Double basePv) {
        this.basePv = basePv;
    }

    public Double getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(Double serviceFee) {
        this.serviceFee = serviceFee;
    }

    public Double getShipFre() {
        return shipFre;
    }

    public void setShipFre(Double shipFre) {
        this.shipFre = shipFre;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public Integer getPostcode() {
        return postcode;
    }

    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }

    public Integer getStat() {
        return stat;
    }

    public void setStat(Integer stat) {
        this.stat = stat;
    }

    public String getShipType() {
        return shipType;
    }

    public void setShipType(String shipType) {
        this.shipType = shipType;
    }

    public Date getShipTime() {
        return shipTime;
    }

    public void setShipTime(Date shipTime) {
        this.shipTime = shipTime;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getShipNote() {
        return shipNote;
    }

    public void setShipNote(String shipNote) {
        this.shipNote = shipNote;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderTime=" + orderTime +
                ", orderSN='" + orderSN + '\'' +
                ", pickUserId=" + pickUserId +
                ", buyUserId=" + buyUserId +
                ", repeatPv=" + repeatPv +
                ", basePv=" + basePv +
                ", serviceFee=" + serviceFee +
                ", shipFre=" + shipFre +
                ", tax=" + tax +
                ", country='" + country + '\'' +
                ", email='" + email + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", postcode=" + postcode +
                ", stat=" + stat +
                ", shipType='" + shipType + '\'' +
                ", shipTime=" + shipTime +
                ", receiveTime=" + receiveTime +
                ", shipNote='" + shipNote + '\'' +
                ", del=" + del +
                '}';
    }
}
