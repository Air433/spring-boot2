package com.renjie.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 评论表
 * </p>
 *
 * @author oyg
 * @since 2018-06-26
 */
@TableName("cms_comment")
public class CmsComment extends Model<CmsComment> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "comment_id", type = IdType.AUTO)
    private Integer commentId;
    /**
     * 回复楼中楼编号回复楼中楼编号
     */
    private Integer pid;
    /**
     * 文章编号
     */
    @TableField("article_id")
    private Integer articleId;
    /**
     * 用户编号
     */
    @TableField("user_id")
    private Integer userId;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 状态(-1:不通过,0:未审核,1:通过)
     */
    private Integer status;
    /**
     * 评论人ip地址
     */
    private String ip;
    /**
     * 评论人终端信息
     */
    private String agent;
    /**
     * 所属系统
     */
    @TableField("system_id")
    private Integer systemId;
    /**
     * 创建时间
     */
    private Long ctime;


    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    public Long getCtime() {
        return ctime;
    }

    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    @Override
    protected Serializable pkVal() {
        return this.commentId;
    }

    @Override
    public String toString() {
        return "CmsComment{" +
        "commentId=" + commentId +
        ", pid=" + pid +
        ", articleId=" + articleId +
        ", userId=" + userId +
        ", content=" + content +
        ", status=" + status +
        ", ip=" + ip +
        ", agent=" + agent +
        ", systemId=" + systemId +
        ", ctime=" + ctime +
        "}";
    }
}
