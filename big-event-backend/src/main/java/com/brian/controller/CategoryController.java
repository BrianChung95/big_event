package com.brian.controller;

import com.brian.pojo.Category;
import com.brian.pojo.Result;
import com.brian.service.CategoryService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController (CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public Result add(@RequestBody @Validated(Category.Add.class) Category category) {
        categoryService.add(category);
        return Result.success();
    }

    @GetMapping
    public Result<List<Category>> list() {
        List<Category> list = categoryService.list();
        return Result.success(list);
    }

    @GetMapping("/detail")
    public Result<Category> detail(@RequestParam Integer id) {
        Category category = categoryService.findById(id);
        return Result.success(category);
    }

    @PutMapping
    public Result update(@RequestBody @Validated(Category.Update.class) Category category) {
        categoryService.update(category);
        return Result.success();
    }

    @DeleteMapping
    public Result deleteById(@RequestParam Integer id){
        categoryService.deleteById(id);
        return Result.success();
    }
}
