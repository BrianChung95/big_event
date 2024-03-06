package com.brian.service.impl;

import com.brian.mapper.ArticleMapper;
import com.brian.pojo.Article;
import com.brian.pojo.PageBean;
import com.brian.service.ArticleService;
import com.brian.utils.ThreadLocalUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleMapper articleMapper;

    public ArticleServiceImpl(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }
    @Override
    public void add(Article article) {
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(article.getCreateTime());
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        article.setCreateUser(userId);

        articleMapper.add(article);
    }

    @Override
    public PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        // 1. Create PageBean
        PageBean<Article> pb = new PageBean<>();
        // 2. Init pagination
        PageHelper.startPage(pageNum, pageSize);
        // 3. Use mapper to search
        Page<Article> page = (Page<Article>) articleMapper.list(userId, categoryId, state);

        pb.setTotal(page.getTotal());
        pb.setItems(page.getResult());
        return pb;
    }

    @Override
    public Article findById(Integer id) {
        return articleMapper.findById(id);
    }

    @Override
    public void update(Article article) {
        article.setUpdateTime(LocalDateTime.now());
        articleMapper.update(article);
    }

    @Override
    public void delete(Integer id) {
        articleMapper.delete(id);
    }
}
