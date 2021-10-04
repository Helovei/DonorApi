package com.helovei.donorApi.service;

import com.helovei.donorApi.model.NewsEntity;

public interface AbstractService<T> {

    boolean save(T t);

    boolean delete(T t);

    Iterable<T> getAll();

}
