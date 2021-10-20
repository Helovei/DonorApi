package com.helovei.donorApi.service;

import com.helovei.donorApi.model.WebsiteCategory;

public interface WebSiteCategoryService extends AbstractCrudService<WebsiteCategory> {

    WebsiteCategory findByName(String name);

}
