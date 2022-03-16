package com.helovei.donor.api.service.impl.blood;

import com.helovei.donor.api.model.blood.BloodRhEntity;
import com.helovei.donor.api.model.blood.BloodStatusEntity;
import com.helovei.donor.api.repository.blood.BloodStatusRepository;
import com.helovei.donor.api.service.blood.BloodStatusService;
import com.helovei.donor.api.service.impl.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class BloodStatusServiceImpl extends AbstractServiceImpl<BloodStatusEntity, BloodStatusRepository> implements BloodStatusService {

    @Autowired
    private BloodStatusServiceImpl(BloodStatusRepository repository) {
        super(repository);
    }

    @Override
    public List<BloodStatusEntity> findAllBloodStatusByBloodRh(List<BloodRhEntity> bloodRhEntityList) {
        return bloodRhEntityList.stream()
                .map(super.repository::findDistinctFirstByrH)
                .collect(Collectors.toList());
    }
}
