package com.kalgooksoo.mapper;

import com.kalgooksoo.model.UserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 사용자 - 역할 연계 MyBatis 매퍼
 */
@Mapper
public interface UserRoleMapper extends CRUDMapper<UserRole, Long> {

    /**
     * 사용자 식별자에 해당하는 역할을 반환합니다.
     *
     * @param userId 사용자 식별자
     * @return 사용자 - 역할 연계
     */
    List<UserRole> findByUserId(Long userId);

    /**
     * 역할 식별자에 해당하는 사용자를 반환합니다.
     *
     * @param roleId 역할 식별자
     * @return 사용자 - 역할 연계
     */
    List<UserRole> findByRoleId(Long roleId);

}
