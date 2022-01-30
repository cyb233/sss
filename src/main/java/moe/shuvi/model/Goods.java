package moe.shuvi.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author qianjianyu
 */
@Entity
@Table(name = "s_goods")
public class Goods implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String goodsSN;
    private String goodsName;
    private String goodsFormat;
    private Double marketPrice;
    private Integer state;
    private String note;
    private Integer num;
    private String unit;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date lastUpateTime;
    private String reatedBy;
    private Integer del;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpateTime() {
        return lastUpateTime;
    }

    public void setLastUpateTime(Date lastUpateTime) {
        this.lastUpateTime = lastUpateTime;
    }

    public String getReatedBy() {
        return reatedBy;
    }

    public void setReatedBy(String reatedBy) {
        this.reatedBy = reatedBy;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goodsSN='" + goodsSN + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsFormat='" + goodsFormat + '\'' +
                ", marketPrice=" + marketPrice +
                ", state=" + state +
                ", note='" + note + '\'' +
                ", num=" + num +
                ", unit='" + unit + '\'' +
                ", createTime=" + createTime +
                ", lastUpateTime=" + lastUpateTime +
                ", reatedBy='" + reatedBy + '\'' +
                ", del=" + del +
                '}';
    }
}
