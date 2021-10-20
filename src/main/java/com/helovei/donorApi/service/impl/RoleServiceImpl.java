package com.helovei.donorApi.service.impl;

import com.helovei.donorApi.model.RoleEntity;
import com.helovei.donorApi.repository.RoleRepository;
import com.helovei.donorApi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;

    @Autowired
    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(RoleEntity roleEntity) {
        repository.save(roleEntity);
    }

    @Override
    public List<RoleEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(RoleEntity roleEntity) {
        repository.delete(roleEntity);
    }

    @Override
    public RoleEntity findByName(String name) {
        return repository.findByName(name);
    }
}
