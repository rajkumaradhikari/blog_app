package com.raj.blog.services;


import com.raj.blog.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {

    //create
    CategoryDto createCategory(CategoryDto categoryDto);

    //update
    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    //get
    CategoryDto getCategoryById(Integer categoryId);

    //getAll
    List<CategoryDto> getAllCategories();

    //delete
    void deleteCategory(Integer categoryId);
}
