package com.kalgooksoo.mapper;

import com.kalgooksoo.model.Board;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper extends CRUDMapper<Board, Long> {

    /**
     * 조회수를 1 증가시킵니다.
     */
    void increaseHit(Long id);

}
