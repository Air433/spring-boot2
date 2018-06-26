package com.renjie.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 第三方支付标识表
 * </p>
 *
 * @author oyg
 * @since 2018-06-26
 */
@TableName("pay_vendor")
public class PayVendor extends Model<PayVendor> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "pay_vendor_id", type = IdType.AUTO)
    private Integer payVendorId;
    private String name;
    private String appid;
    private String appsecret;
    private String config;


    public Integer getPayVendorId() {
        return payVendorId;
    }

    public void setPayVendorId(Integer payVendorId) {
        this.payVendorId = payVendorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    @Override
    protected Serializable pkVal() {
        return this.payVendorId;
    }

    @Override
    public String toString() {
        return "PayVendor{" +
        "payVendorId=" + payVendorId +
        ", name=" + name +
        ", appid=" + appid +
        ", appsecret=" + appsecret +
        ", config=" + config +
        "}";
    }
}
