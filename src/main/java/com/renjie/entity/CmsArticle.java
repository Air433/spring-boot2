package com.renjie.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 文章表
 * </p>
 *
 * @author oyg
 * @since 2018-06-26
 */
@TableName("cms_article")
public class CmsArticle extends Model<CmsArticle> {

    private static final long serialVersionUID = 1L;

    /**
     * 文章编号
     */
    @TableId(value = "article_id", type = IdType.AUTO)
    private Integer articleId;
    /**
     * 所属专题
     */
    @TableField("topic_id")
    private Integer topicId;
    /**
     * 文章标题
     */
    private String title;
    /**
     * 文章原作者
     */
    private String author;
    /**
     * 转载来源网址
     */
    private String fromurl;
    /**
     * 封面图
     */
    private String image;
    /**
     * 关键字
     */
    private String keywords;
    /**
     * 简介
     */
    private String description;
    /**
     * 类型(1:普通,2:热门...)
     */
    private Integer type;
    /**
     * 是否允许评论(0:不允许,1:允许)
     */
    private Integer allowcomments;
    /**
     * 状态(-1:不通过,0未审核,1:通过)
     */
    private Integer status;
    /**
     * 内容
     */
    private String content;
    /**
     * 发布人id
     */
    @TableField("user_id")
    private Integer userId;
    /**
     * 阅读数量
     */
    private Integer readnumber;
    /**
     * 置顶等级
     */
    private Integer top;
    /**
     * 所属系统
     */
    @TableField("system_id")
    private Integer systemId;
    /**
     * 创建时间
     */
    private Long ctime;
    /**
     * 排序
     */
    private Long orders;


    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFromurl() {
        return fromurl;
    }

    public void setFromurl(String fromurl) {
        this.fromurl = fromurl;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getAllowcomments() {
        return allowcomments;
    }

    public void setAllowcomments(Integer allowcomments) {
        this.allowcomments = allowcomments;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getReadnumber() {
        return readnumber;
    }

    public void setReadnumber(Integer readnumber) {
        this.readnumber = readnumber;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
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

    public Long getOrders() {
        return orders;
    }

    public void setOrders(Long orders) {
        this.orders = orders;
    }

    @Override
    protected Serializable pkVal() {
        return this.articleId;
    }

    @Override
    public String toString() {
        return "CmsArticle{" +
        "articleId=" + articleId +
        ", topicId=" + topicId +
        ", title=" + title +
        ", author=" + author +
        ", fromurl=" + fromurl +
        ", image=" + image +
        ", keywords=" + keywords +
        ", description=" + description +
        ", type=" + type +
        ", allowcomments=" + allowcomments +
        ", status=" + status +
        ", content=" + content +
        ", userId=" + userId +
        ", readnumber=" + readnumber +
        ", top=" + top +
        ", systemId=" + systemId +
        ", ctime=" + ctime +
        ", orders=" + orders +
        "}";
    }
}
