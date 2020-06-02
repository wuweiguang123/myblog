package com.lr.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
public class TCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 分类编号
     */
    @TableId(value = "category_id", type = IdType.AUTO)
    private Integer categoryId;

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 分类别名
     */
    private String categoryAlias;

    /**
     * 分类标识：0文章的分类 1文章的标签
     */
    private String categoryMarks;

    /**
     * 分类描述
     */
    private String categoryDescription;

    /**
     * 分类状态
     */
    private String categoryStatus;


}
