package com.kalgooksoo.mapper;

import com.kalgooksoo.model.Board;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper extends CRUDMapper<Board, Long> {
}
