package com.kalgooksoo.mapper;

import com.kalgooksoo.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends CRUDMapper<User, Long> {

    /**
     * 아이디에 해당되는 사용자 정보를 반환합니다.
     */
    User findByUsername(String username);

}
