package com.helovei.donorApi.service;

import com.helovei.donorApi.model.RoleEntity;

public interface RoleService extends AbstractCrudService<RoleEntity>{

    RoleEntity findByName(String name);

}
