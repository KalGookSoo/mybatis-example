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
     * 이메일
     */
    private String email;

    /**
     * 연락처
     */
    private String contactNumber;

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

    /**
     * 이메일 접근자
     * 
     * @return 이메일
     */
    public String getEmail() {
        return email;
    }

    /**
     * 이메일 설정자
     * 
     * @param email 이메일
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 연락처 접근자
     * 
     * @return 연락처
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * 연락처 설정자
     * 
     * @param contactNumber 연락처
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
