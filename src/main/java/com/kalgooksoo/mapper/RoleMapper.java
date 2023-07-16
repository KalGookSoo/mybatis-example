package com.kalgooksoo.mapper;

import com.kalgooksoo.model.Role;
import org.apache.ibatis.annotations.Mapper;

/**
 * 역할 MyBatis 매퍼
 */
@Mapper
public interface RoleMapper extends CRUDMapper<Role, Long> {

    /**
     * 이름에 해당하는 역할을 반환합니다.
     *
     * @param name 이름
     * @return 역할
     */
    Role findByName(String name);

}
