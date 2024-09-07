package com.example.demo.service;

import com.example.demo.model.CategoryModel;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.InMemoryCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class inMemoryCategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;


    public inMemoryCategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryModel> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryModel findCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public CategoryModel createCategory(CategoryModel categoryModel) {
        return categoryRepository.save(categoryModel);
    }

    @Override
    public CategoryModel updateCategory(CategoryModel categoryModel) {
        return categoryRepository.save(categoryModel);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }


}
