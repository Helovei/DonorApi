package com.helovei.donor.api.service.impl;

import com.helovei.donor.api.model.TypeOfServiceEntity;
import com.helovei.donor.api.repository.TypeOfServiceRepository;
import com.helovei.donor.api.service.TypeOfServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeOfServiceServiceImpl extends AbstractServiceImpl<TypeOfServiceEntity, TypeOfServiceRepository>
        implements TypeOfServiceService {

    @Autowired
    public TypeOfServiceServiceImpl(TypeOfServiceRepository repository) {
        super(repository);
    }
}
