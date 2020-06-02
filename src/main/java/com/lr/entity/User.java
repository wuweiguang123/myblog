package com.lr.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2020-05-30
 */
@TableName("t_user")
@Data
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户编号
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    @NotBlank(message = "昵称不能为空")
    private String userName;

    /**
     * 用户邮箱
     */
    @NotBlank(message = "邮箱格式不可以为空")
    @Email(message = "邮箱格式不正确")
    private String userEmail;

    /**
     * 电话号码
     */
    private String userPhone;

    /**
     * 登录账号
     */
    private String userAccount;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 用户状态：-1无效 1有效（默认有效）
     */
    private String userStatus;


}
