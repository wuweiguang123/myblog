package com.lr.controller;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lr.entity.TArticle;
import com.lr.service.ITArticleService;
import com.lr.utils.Result;
import com.lr.utils.ShrioUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-05-30
 */
@RestController
@RequestMapping("/article")
public class TArticleController {

    @Autowired
    ITArticleService articleService;

    @RequestMapping("/list")
    public Result list(Integer currentPage){
        if(currentPage ==null ||currentPage <1){
            currentPage=1;
        }
      Page page= new Page<>(currentPage,5);
      IPage pageData= articleService.page(page,new QueryWrapper<TArticle>().orderByDesc("create_time"));
      return  Result.succ("查询成功",pageData);
    }
   @RequestMapping("/detail/{id}")
    public Result detail(@PathVariable("id")Integer id){
       TArticle tArticle=  articleService.getById(id);
       Assert.notNull(tArticle,"文章已删除");
       return  Result.succ(tArticle);
    }

    @RequiresAuthentication
    @PostMapping("/edit")
    public  Result edit(@Validated @RequestBody TArticle tArticle){
        TArticle temp=null;
        if(tArticle.getArticleId() != null){
            temp =  articleService.getById(tArticle.getArticleId());
            Assert.isTrue(temp.getUserId()== ShrioUtils.getProfile().getId());
        }else {
            temp=new TArticle();
            temp.setUserId(ShrioUtils.getProfile().getId());
            temp.setCreateTime(LocalDateTime.now());
            temp.setArticleStatus("0");
        }
        BeanUtil.copyProperties(tArticle, temp, "articleId", "userId", "createTime", "articleStatus");
        articleService.saveOrUpdate(temp);
        return Result.succ("操作成功", null);

    }
}
