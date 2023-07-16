package com.kalgooksoo.service;

import com.kalgooksoo.core.Page;
import com.kalgooksoo.criteria.BoardCriteria;
import com.kalgooksoo.event.BoardViewedEvent;
import com.kalgooksoo.mapper.BoardMapper;
import com.kalgooksoo.model.Board;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 게시글 관리 서비스 객체
 */
@Service
@Transactional
public class BoardService {

    private final BoardMapper boardMapper;

    private final ApplicationEventPublisher eventPublisher;

    public BoardService(BoardMapper boardMapper, ApplicationEventPublisher eventPublisher) {
        this.boardMapper = boardMapper;
        this.eventPublisher = eventPublisher;
    }

    /**
     * 조건에 해당하는 게시글 리스트를 반환합니다.
     *
     * @param criteria 조건
     * @return 페이지
     */
    public Page<Board> findByCategoryId(BoardCriteria criteria) {

        // TODO 정렬 처리할 것
        return this.boardMapper.find(criteria);
    }

    /**
     * 게시글 식별자에 해당하는 게시글을 반환합니다.
     *
     * @param id 게시글 식별자
     * @return 게시글
     */
    public Board findById(Long id) {
        return this.boardMapper.findById(id);
    }

    /**
     * 게시글 식별자에 해당하는 게시글을 반환합니다.
     * 게시글 조회수를 증가시킵니다.
     *
     * @param id
     * @return
     */
    public Board view(Long id) {
        Board board = this.boardMapper.findById(id);
        this.eventPublisher.publishEvent(new BoardViewedEvent(board));
        return board;
    }

    public Long insert(Board board) {
        return this.boardMapper.insert(board);
    }

    public void update(Board board) {
        this.boardMapper.update(board);
    }

}
