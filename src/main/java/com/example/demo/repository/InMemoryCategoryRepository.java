package com.example.demo.repository;

import com.example.demo.model.CategoryModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository
public class InMemoryCategoryRepository {

    private final List<CategoryModel> CATEGORY = new ArrayList<>();

    public CategoryModel createCategory(CategoryModel categoryModel){
        CATEGORY.add(categoryModel);
        return categoryModel;
    }
    public CategoryModel updateCategory(CategoryModel categoryModel){
        int categoryIndex = IntStream.range(0, CATEGORY.size())
                .filter(index -> CATEGORY.get(index).getId().equals(categoryModel.getId()))
                .findFirst()
                .orElse(-1);

        return categoryIndex == -1 ? null : CATEGORY.set(categoryIndex, categoryModel);
    }

    public List<CategoryModel> findAllCategories() {
        return CATEGORY.stream().filter(goodsModel -> !goodsModel.isDeleted())
                .collect(Collectors.toList());
    }
    public CategoryModel findCategoryById(Long id){
        return CATEGORY.stream()
                .filter(categoryModel -> categoryModel.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    public void deleteCategory(Long id){
        var categoryModel = findCategoryById(id);
        if (categoryModel != null) {
            CATEGORY.remove(categoryModel);
        }
    }

}
