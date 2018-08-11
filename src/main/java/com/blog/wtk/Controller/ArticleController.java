package com.blog.wtk.Controller;

import com.blog.wtk.Model.Article;
import com.blog.wtk.Service.ArticleService;
import com.blog.wtk.Service.ArticleServiceImpl;
import com.vladsch.flexmark.ast.Node;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.options.MutableDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

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

    @RequestMapping(value = "/article")
    public String to_Article(){
        return "article";
    }

    @RequestMapping(value = "/articleAdd")
    public String Article_Add(Article article){
        article.setContent(tranfer(article.getContent()));
        boolean is_add=articleService.ArticleAdd(article);
        if(is_add){
            System.out.println("文章添加成功");
            return "redirect:/";
        }
        else {
            return "article";
        }
    }

    public static String tranfer(String content){
        MutableDataSet options = new MutableDataSet();
        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();
        Node document = parser.parse(content);
        return renderer.render(document);
    }
}
