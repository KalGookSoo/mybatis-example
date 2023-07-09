package com.kalgooksoo.mapstruct;

import com.kalgooksoo.command.BoardCommand;
import com.kalgooksoo.mapstruct.decorator.BoardMapperDecorator;
import com.kalgooksoo.model.Board;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
@DecoratedWith(BoardMapperDecorator.class)
public interface BoardMapper {

    /**
     * BoardMapper 인스턴스
     */
    BoardMapper INSTANCE = Mappers.getMapper(BoardMapper.class);

    /**
     * 게시글 커맨드를 게시글 엔티티로 변환합니다.
     *
     * @param boardCommand 게시글 커맨드
     * @return 게시글 엔티티
     */
    Board convert(BoardCommand boardCommand);

    /**
     * 게시글 엔티티를 게시글 커맨드로 변환합니다.
     *
     * @param board 게시글 엔티티
     * @return 게시글 커맨드
     */
    BoardCommand convert(Board board);

    /**
     * 게시글 엔티티에 게시글 커맨드를 병합합니다.
     *
     * @param board        게시글 엔티티
     * @param boardCommand 게시글 커맨드
     * @return 게시글 엔티티
     */
    @Mapping(target = "id", ignore = true)
    Board merge(@MappingTarget Board board, BoardCommand boardCommand);

}
