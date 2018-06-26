package com.renjie.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户认证方式表
 * </p>
 *
 * @author oyg
 * @since 2018-06-26
 */
@TableName("ucenter_user_oauth")
public class UcenterUserOauth extends Model<UcenterUserOauth> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "user_oauth_id", type = IdType.AUTO)
    private Integer userOauthId;
    /**
     * 帐号编号
     */
    @TableField("user_id")
    private Integer userId;
    /**
     * 认证方式编号
     */
    @TableField("oauth_id")
    private Integer oauthId;
    /**
     * 第三方ID
     */
    @TableField("open_id")
    private byte[] openId;
    /**
     * 绑定状态(0:解绑,1:绑定)
     */
    private Integer status;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;


    public Integer getUserOauthId() {
        return userOauthId;
    }

    public void setUserOauthId(Integer userOauthId) {
        this.userOauthId = userOauthId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOauthId() {
        return oauthId;
    }

    public void setOauthId(Integer oauthId) {
        this.oauthId = oauthId;
    }

    public byte[] getOpenId() {
        return openId;
    }

    public void setOpenId(byte[] openId) {
        this.openId = openId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.userOauthId;
    }

    @Override
    public String toString() {
        return "UcenterUserOauth{" +
        "userOauthId=" + userOauthId +
        ", userId=" + userId +
        ", oauthId=" + oauthId +
        ", openId=" + openId +
        ", status=" + status +
        ", createTime=" + createTime +
        "}";
    }
}
