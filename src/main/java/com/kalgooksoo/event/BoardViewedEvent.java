package com.kalgooksoo.event;

import com.kalgooksoo.model.Board;
import org.springframework.context.ApplicationEvent;

public class BoardViewedEvent extends ApplicationEvent {

    private final Board board;

    public BoardViewedEvent(Board board) {
        super(board);
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

}
