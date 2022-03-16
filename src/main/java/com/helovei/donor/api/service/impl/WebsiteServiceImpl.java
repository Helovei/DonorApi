package com.helovei.donor.api.service.impl;

import com.helovei.donor.api.model.WebsiteCategory;
import com.helovei.donor.api.model.WebsiteEntity;
import com.helovei.donor.api.repository.WebsiteRepository;
import com.helovei.donor.api.service.WebSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebsiteServiceImpl extends AbstractServiceImpl<WebsiteEntity, WebsiteRepository>
        implements WebSiteService {

    @Autowired
    public WebsiteServiceImpl(WebsiteRepository repository) {
        super(repository);
    }

    @Override
    public void save(WebsiteEntity entity) {
        if (entity != null) {
            super.repository.save(entity);
        }
    }

    @Override
    public List<WebsiteEntity> findByCategory(WebsiteCategory category) {
        return super.repository.findByCategory(category, Sort.by("id"));
    }
}
