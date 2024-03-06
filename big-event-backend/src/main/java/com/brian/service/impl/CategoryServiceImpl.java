package com.brian.service.impl;

import com.brian.mapper.CategoryMapper;
import com.brian.pojo.Category;
import com.brian.service.CategoryService;
import com.brian.utils.ThreadLocalUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }
    @Override
    public void add(Category category) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        category.setCreateUser(userId);
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(category.getCreateTime());
        categoryMapper.add(category);
    }

    @Override
    public List<Category> list() {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");

        return categoryMapper.getAllCategoryById(userId);
    }

    @Override
    public Category findById(Integer id) {
        return categoryMapper.findById(id);
    }

    @Override
    public void update(Category category) {
        category.setUpdateTime(LocalDateTime.now());
        categoryMapper.update(category);
    }

    @Override
    public void deleteById(Integer id) {
        categoryMapper.deleteById(id);
    }
}
