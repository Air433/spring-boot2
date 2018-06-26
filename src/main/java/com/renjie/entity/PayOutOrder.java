package com.renjie.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 支出订单表
 * </p>
 *
 * @author oyg
 * @since 2018-06-26
 */
@TableName("pay_out_order")
public class PayOutOrder extends Model<PayOutOrder> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "pay_out_order_id", type = IdType.AUTO)
    private Integer payOutOrderId;
    @TableField("pay_mch_id")
    private Integer payMchId;
    @TableField("pay_vendor_id")
    private Integer payVendorId;
    private BigDecimal amount;
    private Integer status;
    private Long ctime;


    public Integer getPayOutOrderId() {
        return payOutOrderId;
    }

    public void setPayOutOrderId(Integer payOutOrderId) {
        this.payOutOrderId = payOutOrderId;
    }

    public Integer getPayMchId() {
        return payMchId;
    }

    public void setPayMchId(Integer payMchId) {
        this.payMchId = payMchId;
    }

    public Integer getPayVendorId() {
        return payVendorId;
    }

    public void setPayVendorId(Integer payVendorId) {
        this.payVendorId = payVendorId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCtime() {
        return ctime;
    }

    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    @Override
    protected Serializable pkVal() {
        return this.payOutOrderId;
    }

    @Override
    public String toString() {
        return "PayOutOrder{" +
        "payOutOrderId=" + payOutOrderId +
        ", payMchId=" + payMchId +
        ", payVendorId=" + payVendorId +
        ", amount=" + amount +
        ", status=" + status +
        ", ctime=" + ctime +
        "}";
    }
}
