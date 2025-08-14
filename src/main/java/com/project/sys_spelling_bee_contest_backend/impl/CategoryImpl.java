package com.project.sys_spelling_bee_contest_backend.impl;

import com.project.sys_spelling_bee_contest_backend.DTO.CategoryDTO;
import com.project.sys_spelling_bee_contest_backend.mapper.CategoryMapper;
import com.project.sys_spelling_bee_contest_backend.entity.Category;
import com.project.sys_spelling_bee_contest_backend.repository.CategoryRepository;
import com.project.sys_spelling_bee_contest_backend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryDTO> listCategories(){
        List<Category> category = categoryRepository.findAll();

        if(category.isEmpty()){
            throw new RuntimeException("The list of categories is empty");
        }

        return category.stream().map(categoryMapper::categoryToDTO).toList();
    }
}
