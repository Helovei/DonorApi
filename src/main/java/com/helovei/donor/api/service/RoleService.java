package com.helovei.donor.api.service;

import com.helovei.donor.api.model.RoleEntity;

public interface RoleService extends AbstractCrudService<RoleEntity>{

    RoleEntity findByName(String name);

}
