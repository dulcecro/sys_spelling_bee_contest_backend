package com.project.sys_spelling_bee_contest_backend.service;

import com.project.sys_spelling_bee_contest_backend.DTO.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> listCategories();
}
