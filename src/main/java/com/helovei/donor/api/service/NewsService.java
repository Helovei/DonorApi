package com.helovei.donor.api.service;

import com.helovei.donor.api.model.NewsEntity;

import java.util.List;

public interface NewsService extends AbstractCrudService<NewsEntity> {
    List<NewsEntity> getLastEntity();

    NewsEntity getNewsEntityById(Long id);
}
