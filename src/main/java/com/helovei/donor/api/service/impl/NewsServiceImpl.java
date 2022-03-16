package com.helovei.donor.api.service.impl;

import com.helovei.donor.api.config.faсtories.page.PageFactory;
import com.helovei.donor.api.config.faсtories.page.PagesType;
import com.helovei.donor.api.model.NewsCategory;
import com.helovei.donor.api.model.NewsEntity;
import com.helovei.donor.api.repository.NewsRepository;
import com.helovei.donor.api.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl extends AbstractServiceImpl<NewsEntity, NewsRepository> implements NewsService {

    @Autowired
    public NewsServiceImpl(NewsRepository repository) {
        super(repository);
    }

    @Override
    public NewsEntity getNewsEntityById(Long id) {
        return super.repository.findNewsEntityById(id);
    }

    @Override
    public Page<NewsEntity> getPage(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return super.repository.findAll(paging);
    }

    @Override
    public Page<NewsEntity> getPageByCategory(Integer pageNo,String sort, Integer pageSize, NewsCategory category) {
        Pageable page = PageRequest.of(pageNo, 5, Sort.by("id"));
        return super.repository.findNewsEntityByCategory(page, category);
    }
}
