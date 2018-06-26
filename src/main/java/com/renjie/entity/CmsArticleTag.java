package com.renjie.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 文章标签关联表
 * </p>
 *
 * @author oyg
 * @since 2018-06-26
 */
@TableName("cms_article_tag")
public class CmsArticleTag extends Model<CmsArticleTag> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "article_tag_id", type = IdType.AUTO)
    private Integer articleTagId;
    /**
     * 文章编号
     */
    @TableField("article_id")
    private Integer articleId;
    /**
     * 标签编号
     */
    @TableField("tag_id")
    private Integer tagId;


    public Integer getArticleTagId() {
        return articleTagId;
    }

    public void setArticleTagId(Integer articleTagId) {
        this.articleTagId = articleTagId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    @Override
    protected Serializable pkVal() {
        return this.articleTagId;
    }

    @Override
    public String toString() {
        return "CmsArticleTag{" +
        "articleTagId=" + articleTagId +
        ", articleId=" + articleId +
        ", tagId=" + tagId +
        "}";
    }
}
