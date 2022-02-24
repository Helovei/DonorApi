package com.helovei.donor.api.service.impl;

import com.helovei.donor.api.model.WebsiteCategory;
import com.helovei.donor.api.repository.WebSiteCategoryRepository;
import com.helovei.donor.api.service.WebSiteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebSiteCategoryServiceImpl extends AbstractServiceImpl<WebsiteCategory, WebSiteCategoryRepository>
        implements WebSiteCategoryService {

    @Autowired
    public WebSiteCategoryServiceImpl(WebSiteCategoryRepository repository) {
        super(repository);
    }

    @Override
    public void save(WebsiteCategory websiteCategory) {
        if (websiteCategory != null){
            super.repository.save(websiteCategory);
        }
    }

    @Override
    public WebsiteCategory findById(Long id) {
        return super.repository.findWebsiteCategoriesById(id);
    }
}
