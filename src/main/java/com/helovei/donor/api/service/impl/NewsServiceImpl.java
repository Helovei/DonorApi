package com.helovei.donor.api.service.impl;

import com.helovei.donor.api.model.NewsEntity;
import com.helovei.donor.api.repository.NewsRepository;
import com.helovei.donor.api.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    private final NewsRepository repository;

    @Autowired
    public NewsServiceImpl(NewsRepository repository) {
        this.repository = repository;
    }

    @Override
    public NewsEntity getNewsEntityById(Long id) {
        return repository.getNewsEntityById(id);
    }

    @Override
    public void save(NewsEntity news) {
        repository.save(news);
    }

    @Override
    public List<NewsEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(NewsEntity news) {
        repository.delete(news);
    }

    @Override
    public List<NewsEntity> getLastEntity() {
        return repository.getLastEntity();
    }
}
