package com.kalgooksoo.service;

import com.kalgooksoo.core.Page;
import com.kalgooksoo.criteria.BoardCriteria;
import com.kalgooksoo.mapper.BoardMapper;
import com.kalgooksoo.model.Board;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class BoardService {

    private final BoardMapper boardMapper;

    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    public Collection<Board> findAll() {
        return this.boardMapper.findAll();
    }

    public Page<Board> find(BoardCriteria criteria) {
        // TODO 정렬 처리할 것
        return this.boardMapper.find(criteria);
    }

    public Board findById(Long id) {
        return this.boardMapper.findById(id);
    }

    public void insert(Board board) {
        this.boardMapper.insert(board);
    }

    public void update(Board board) {
        this.boardMapper.update(board);
    }

}
