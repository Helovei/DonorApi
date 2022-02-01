package com.helovei.donor.api.service;

import com.helovei.donor.api.model.NewsCategory;

public interface NewsCategoryService extends AbstractCrudService<NewsCategory> {
    NewsCategory findByName(String name);
}
