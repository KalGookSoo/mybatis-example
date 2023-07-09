package com.kalgooksoo.mapstruct.decorator;

import com.kalgooksoo.command.BoardCommand;
import com.kalgooksoo.mapstruct.BoardMapper;
import com.kalgooksoo.model.Board;

public class BoardMapperDecorator implements BoardMapper {

    /** Mapstruct Mapper delegate instance */
    private final BoardMapper delegate;

    /**
     * BoardMapperDecorator 생성자
     *
     * @param delegate Mapstruct Mapper delegate instance
     */
    public BoardMapperDecorator(BoardMapper delegate) {
        this.delegate = delegate;
    }

    /**
     * @see BoardMapper#convert(BoardCommand)
     */
    @Override
    public Board convert(BoardCommand boardCommand) {
        Board board = this.delegate.convert(boardCommand);
        return board;
    }

    /**
     * @see BoardMapper#convert(Board)
     */
    @Override
    public BoardCommand convert(Board board) {
        BoardCommand command = this.delegate.convert(board);
        return command;
    }

    /**
     * @see BoardMapper#merge(Board, BoardCommand)
     */
    @Override
    public Board merge(Board board, BoardCommand boardCommand) {
        Board mergedBoard = this.delegate.merge(board, boardCommand);
        return mergedBoard;
    }
}
