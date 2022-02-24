package com.helovei.donor.api.service.impl;

import com.helovei.donor.api.model.NewsCategory;
import com.helovei.donor.api.repository.NewsCategoryRepository;
import com.helovei.donor.api.service.NewsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsCategoryServiceImpl extends AbstractServiceImpl<NewsCategory, NewsCategoryRepository>
        implements NewsCategoryService {

    @Autowired
    public NewsCategoryServiceImpl(NewsCategoryRepository repository) {
        super(repository);
    }

    @Override
    public NewsCategory findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public NewsCategory findById(Long id) {
        return repository.findNewsCategoryById(id);
    }
}
