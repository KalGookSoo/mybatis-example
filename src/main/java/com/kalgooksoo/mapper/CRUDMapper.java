package com.kalgooksoo.mapper;

import com.kalgooksoo.core.Page;
import com.kalgooksoo.criteria.PageRequest;

import java.util.List;

public interface CRUDMapper<T, ID> {

    void insert(T entity);

    List<T> findAll();

    T findById(ID id);

    List<T> findByPage(PageRequest pageRequest);

    int totalRecordCount(PageRequest pageRequest);

    void update(T entity);

    void delete(ID id);

    default Page<T> find(PageRequest pageRequest) {
        List<T> content = this.findByPage(pageRequest);
        int totalRecordCount = this.totalRecordCount(pageRequest);
        return new Page<T>(content, totalRecordCount, pageRequest.getCurrentPageNo(), pageRequest.getRecordCountPerPage(), pageRequest.getPageSize());
    }

}
