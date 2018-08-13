package com.blog.wtk.Controller;

import com.blog.wtk.Model.Article;
import com.blog.wtk.Service.ArticleService;
import com.blog.wtk.Service.ArticleServiceImpl;
import com.vladsch.flexmark.ast.Node;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.options.MutableDataSet;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @program: wtk
 * @description: 写博客页管理部分
 * @author: Mr.Wang
 * @create: 2018-08-05
 **/
@Controller
@SpringBootApplication
public class ArticleController {
    @Autowired
    ArticleServiceImpl articleService;

    @RequestMapping(value = "/show_article/{id}")
    public String show_Article(@PathVariable(value="id") Integer id , Model model){
        Article article=articleService.showById(id);
        model.addAttribute("article",article);
        System.out.println("欢迎来到文章展示页");
        return "show_article";
    }


    @RequestMapping(value = "/article")
    public String to_Article(){
        return "article";
    }

    @RequestMapping(value = "/articleAdd")
    public String Article_Add(Article article){
        boolean is_add=articleService.ArticleAdd(article);
        if(is_add){
            System.out.println("文章添加成功");
            return "redirect:/";
        }
        else {
            return "article";
        }
    }
    @RequestMapping(value = "/page/{pageId}")
    public String Page(Model model,@PathVariable("pageId")int pageId){
        List<Article> articles = articleService.getLatestArticles((pageId-1)*4,4);
        model.addAttribute("articles",articles);

        return "index";
    }

}
