package com.helovei.donor.api.service.blood;

import com.helovei.donor.api.model.blood.BloodRhEntity;
import com.helovei.donor.api.model.blood.BloodStatusEntity;
import com.helovei.donor.api.service.AbstractCrudService;

import java.util.List;

public interface BloodStatusService extends AbstractCrudService<BloodStatusEntity> {

    List<BloodStatusEntity> findAllBloodStatusByBloodRh(List<BloodRhEntity> bloodRhEntityList);

}
