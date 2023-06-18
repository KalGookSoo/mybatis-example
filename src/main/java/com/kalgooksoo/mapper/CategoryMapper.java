package com.kalgooksoo.mapper;

import com.kalgooksoo.model.Category;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper extends CRUDMapper<Category, Long> {
}
