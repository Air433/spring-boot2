package com.renjie.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 文章类目关联表
 * </p>
 *
 * @author oyg
 * @since 2018-06-26
 */
@TableName("cms_article_category")
public class CmsArticleCategory extends Model<CmsArticleCategory> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "article_category_id", type = IdType.AUTO)
    private Integer articleCategoryId;
    /**
     * 文章编号
     */
    @TableField("article_id")
    private Integer articleId;
    /**
     * 类目编号
     */
    @TableField("category_id")
    private Integer categoryId;


    public Integer getArticleCategoryId() {
        return articleCategoryId;
    }

    public void setArticleCategoryId(Integer articleCategoryId) {
        this.articleCategoryId = articleCategoryId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    protected Serializable pkVal() {
        return this.articleCategoryId;
    }

    @Override
    public String toString() {
        return "CmsArticleCategory{" +
        "articleCategoryId=" + articleCategoryId +
        ", articleId=" + articleId +
        ", categoryId=" + categoryId +
        "}";
    }
}
