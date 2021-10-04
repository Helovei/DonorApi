package com.helovei.donorApi.service;

import com.helovei.donorApi.model.CategoryEntity;

import java.util.List;

public interface CategoryService {

    boolean save(CategoryEntity categoryEntity);
    Iterable<CategoryEntity> getAll();

}
