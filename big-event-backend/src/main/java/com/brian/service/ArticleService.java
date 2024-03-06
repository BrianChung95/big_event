package com.brian.service;

import com.brian.pojo.Article;
import com.brian.pojo.PageBean;

public interface ArticleService {
    void add(Article article);

    PageBean<Article> list(Integer pageName, Integer pageSize, Integer categoryId, String state);

    Article findById(Integer id);

    void update(Article article);

    void delete(Integer id);
}
