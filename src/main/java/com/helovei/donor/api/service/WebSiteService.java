package com.helovei.donor.api.service;

import com.helovei.donor.api.model.WebsiteCategory;
import com.helovei.donor.api.model.WebsiteEntity;

import java.util.List;

public interface WebSiteService extends AbstractCrudService<WebsiteEntity>{

    List<WebsiteEntity> findByCategory(WebsiteCategory category);




}
