package com.renjie.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 认证方式表
 * </p>
 *
 * @author oyg
 * @since 2018-06-26
 */
@TableName("ucenter_oauth")
public class UcenterOauth extends Model<UcenterOauth> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "oauth_id", type = IdType.AUTO)
    private Integer oauthId;
    /**
     * 认证方式名称
     */
    private String name;


    public Integer getOauthId() {
        return oauthId;
    }

    public void setOauthId(Integer oauthId) {
        this.oauthId = oauthId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Serializable pkVal() {
        return this.oauthId;
    }

    @Override
    public String toString() {
        return "UcenterOauth{" +
        "oauthId=" + oauthId +
        ", name=" + name +
        "}";
    }
}
