package com.helovei.donorApi.service.impl;

import com.helovei.donorApi.model.CategoryEntity;
import com.helovei.donorApi.repository.CategoryRepository;
import com.helovei.donorApi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Iterable<CategoryEntity> getAll() {
        return categoryRepository.findAll();
    }

    public boolean save(CategoryEntity categoryEntity) {
        try {
            categoryRepository.save(categoryEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
