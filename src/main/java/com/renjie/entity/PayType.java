package com.renjie.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 商户支持支付类型表
 * </p>
 *
 * @author oyg
 * @since 2018-06-26
 */
@TableName("pay_type")
public class PayType extends Model<PayType> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "pay_type_id", type = IdType.AUTO)
    private Integer payTypeId;
    @TableField("pay_vendor_id")
    private Integer payVendorId;
    @TableField("pay_mch_id")
    private Integer payMchId;


    public Integer getPayTypeId() {
        return payTypeId;
    }

    public void setPayTypeId(Integer payTypeId) {
        this.payTypeId = payTypeId;
    }

    public Integer getPayVendorId() {
        return payVendorId;
    }

    public void setPayVendorId(Integer payVendorId) {
        this.payVendorId = payVendorId;
    }

    public Integer getPayMchId() {
        return payMchId;
    }

    public void setPayMchId(Integer payMchId) {
        this.payMchId = payMchId;
    }

    @Override
    protected Serializable pkVal() {
        return this.payTypeId;
    }

    @Override
    public String toString() {
        return "PayType{" +
        "payTypeId=" + payTypeId +
        ", payVendorId=" + payVendorId +
        ", payMchId=" + payMchId +
        "}";
    }
}
