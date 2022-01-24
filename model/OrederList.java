package moe.shuvi.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author qianjianyu
 */
@Entity(name = "ORDERLIST")
public class OrederList implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer orderId;
    private Integer goodsId;
    private String goodsSN;
    private String goodsName;
    private String goodsFormat;
    private Integer goodsNum;
    private Double eachPrice;
    private Double sumPrice;
    private Double discount;
    private String currency;
    private Double realPv;
    private Double pvRate;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;
    private Integer Del;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsSN() {
        return goodsSN;
    }

    public void setGoodsSN(String goodsSN) {
        this.goodsSN = goodsSN;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsFormat() {
        return goodsFormat;
    }

    public void setGoodsFormat(String goodsFormat) {
        this.goodsFormat = goodsFormat;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Double getEachPrice() {
        return eachPrice;
    }

    public void setEachPrice(Double eachPrice) {
        this.eachPrice = eachPrice;
    }

    public Double getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(Double sumPrice) {
        this.sumPrice = sumPrice;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getRealPv() {
        return realPv;
    }

    public void setRealPv(Double realPv) {
        this.realPv = realPv;
    }

    public Double getPvRate() {
        return pvRate;
    }

    public void setPvRate(Double pvRate) {
        this.pvRate = pvRate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getDel() {
        return Del;
    }

    public void setDel(Integer del) {
        Del = del;
    }

    @Override
    public String toString() {
        return "OrederList{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", goodsId=" + goodsId +
                ", goodsSN='" + goodsSN + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsFormat='" + goodsFormat + '\'' +
                ", goodsNum=" + goodsNum +
                ", eachPrice=" + eachPrice +
                ", sumPrice=" + sumPrice +
                ", discount=" + discount +
                ", currency='" + currency + '\'' +
                ", realPv=" + realPv +
                ", pvRate=" + pvRate +
                ", createTime=" + createTime +
                ", Del=" + Del +
                '}';
    }


}
