package com.lr.controller;


import cn.hutool.core.map.MapUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.lr.entity.User;
import com.lr.service.UserService;
import com.lr.utils.JwtUtils;
import com.lr.utils.MD5;
import com.lr.utils.Result;
import netscape.javascript.JSObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-05-30
 */
@RestController //相当于@Controller + @ResponseBody
@RequestMapping("/user")
public class UserController {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    private UserService userService;

    /**
     * 登录接口
     * @param params
     * @param response
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody String  params, HttpServletResponse response){

        if(StringUtils.isNotBlank(params)){
            //获取用户名密码
            JSONObject obj= JSON.parseObject(params);
            String username=obj.getString("userAccount");
            String password=obj.getString("password");

            QueryWrapper queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("user_account",username);
          User user=  userService.getOne(queryWrapper);

          //验证用户
            Assert.notNull(user,"用户不存在");
            if(!user.getUserPassword().equals(MD5.md5(password))){
                return Result.fail("登录失败密码错误");
            }
            //用户存在生成token并将用户信息和token一起返回给前台
            String jwt = jwtUtils.generateToken(user.getId());
            response.setHeader("Authorization", jwt);
            response.setHeader("Access-Control-Expose-Headers", "Authorization");
            // 用户可以另一个接口
            return Result.succ(MapUtil.builder()
                                .put("id", user.getId())
                                .put("username", user.getUserName())
                                .put("userAccount", user.getUserAccount())
                                .put("email", user.getUserEmail())
                                .map() );
        } else {
            return Result.fail("参数不可以为空");
        }

    }
    /**
     * 测试实体校验
     * @param user
     * @return
     */
    @PostMapping("/save")
    public Result testUser(@Validated @RequestBody User user) {

        return Result.succ(user);
    }

    @GetMapping("/logout")
    @RequiresAuthentication
   public  Result Logout(){
        SecurityUtils.getSubject().logout();
        return Result.succ(null);
   }

}
