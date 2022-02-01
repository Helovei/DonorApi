package com.helovei.donor.api.service;

import com.helovei.donor.api.model.WebsiteCategory;

public interface WebSiteCategoryService extends AbstractCrudService<WebsiteCategory> {

    WebsiteCategory findByName(String name);

}
