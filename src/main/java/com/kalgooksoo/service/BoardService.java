package com.kalgooksoo.service;

import com.kalgooksoo.core.Page;
import com.kalgooksoo.criteria.BoardCriteria;
import com.kalgooksoo.event.BoardViewedEvent;
import com.kalgooksoo.mapper.BoardMapper;
import com.kalgooksoo.model.Board;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BoardService {

    private final BoardMapper boardMapper;

    private final ApplicationEventPublisher eventPublisher;

    public BoardService(BoardMapper boardMapper, ApplicationEventPublisher eventPublisher) {
        this.boardMapper = boardMapper;
        this.eventPublisher = eventPublisher;
    }

    public Page<Board> findByCategoryId(BoardCriteria criteria) {

        // TODO 정렬 처리할 것
        return this.boardMapper.find(criteria);
    }

    public Board findById(Long id) {
        return this.boardMapper.findById(id);
    }

    public Board view(Long id) {
        Board board = this.boardMapper.findById(id);
        this.eventPublisher.publishEvent(new BoardViewedEvent(board));
        return board;
    }

    public void insert(Board board) {
        this.boardMapper.insert(board);
    }

    public void update(Board board) {
        this.boardMapper.update(board);
    }

}
