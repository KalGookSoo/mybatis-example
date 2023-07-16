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
     * 이메일
     */
    private String email;

    /**
     * 연락처
     */
    private String contactNumber;

    /**
     * 권한
     */
    private Set<Authority> authorities = new HashSet<>();

    /**
     * 역할
     */
    private Set<Role> roles = new HashSet<>();

    /**
     * 생성자
     *
     * @param username 아이디
     * @param email    이메일
     */
    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    /**
     * 아이디 접근자
     *
     * @return 아이디
     */
    public String getUsername() {
        return username;
    }

    /**
     * 패스워드 접근자
     *
     * @return 패스워드
     */
    public String getPassword() {
        return password;
    }

    /**
     * 역할 접근자
     *
     * @return 역할
     */
    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * 역할을 추가합니다.
     *
     * @param role 역할
     * @return 사용자
     */
    public User addRole(Role role) {
        this.roles.add(role);
        return this;
    }

    /**
     * 식별자 접근자
     *
     * @return 식별자
     */
    public Long getId() {
        return id;
    }

    /**
     * 식별자 설정자
     *
     * @param id 식별자
     */
    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
