package com.helovei.donor.api.service.impl;

import com.helovei.donor.api.model.services.ProcedureCategory;
import com.helovei.donor.api.repository.services.ProcedureCategoryRepository;
import com.helovei.donor.api.service.ProcedureCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcedureCategoryServiceImpl extends AbstractServiceImpl<ProcedureCategory, ProcedureCategoryRepository>
        implements ProcedureCategoryService {

    @Autowired
    public ProcedureCategoryServiceImpl(ProcedureCategoryRepository repository) {
        super(repository);
    }
}
