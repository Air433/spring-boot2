package com.renjie.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 页面
 * </p>
 *
 * @author oyg
 * @since 2018-06-26
 */
@TableName("cms_page")
public class CmsPage extends Model<CmsPage> {

    private static final long serialVersionUID = 1L;

    /**
     * 编码
     */
    @TableId(value = "page_id", type = IdType.AUTO)
    private Integer pageId;
    /**
     * 父页面
     */
    private Integer pid;
    /**
     * 标题
     */
    private String title;
    /**
     * 别名
     */
    private String alias;
    /**
     * 页面内容
     */
    private String content;
    /**
     * 关键字
     */
    private String keywords;
    /**
     * 描述
     */
    private String description;
    /**
     * 创建时间
     */
    private Long ctime;
    /**
     * 排序
     */
    private Long orders;


    public Integer getPageId() {
        return pageId;
    }

    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        return this.pageId;
    }

    @Override
    public String toString() {
        return "CmsPage{" +
        "pageId=" + pageId +
        ", pid=" + pid +
        ", title=" + title +
        ", alias=" + alias +
        ", content=" + content +
        ", keywords=" + keywords +
        ", description=" + description +
        ", ctime=" + ctime +
        ", orders=" + orders +
        "}";
    }
}
