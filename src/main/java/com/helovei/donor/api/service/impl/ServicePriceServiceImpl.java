package com.helovei.donor.api.service.impl;

import com.helovei.donor.api.model.services.ServiceEntity;
import com.helovei.donor.api.repository.services.ServicePriceRepository;
import com.helovei.donor.api.service.ServicePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePriceServiceImpl extends AbstractServiceImpl<ServiceEntity, ServicePriceRepository>
        implements ServicePriceService {

    @Autowired
    protected ServicePriceServiceImpl(ServicePriceRepository repository) {
        super(repository);
    }

    @Override
    public List<ServiceEntity> findByForCitizens(Boolean value) {
        return super.repository.findByForCitizens(value);
    }
}
