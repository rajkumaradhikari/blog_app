package com.raj.blog.controllers;

import com.raj.blog.payloads.ApiResponse;
import com.raj.blog.payloads.CategoryDto;
import com.raj.blog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category/")
public class CategoryController {

     @Autowired
    private CategoryService categoryService;

     @PostMapping("/createCategory")
     public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
         CategoryDto createCategory = this.categoryService.createCategory(categoryDto);
         return new ResponseEntity<CategoryDto>(createCategory, HttpStatus.CREATED);
     }

     @PutMapping("/{categoryId}")
     public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable Integer categoryId){
         CategoryDto updateCategory = this.categoryService.updateCategory(categoryDto, categoryId);
         return new ResponseEntity<CategoryDto>(updateCategory,HttpStatus.OK);
     }

     @DeleteMapping("/{categoryId}")
     public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId){
         this.categoryService.deleteCategory(categoryId);
         return new ResponseEntity<ApiResponse>(new ApiResponse("Category deleted successfully!!!",true),HttpStatus.OK);
     }

     @GetMapping("/{categoryId}")
     public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer categoryId){
         CategoryDto categoryById = this.categoryService.getCategoryById(categoryId);
         return new ResponseEntity<CategoryDto>(categoryById, HttpStatus.OK);
     }

    @GetMapping("/getAllCategories")
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        List<CategoryDto> categories = this.categoryService.getAllCategories();
        return new ResponseEntity<List<CategoryDto>>(categories, HttpStatus.OK);
    }


}
