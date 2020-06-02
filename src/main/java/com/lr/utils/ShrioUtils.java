package com.lr.utils;

import com.lr.shiro.AccountProfile;
import org.apache.shiro.SecurityUtils;

public class ShrioUtils {
    public static AccountProfile getProfile(){
        return (AccountProfile) SecurityUtils.getSubject().getPrincipal();
    }
}
