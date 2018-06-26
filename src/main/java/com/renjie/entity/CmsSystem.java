package com.renjie.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 系统管理
 * </p>
 *
 * @author oyg
 * @since 2018-06-26
 */
@TableName("cms_system")
public class CmsSystem extends Model<CmsSystem> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "system_id", type = IdType.AUTO)
    private Integer systemId;
    /**
     * 系统名称
     */
    private String name;
    /**
     * 别名
     */
    private String code;
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


    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
        return this.systemId;
    }

    @Override
    public String toString() {
        return "CmsSystem{" +
        "systemId=" + systemId +
        ", name=" + name +
        ", code=" + code +
        ", description=" + description +
        ", ctime=" + ctime +
        ", orders=" + orders +
        "}";
    }
}
