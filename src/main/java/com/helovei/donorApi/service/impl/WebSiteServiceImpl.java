package com.helovei.donorApi.service.impl;

import com.helovei.donorApi.model.WebSiteEntity;
import com.helovei.donorApi.repository.WebSiteRepository;
import com.helovei.donorApi.service.WebSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebSiteServiceImpl implements WebSiteService {

    @Autowired
    private WebSiteRepository repository;

    @Override
    public boolean save(WebSiteEntity webSiteEntity) {
        repository.save(webSiteEntity);
        return true;
    }

    @Override
    public boolean delete(WebSiteEntity webSiteEntity) {
        repository.delete(webSiteEntity);
        return true;
    }

    @Override
    public Iterable<WebSiteEntity> getAll() {
        return repository.findAll();
    }
}
