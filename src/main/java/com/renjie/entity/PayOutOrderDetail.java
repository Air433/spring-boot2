package com.renjie.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 支出订单明细表
 * </p>
 *
 * @author oyg
 * @since 2018-06-26
 */
@TableName("pay_out_order_detail")
public class PayOutOrderDetail extends Model<PayOutOrderDetail> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "pay_out_order_detail_id", type = IdType.AUTO)
    private Integer payOutOrderDetailId;
    @TableField("pay_out_order_id")
    private Integer payOutOrderId;
    private String remark;


    public Integer getPayOutOrderDetailId() {
        return payOutOrderDetailId;
    }

    public void setPayOutOrderDetailId(Integer payOutOrderDetailId) {
        this.payOutOrderDetailId = payOutOrderDetailId;
    }

    public Integer getPayOutOrderId() {
        return payOutOrderId;
    }

    public void setPayOutOrderId(Integer payOutOrderId) {
        this.payOutOrderId = payOutOrderId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    protected Serializable pkVal() {
        return this.payOutOrderDetailId;
    }

    @Override
    public String toString() {
        return "PayOutOrderDetail{" +
        "payOutOrderDetailId=" + payOutOrderDetailId +
        ", payOutOrderId=" + payOutOrderId +
        ", remark=" + remark +
        "}";
    }
}
