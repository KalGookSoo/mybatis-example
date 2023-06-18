package com.kalgooksoo.mapper;

import com.kalgooksoo.criteria.Criteria;

import java.util.List;

public interface CRUDMapper<T, ID> {
    void insert(T entity);
    List<T> findAll();
    T findById(ID id);
    List<T> findByPage(Criteria<T> criteria);
    void update(T entity);
    void delete(ID id);
}
