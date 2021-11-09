package com.helovei.donorApi.service;

import com.helovei.donorApi.model.NewsEntity;

import java.util.List;

public interface NewsService extends AbstractCrudService<NewsEntity> {
    List<NewsEntity> getLastEntity();
}
