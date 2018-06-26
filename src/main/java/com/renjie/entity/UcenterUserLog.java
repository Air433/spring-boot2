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
 * 用户操作日志表
 * </p>
 *
 * @author oyg
 * @since 2018-06-26
 */
@TableName("ucenter_user_log")
public class UcenterUserLog extends Model<UcenterUserLog> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "user_log_id", type = IdType.AUTO)
    private Integer userLogId;
    /**
     * 用户编号
     */
    @TableField("user_id")
    private Integer userId;
    /**
     * 内容
     */
    private byte[] content;
    /**
     * 操作IP地址
     */
    private String ip;
    /**
     * 操作环境
     */
    private byte[] agent;
    /**
     * 操作时间
     */
    @TableField("create_time")
    private Date createTime;


    public Integer getUserLogId() {
        return userLogId;
    }

    public void setUserLogId(Integer userLogId) {
        this.userLogId = userLogId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public byte[] getAgent() {
        return agent;
    }

    public void setAgent(byte[] agent) {
        this.agent = agent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.userLogId;
    }

    @Override
    public String toString() {
        return "UcenterUserLog{" +
        "userLogId=" + userLogId +
        ", userId=" + userId +
        ", content=" + content +
        ", ip=" + ip +
        ", agent=" + agent +
        ", createTime=" + createTime +
        "}";
    }
}
