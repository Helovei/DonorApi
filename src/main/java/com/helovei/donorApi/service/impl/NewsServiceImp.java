package com.helovei.donorApi.service.impl;

import com.helovei.donorApi.model.NewsEntity;
import com.helovei.donorApi.repository.NewsRepository;
import com.helovei.donorApi.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImp implements NewsService {

    @Autowired
    private NewsRepository repository;

    @Override
    public boolean save(NewsEntity news) {
        if (news != null) {
            repository.save(news);
            return true;
        } else return false;
    }

    @Override
    public boolean delete(NewsEntity news) {
        if (news != null) {
            repository.delete(news);
            return true;
        } else return false;
    }

    @Override
    public Iterable<NewsEntity> getAll() {
        return repository.findAll();
    }
}
