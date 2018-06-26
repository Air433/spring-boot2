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
 * 收入订单表
 * </p>
 *
 * @author oyg
 * @since 2018-06-26
 */
@TableName("pay_in_order")
public class PayInOrder extends Model<PayInOrder> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "pay_in_order_id", type = IdType.AUTO)
    private Integer payInOrderId;
    @TableField("pay_vendor_id")
    private Integer payVendorId;
    @TableField("pay_mch_id")
    private Integer payMchId;
    private BigDecimal amount;
    private Integer status;
    private Long ctime;


    public Integer getPayInOrderId() {
        return payInOrderId;
    }

    public void setPayInOrderId(Integer payInOrderId) {
        this.payInOrderId = payInOrderId;
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
        return this.payInOrderId;
    }

    @Override
    public String toString() {
        return "PayInOrder{" +
        "payInOrderId=" + payInOrderId +
        ", payVendorId=" + payVendorId +
        ", payMchId=" + payMchId +
        ", amount=" + amount +
        ", status=" + status +
        ", ctime=" + ctime +
        "}";
    }
}
