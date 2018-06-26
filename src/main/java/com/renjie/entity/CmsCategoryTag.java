package com.renjie.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 类目标签关联表
 * </p>
 *
 * @author oyg
 * @since 2018-06-26
 */
@TableName("cms_category_tag")
public class CmsCategoryTag extends Model<CmsCategoryTag> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "category_tag_id", type = IdType.AUTO)
    private Integer categoryTagId;
    /**
     * 类目编号
     */
    @TableField("category_id")
    private Integer categoryId;
    /**
     * 标签编号
     */
    @TableField("tag_id")
    private Integer tagId;


    public Integer getCategoryTagId() {
        return categoryTagId;
    }

    public void setCategoryTagId(Integer categoryTagId) {
        this.categoryTagId = categoryTagId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    @Override
    protected Serializable pkVal() {
        return this.categoryTagId;
    }

    @Override
    public String toString() {
        return "CmsCategoryTag{" +
        "categoryTagId=" + categoryTagId +
        ", categoryId=" + categoryId +
        ", tagId=" + tagId +
        "}";
    }
}
