package com.kalgooksoo.model;

import java.util.HashSet;
import java.util.Set;

/**
 * 권한
 */
public class Authority extends Timestamped {

    /**
     * 식별자
     */
    private Long id;

    /**
     * 이름(Alternate Key)
     */
    private String name;

    /**
     * 사용자
     */
    private Set<User> users = new HashSet<>();

    /**
     * 역할
     */
    private Set<Role> roles = new HashSet<>();
}
