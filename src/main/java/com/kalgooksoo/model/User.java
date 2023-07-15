package com.kalgooksoo.model;

import java.util.HashSet;
import java.util.Set;

/**
 * 사용자
 */
public class User extends Timestamped {

    /**
     * 식별자
     */
    private Long id;

    /**
     * 아이디(Alternate Key)
     */
    private String username;

    /**
     * 이름
     */
    private String name;

    /**
     * 패스워드
     */
    private String password;

    /**
     * 권한
     */
    private Set<Authority> authorities = new HashSet<>();

    /**
     * 역할
     */
    private Set<Role> roles = new HashSet<>();

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Set<Role> getRoles() {
        return roles;
    }
}
