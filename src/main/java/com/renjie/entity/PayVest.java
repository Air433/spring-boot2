package com.renjie.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 马甲支付参数配置表
 * </p>
 *
 * @author oyg
 * @since 2018-06-26
 */
@TableName("pay_vest")
public class PayVest extends Model<PayVest> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "pay_vest_id", type = IdType.AUTO)
    private Integer payVestId;
    @TableField("pay_type_id")
    private Integer payTypeId;
    private String prefix;
    private String param;


    public Integer getPayVestId() {
        return payVestId;
    }

    public void setPayVestId(Integer payVestId) {
        this.payVestId = payVestId;
    }

    public Integer getPayTypeId() {
        return payTypeId;
    }

    public void setPayTypeId(Integer payTypeId) {
        this.payTypeId = payTypeId;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    @Override
    protected Serializable pkVal() {
        return this.payVestId;
    }

    @Override
    public String toString() {
        return "PayVest{" +
        "payVestId=" + payVestId +
        ", payTypeId=" + payTypeId +
        ", prefix=" + prefix +
        ", param=" + param +
        "}";
    }
}
