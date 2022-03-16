package com.helovei.donor.api.service;

import com.helovei.donor.api.model.services.ServiceEntity;

import java.util.List;

public interface ServicePriceService extends AbstractCrudService<ServiceEntity> {

    List<ServiceEntity> findByForCitizens(Boolean value);

}
