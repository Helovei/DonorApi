package com.helovei.donor.api.service.impl;

import com.helovei.donor.api.model.ServicePriceEntity;
import com.helovei.donor.api.repository.ServicePriceRepository;
import com.helovei.donor.api.service.ServicePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicePriceServiceImpl extends AbstractServiceImpl<ServicePriceEntity, ServicePriceRepository>
        implements ServicePriceService {

    @Autowired
    protected ServicePriceServiceImpl(ServicePriceRepository repository) {
        super(repository);
    }
}
