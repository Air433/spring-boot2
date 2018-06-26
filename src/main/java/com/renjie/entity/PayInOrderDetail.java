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
 * 收入订单明细表
 * </p>
 *
 * @author oyg
 * @since 2018-06-26
 */
@TableName("pay_in_order_detail")
public class PayInOrderDetail extends Model<PayInOrderDetail> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "pay_in_order_detail_id", type = IdType.AUTO)
    private Integer payInOrderDetailId;
    @TableField("pay_in_order_id")
    private Integer payInOrderId;
    @TableField("product_id")
    private String productId;
    @TableField("product_name")
    private String productName;
    @TableField("product_price")
    private BigDecimal productPrice;
    @TableField("product_count")
    private Integer productCount;
    private String remark;


    public Integer getPayInOrderDetailId() {
        return payInOrderDetailId;
    }

    public void setPayInOrderDetailId(Integer payInOrderDetailId) {
        this.payInOrderDetailId = payInOrderDetailId;
    }

    public Integer getPayInOrderId() {
        return payInOrderId;
    }

    public void setPayInOrderId(Integer payInOrderId) {
        this.payInOrderId = payInOrderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    protected Serializable pkVal() {
        return this.payInOrderDetailId;
    }

    @Override
    public String toString() {
        return "PayInOrderDetail{" +
        "payInOrderDetailId=" + payInOrderDetailId +
        ", payInOrderId=" + payInOrderId +
        ", productId=" + productId +
        ", productName=" + productName +
        ", productPrice=" + productPrice +
        ", productCount=" + productCount +
        ", remark=" + remark +
        "}";
    }
}
