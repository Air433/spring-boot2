package com.renjie.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 类目表
 * </p>
 *
 * @author oyg
 * @since 2018-06-26
 */
@TableName("cms_category")
public class CmsCategory extends Model<CmsCategory> {

    private static final long serialVersionUID = 1L;

    /**
     * 类目编号
     */
    @TableId(value = "category_id", type = IdType.AUTO)
    private Integer categoryId;
    /**
     * 上级编号
     */
    private Integer pid;
    /**
     * 层级
     */
    private Integer level;
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


    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
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
        return this.categoryId;
    }

    @Override
    public String toString() {
        return "CmsCategory{" +
        "categoryId=" + categoryId +
        ", pid=" + pid +
        ", level=" + level +
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
