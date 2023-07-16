package com.kalgooksoo.model;

/**
 * 사용자 - 역할 연계
 */
public class UserRole extends Timestamped {

    /**
     * 사용자 - 역할 연계 식별자
     */
    private Long id;

    /**
     * 사용자 식별자
     */
    private Long userId;

    /**
     * 역할 식별자
     */
    private Long roleId;

    /**
     * 생성자
     *
     * @param userId 사용자 식별자
     * @param roleId 역할 식별자
     */
    public UserRole(Long userId, Long roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    /**
     * 사용자 - 역할 연계 식별자 접근자
     * 
     * @return 사용자 - 역할 연계 식별자
     */
    public Long getId() {
        return id;
    }

    /**
     * 사용자 - 역할 연계 식별자 설정자
     * 
     * @param id 사용자 - 역할 연계 식별자
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 사용자 식별자 접근자
     * 
     * @return 사용자 식별자
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 사용자 식별자 설정자
     * 
     * @param userId 사용자 식별자
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 역할 식별자 접근자
     * 
     * @return 역할 식별자
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 역할 식별자 설정자
     * 
     * @param roleId 역할 식별자
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
