package com.helovei.donor.api.service.impl.blood;

import com.helovei.donor.api.model.blood.BloodRhEntity;
import com.helovei.donor.api.repository.blood.BloodRhRepository;
import com.helovei.donor.api.service.blood.BloodRhService;
import com.helovei.donor.api.service.impl.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BloodRhServiceImpl extends AbstractServiceImpl<BloodRhEntity, BloodRhRepository> implements BloodRhService {

    @Autowired
    private BloodRhServiceImpl(BloodRhRepository repository) {
        super(repository);
    }
}
