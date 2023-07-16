package com.kalgooksoo.mapstruct;

import com.kalgooksoo.command.UserCommand;
import com.kalgooksoo.mapstruct.decorator.UserMapperDecorator;
import com.kalgooksoo.model.User;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

/**
 * 사용자 데이터 변환 매퍼
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
@DecoratedWith(UserMapperDecorator.class)
public interface UserMapper {

    /**
     * UserMapper 인스턴스
     */
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    /**
     * 사용자 커맨드를 사용자 엔티티로 변환합니다.
     *
     * @param userCommand 사용자 커맨드
     * @return 사용자 엔티티
     */
    User convert(UserCommand userCommand);

    /**
     * 사용자 엔티티를 사용자 커맨드로 변환합니다.
     *
     * @param user 사용자 엔티티
     * @return 사용자 커맨드
     */
    UserCommand convert(User user);

    /**
     * 사용자 엔티티에 사용자 커맨드를 병합합니다.
     *
     * @param user        사용자 엔티티
     * @param userCommand 사용자 커맨드
     * @return 사용자 엔티티
     */
    @Mapping(target = "id", ignore = true)
    User merge(@MappingTarget User user, UserCommand userCommand);

}
