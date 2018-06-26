package com.renjie.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 专题
 * </p>
 *
 * @author oyg
 * @since 2018-06-26
 */
@TableName("cms_topic")
public class CmsTopic extends Model<CmsTopic> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "topic_id", type = IdType.AUTO)
    private Integer topicId;
    /**
     * 标题
     */
    private String title;
    /**
     * 描述
     */
    private String description;
    /**
     * 链接
     */
    private String url;
    /**
     * 创建时间
     */
    private Long ctime;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getCtime() {
        return ctime;
    }

    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    @Override
    protected Serializable pkVal() {
        return this.topicId;
    }

    @Override
    public String toString() {
        return "CmsTopic{" +
        "topicId=" + topicId +
        ", title=" + title +
        ", description=" + description +
        ", url=" + url +
        ", ctime=" + ctime +
        "}";
    }
}
