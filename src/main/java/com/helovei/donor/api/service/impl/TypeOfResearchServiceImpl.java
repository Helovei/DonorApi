package com.helovei.donor.api.service.impl;

import com.helovei.donor.api.model.TypeOfResearchEntity;
import com.helovei.donor.api.repository.TypeOfResearchRepository;
import com.helovei.donor.api.service.TypeOfResearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeOfResearchServiceImpl extends AbstractServiceImpl<TypeOfResearchEntity, TypeOfResearchRepository>
        implements TypeOfResearchService {

    @Autowired
    public TypeOfResearchServiceImpl(TypeOfResearchRepository repository) {
        super(repository);
    }
}
