package com.kalgooksoo.criteria;

/**
 * 사용자 검색 조건
 */
public class UserCriteria extends PageRequest {

    /**
     * 아이디
     */
    private String username;

    /**
     * 이름
     */
    private String name;

    /**
     * 아이디 접근자
     *
     * @return 아이디
     */
    public String getUsername() {
        return username;
    }

    /**
     * 아이디 설정자
     *
     * @param username 아이디
     */
    public void setUsername(String username) {
        this.username = username;
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
     * 이름 설정자
     *
     * @param name 이름
     */
    public void setName(String name) {
        this.name = name;
    }
}
