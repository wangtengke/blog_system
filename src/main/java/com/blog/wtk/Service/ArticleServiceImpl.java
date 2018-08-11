package com.blog.wtk.Service;

import com.blog.wtk.Mapper.ArticleMapper;
import com.blog.wtk.Model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @program: wtk
 * @description:添加文章
 * @author: Mr.Wang
 * @create: 2018-08-05
 **/
@Service("ArticleService")
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;
    @Override
    public boolean ArticleAdd(Article article) {
        article.setCreatedDate(new Date());
        article.setCommentcount(0);
        int is_success=articleMapper.insertSelective(article);
        return is_success ==1;
    }

    @Override
    public List <Article> getAll() {
        List<Article> articles=articleMapper.selectAll();
        for (Article article: articles ){
            System.out.println(article.getDescribes());
        }
        return articles;
    }
    /**
    * @Description: 根据ID查询文章
    * @Param: [id]
    * @return: com.blog.wtk.Model.Article
    * @Author: Wtk
    * @Date: 2018/8/11
    */
    @Override
    public Article showById(Integer id) {
        return  articleMapper.selectByPrimaryKey(id);
    }
}
