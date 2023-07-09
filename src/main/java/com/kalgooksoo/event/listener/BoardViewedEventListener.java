package com.kalgooksoo.event.listener;

import com.kalgooksoo.event.BoardViewedEvent;
import com.kalgooksoo.mapper.BoardMapper;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BoardViewedEventListener {

    private final BoardMapper boardMapper;

    public BoardViewedEventListener(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    @EventListener
    public void handleBoardViewedEvent(BoardViewedEvent event) {
        this.boardMapper.increaseHit(event.getBoard().getId());
    }

}
