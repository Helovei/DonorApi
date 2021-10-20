package com.helovei.donorApi.service.impl;

import com.helovei.donorApi.model.NewsCategory;
import com.helovei.donorApi.repository.NewsCategoryRepository;
import com.helovei.donorApi.service.NewsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsCategoryServiceImpl implements NewsCategoryService {

    private final NewsCategoryRepository repository;

    @Autowired
    public NewsCategoryServiceImpl(NewsCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(NewsCategory newsCategory) {
        repository.save(newsCategory);
    }

    @Override
    public List<NewsCategory> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(NewsCategory newsCategory) {
        repository.delete(newsCategory);
    }

    @Override
    public NewsCategory findByName(String name) {
        return repository.findByName(name);
    }
}
