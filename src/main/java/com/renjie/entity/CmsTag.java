package com.renjie.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 标签表
 * </p>
 *
 * @author oyg
 * @since 2018-06-26
 */
@TableName("cms_tag")
public class CmsTag extends Model<CmsTag> {

    private static final long serialVersionUID = 1L;

    /**
     * 标签编号
     */
    @TableId(value = "tag_id", type = IdType.AUTO)
    private Integer tagId;
    /**
     * 名称
     */
    private String name;
    /**
     * 描述
     */
    private String description;
    /**
     * 图标
     */
    private String icon;
    /**
     * 类型(1:普通,2:热门...)
     */
    private Integer type;
    /**
     * 别名
     */
    private String alias;
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


    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
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
        return this.tagId;
    }

    @Override
    public String toString() {
        return "CmsTag{" +
        "tagId=" + tagId +
        ", name=" + name +
        ", description=" + description +
        ", icon=" + icon +
        ", type=" + type +
        ", alias=" + alias +
        ", systemId=" + systemId +
        ", ctime=" + ctime +
        ", orders=" + orders +
        "}";
    }
}
