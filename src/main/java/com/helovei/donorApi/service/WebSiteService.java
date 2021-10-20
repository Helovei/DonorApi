package com.helovei.donorApi.service;

import com.helovei.donorApi.model.WebsiteCategory;
import com.helovei.donorApi.model.WebsiteEntity;

import java.util.List;

public interface WebSiteService extends AbstractCrudService<WebsiteEntity>{

    List<WebsiteEntity> findByCategory(WebsiteCategory category);


}
