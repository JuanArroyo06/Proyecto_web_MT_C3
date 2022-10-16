package com.misiontic.USA.Ortesis.controllers;


import com.misiontic.USA.Ortesis.models.Category;
import com.misiontic.USA.Ortesis.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")

public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @GetMapping("/all")
    public List<Category> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id")int id){
        return categoryService.getCategory(id);
    }

    @PostMapping("/save")

    public Category insertCategory(@RequestBody Category category){
        return categoryService.insertCategory(category);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category updateCategory(@RequestBody Category category) {
        return categoryService.updateCategory(category);
    }

    @DeleteMapping("/delete{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteCategory(@PathVariable("id") int id){
        return categoryService.deleteCategory(id);
    }
}
