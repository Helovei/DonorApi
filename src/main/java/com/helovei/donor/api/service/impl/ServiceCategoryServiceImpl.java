package com.helovei.donor.api.service.impl;

import com.helovei.donor.api.model.services.ServiceCategory;
import com.helovei.donor.api.repository.services.ServiceCategoryRepository;
import com.helovei.donor.api.service.ServiceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceCategoryServiceImpl extends AbstractServiceImpl<ServiceCategory, ServiceCategoryRepository>
        implements ServiceCategoryService {

    @Autowired
    public ServiceCategoryServiceImpl(ServiceCategoryRepository repository) {
        super(repository);
    }
}
