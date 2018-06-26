package com.renjie.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 网站配置
 * </p>
 *
 * @author oyg
 * @since 2018-06-26
 */
@TableName("cms_setting")
public class CmsSetting extends Model<CmsSetting> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "setting_id", type = IdType.AUTO)
    private Integer settingId;
    @TableField("setting_key")
    private String settingKey;
    @TableField("setting_value")
    private String settingValue;


    public Integer getSettingId() {
        return settingId;
    }

    public void setSettingId(Integer settingId) {
        this.settingId = settingId;
    }

    public String getSettingKey() {
        return settingKey;
    }

    public void setSettingKey(String settingKey) {
        this.settingKey = settingKey;
    }

    public String getSettingValue() {
        return settingValue;
    }

    public void setSettingValue(String settingValue) {
        this.settingValue = settingValue;
    }

    @Override
    protected Serializable pkVal() {
        return this.settingId;
    }

    @Override
    public String toString() {
        return "CmsSetting{" +
        "settingId=" + settingId +
        ", settingKey=" + settingKey +
        ", settingValue=" + settingValue +
        "}";
    }
}
