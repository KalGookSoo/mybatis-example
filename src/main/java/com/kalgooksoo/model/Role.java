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
     * 이름
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

    public String getName() {
        return name;
    }
}
