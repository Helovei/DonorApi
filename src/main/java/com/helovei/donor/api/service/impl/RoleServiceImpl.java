package com.helovei.donor.api.service.impl;

import com.helovei.donor.api.model.RoleEntity;
import com.helovei.donor.api.repository.RoleRepository;
import com.helovei.donor.api.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.List;

@Service
public class RoleServiceImpl extends AbstractServiceImpl<RoleEntity, RoleRepository>
        implements RoleService {

    @Autowired
    public RoleServiceImpl(RoleRepository repository) {
        super(repository);
    }

    @Override
    public RoleEntity findByName(String name) {
        return super.repository.findByName(name);
    }
}
