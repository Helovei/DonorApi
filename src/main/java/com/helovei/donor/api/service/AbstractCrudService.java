package com.helovei.donor.api.service;

import java.util.List;

public interface AbstractCrudService<T> {

    void save(T t);

    List<T> getAll();

    void delete(T t);

}
