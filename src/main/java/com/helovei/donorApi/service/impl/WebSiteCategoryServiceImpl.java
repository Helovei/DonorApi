package com.helovei.donorApi.service.impl;

import com.helovei.donorApi.model.WebsiteCategory;
import com.helovei.donorApi.repository.WebSiteCategoryRepository;
import com.helovei.donorApi.service.WebSiteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebSiteCategoryServiceImpl implements WebSiteCategoryService {

    private final WebSiteCategoryRepository repository;

    @Autowired
    public WebSiteCategoryServiceImpl(WebSiteCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(WebsiteCategory websiteCategory) {
        if (websiteCategory != null){
            repository.save(websiteCategory);
        }
    }

    @Override
    public List<WebsiteCategory> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(WebsiteCategory websiteCategory) {
        repository.delete(websiteCategory);
    }

    @Override
    public WebsiteCategory findByName(String name) {
        return repository.findByName(name);
    }
}
