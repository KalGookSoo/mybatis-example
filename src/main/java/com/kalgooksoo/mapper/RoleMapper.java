package com.kalgooksoo.mapper;

import com.kalgooksoo.model.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;
import java.util.Set;

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

    /**
     * 사용자 식별자에 해당하는 역할을 반환합니다.
     * 
     * @param ids 사용자 식별자
     * @return 역할
     */
    Set<Role> findByUserIdIn(Collection<Long> ids);

}
