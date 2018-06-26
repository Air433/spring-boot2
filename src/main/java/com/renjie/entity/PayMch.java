package com.renjie.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 支付中心商户管理表
 * </p>
 *
 * @author oyg
 * @since 2018-06-26
 */
@TableName("pay_mch")
public class PayMch extends Model<PayMch> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "pay_mch_id", type = IdType.AUTO)
    private Integer payMchId;
    @TableField("mch_id")
    private String mchId;
    private String name;
    private String reqKey;
    private String resKey;


    public Integer getPayMchId() {
        return payMchId;
    }

    public void setPayMchId(Integer payMchId) {
        this.payMchId = payMchId;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReqKey() {
        return reqKey;
    }

    public void setReqKey(String reqKey) {
        this.reqKey = reqKey;
    }

    public String getResKey() {
        return resKey;
    }

    public void setResKey(String resKey) {
        this.resKey = resKey;
    }

    @Override
    protected Serializable pkVal() {
        return this.payMchId;
    }

    @Override
    public String toString() {
        return "PayMch{" +
        "payMchId=" + payMchId +
        ", mchId=" + mchId +
        ", name=" + name +
        ", reqKey=" + reqKey +
        ", resKey=" + resKey +
        "}";
    }
}
