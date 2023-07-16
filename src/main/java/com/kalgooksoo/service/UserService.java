package com.kalgooksoo.service;

import com.kalgooksoo.core.Page;
import com.kalgooksoo.criteria.UserCriteria;
import com.kalgooksoo.mapper.UserMapper;
import com.kalgooksoo.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 사용자 관리 서비스
 */
@Service
@Transactional
public class UserService {

    /**
     * 사용자 MyBatis 매퍼
     */
    private final UserMapper userMapper;

    /**
     * 생성자
     *
     * @param userMapper 사용자 MyBatis 매퍼
     */
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 조건에 해당하는 사용자 리스트를 반환합니다.
     *
     * @param criteria 조건
     * @return 페이지
     */
    public Page<User> find(UserCriteria criteria) {

        // TODO 정렬 처리할 것
        return this.userMapper.find(criteria);
    }

    /**
     * 사용자 식별자에 해당하는 사용자을 반환합니다.
     *
     * @param id 사용자 식별자
     * @return 사용자
     */
    public User findById(Long id) {
        return this.userMapper.findById(id);
    }

    /**
     * 사용자을 생성합니다.
     *
     * @param user 사용자
     */
    public Long insert(User user) {
        return this.userMapper.insert(user);
    }

    /**
     * 사용자을 수정합니다.
     *
     * @param user 사용자
     */
    public void update(User user) {
        this.userMapper.update(user);
    }

}
