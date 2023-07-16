package com.kalgooksoo.model;

import java.util.Set;

/**
 * 역할
 */
public class Role extends Timestamped {

    /**
     * 식별자
     */
    private Long id;

    /**
     * 이름(Alternate Key)
     */
    private String name;

    /**
     * 권한
     */
    private Set<Authority> authorities;

    /**
     * 사용자
     */
    private Set<User> users;

    /**
     * 생성자
     *
     * @param name 이름
     */
    public Role(String name) {
        this.name = name;
    }

    /**
     * 이름 접근자
     *
     * @return 이름
     */
    public String getName() {
        return name;
    }

    /**
     * 역할 식별자 접근자
     *
     * @return 역할 식별자
     */
    public Long getId() {
        return id;
    }
}
