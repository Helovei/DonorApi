package com.helovei.donor.api.service.impl;

import com.helovei.donor.api.service.AbstractCrudService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class AbstractServiceImpl<T,E extends JpaRepository<T, Long>> implements AbstractCrudService<T> {

    protected final E repository;

    protected AbstractServiceImpl(E repository) {
        this.repository = repository;
    }

    @Override
    public void save(T t) {
        repository.save(t);
    }

    @Override
    public List<T> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(T t) {
        repository.delete(t);
    }
}
