package com.helovei.donorApi.service;

import com.helovei.donorApi.model.NewsCategory;

public interface NewsCategoryService extends AbstractCrudService<NewsCategory> {
    NewsCategory findByName(String name);
}
