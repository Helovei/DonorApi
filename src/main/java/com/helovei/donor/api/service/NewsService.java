package com.helovei.donor.api.service;

import com.helovei.donor.api.model.NewsCategory;
import com.helovei.donor.api.model.NewsEntity;
import org.springframework.data.domain.Page;

public interface NewsService extends AbstractCrudService<NewsEntity> {

    Page<NewsEntity> getPage(Integer pageNo, Integer pageSize, String SortBy);

    Page<NewsEntity> getPageByCategory(Integer pageNo,String sort, Integer pageSize, NewsCategory category);

    NewsEntity getNewsEntityById(Long id);
}
