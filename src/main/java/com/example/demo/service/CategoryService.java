package com.example.demo.service;

import com.example.demo.model.CategoryModel;

import java.util.List;

public interface CategoryService {
    public List<CategoryModel> findAllCategories();
    public CategoryModel findCategoryById(Long id);
    public CategoryModel createCategory(CategoryModel categoryModel);
    public CategoryModel updateCategory(CategoryModel categoryModel);
    public void deleteCategory(Long id);


}
