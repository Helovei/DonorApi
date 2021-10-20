package com.helovei.donorApi.service.impl;

import com.helovei.donorApi.model.WebsiteCategory;
import com.helovei.donorApi.model.WebsiteEntity;
import com.helovei.donorApi.repository.WebsiteRepository;
import com.helovei.donorApi.service.WebSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebsiteServiceImpl implements WebSiteService {

    private final WebsiteRepository repository;

    @Autowired
    public WebsiteServiceImpl(WebsiteRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(WebsiteEntity entity) {
        if (entity != null) {
            repository.save(entity);
        }
    }

    @Override
    public void delete(WebsiteEntity entity) {
        repository.delete(entity);
    }

    @Override
    public List<WebsiteEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public List<WebsiteEntity> findByCategory(WebsiteCategory category) {
        return repository.findByCategory(category);
    }
}
