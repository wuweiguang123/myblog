package com.lr.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
public class TMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 留言编号
     */
    @TableId(value = "message_id", type = IdType.AUTO)
    private Integer messageId;

    /**
     * 留言内容
     */
    private String messageContent;

    /**
     * 留言者姓名
     */
    private String messageName;

    /**
     * 联系邮箱
     */
    private String messageEmail;

    /**
     * 留言时间
     */
    private LocalDateTime messageTime;

    /**
     * 是否已读（0 未读，1 已读）
     */
    private String readMark;

    /**
     * 留言标记（-1审核没通过，0未审核，1审核通过）
     */
    private String messageMark;


}
