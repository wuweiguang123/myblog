package com.lr.shiro;

import lombok.Data;

import java.io.Serializable;
@Data
public class AccountProfile implements Serializable {
    private Integer id;
    private String userName;
    private String userAccount;
}
