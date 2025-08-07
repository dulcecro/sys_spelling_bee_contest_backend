package com.project.sys_spelling_bee_contest_backend.controller;

import com.project.sys_spelling_bee_contest_backend.DTO.CategoryDTO;
import com.project.sys_spelling_bee_contest_backend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sbee/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping()
    public ResponseEntity<List<CategoryDTO>> listCategories(){
        return ResponseEntity.ok(categoryService.listCategories());
    }
}
