package com.renjie.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 支付参数配置表
 * </p>
 *
 * @author oyg
 * @since 2018-06-26
 */
@TableName("pay_pay")
public class PayPay extends Model<PayPay> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "pay_pay_id", type = IdType.AUTO)
    private Integer payPayId;
    @TableField("pay_type_id")
    private Integer payTypeId;
    private String param;


    public Integer getPayPayId() {
        return payPayId;
    }

    public void setPayPayId(Integer payPayId) {
        this.payPayId = payPayId;
    }

    public Integer getPayTypeId() {
        return payTypeId;
    }

    public void setPayTypeId(Integer payTypeId) {
        this.payTypeId = payTypeId;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    @Override
    protected Serializable pkVal() {
        return this.payPayId;
    }

    @Override
    public String toString() {
        return "PayPay{" +
        "payPayId=" + payPayId +
        ", payTypeId=" + payTypeId +
        ", param=" + param +
        "}";
    }
}
