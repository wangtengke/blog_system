package com.blog.wtk.Service;

import com.blog.wtk.Model.Article;

import java.util.Collection;
import java.util.List;

public interface ArticleService {
    boolean ArticleAdd(Article article);

    List<Article> getAll();
}