package com.lr.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2020-05-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TArticle implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文章编号
     */
    @TableId(value = "article_id", type = IdType.AUTO)
    private Integer articleId;

    /**
     * 文章标题
     */
    @NotBlank(message = "标题不可以为空")
    private String articleTitle;

    /**
     * 文章摘要
     */
    @NotBlank(message = "文章摘要不可以为空")
    private String articleSummary;

    /**
     * 文章内容
     */
    @NotBlank(message = "文章内容不可以为空")
    private String articleContent;

    /**
     * 文章插图
     */
    private String articlePic;

    /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDateTime createTime;

    /**
     * 文章标识
     */
    private String articleMark;

    /**
     * 阅读量
     */
    private Integer articleReadNum;

    /**
     * 点赞数
     */
    private Integer articleLikes;

    /**
     * 文章状态
     */
    private String articleStatus;

    /**
     * 创建人
     */
    private Integer userId;


}
