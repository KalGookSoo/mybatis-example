package com.kalgooksoo.security;

import com.kalgooksoo.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Spring Security 가 loginProcessingUrl 에 명시한 요청이 오면 낚아채서 로그인을 진행시킨다.
 * 로그인 진행이 완료가 되면 세션을 만들어준다.
 * Security ContextHolder 에 세션 정보를 저장시킨다.
 * Authentication 안에 User(UserDetails) 정보가 있어야 한다.
 * Security 세션에는 Authentication 타입의 객체가 있어야 하고 Authentication 안에는 UserDetails(PrincipalDetails) 타입의 객체가 있어야 한다.
 */
@SuppressWarnings("unused")
public class UserPrincipal implements UserDetails, OAuth2User, Serializable {

    /**
     * 사용자
     */
    private User user;

    /**
     * 속성
     */
    private Map<String, Object> attributes;

    /**
     * 일반 로그인할 때 생성되는 생성자

     * @param user 사용자
     */
    public UserPrincipal(User user) {
        this.user = user;
    }

    /**
     * OAuth 로그인할 때 생성되는 생성자
     *
     * @param user       사용자
     * @param attributes 속성
     */
    public UserPrincipal(User user, Map<String, Object> attributes) {
        this.user = user;
        this.attributes = attributes;
    }

    protected UserPrincipal() {
    }

    /**
     * 역할 접근자
     *
     * @return 역할
     */
    @Override
    public Set<? extends GrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> roles = new HashSet<>();
        this.user.getRoles().forEach(role -> roles.add(new SimpleGrantedAuthority(role.getName())));
        return roles;
    }

    /**
     * 패스워드 접근자
     *
     * @return 패스워드
     */
    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    /**
     * 아이디 접근자
     *
     * @return 아이디
     */
    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    /**
     * 사용자 계정이 만료되지 않았음을 확인합니다.
     *
     * @return 계정 만료 여부
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 사용자 계정이 잠기지 않았음을 확인합니다.
     *
     * @return 계정 잠김 여부
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 사용자 인증 정보가 만료되지 않았음을 확인합니다.
     *
     * @return 인증 정보 만료 여부
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 사용자 계정이 활성화 상태인지 확인합니다.
     *
     * @return 계정 활성화 여부
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * 이름 접근자
     * "sub"는 OAuth2.0 인증정보의 Primary Key
     *
     * @return 속성의 sub 값
     */
    @Override
    public String getName() {
        return (String) attributes.get("sub");
    }

    /**
     * 주어진 이름에 해당하는 OAuth2User의 속성을 반환합니다.
     *
     * @param name 속성의 이름
     * @return 이름에 해당하는 OAuth2User 속성 값
     */
    @Override
    public <A> A getAttribute(String name) {
        return OAuth2User.super.getAttribute(name);
    }

    /**
     * 속성 접근자
     *
     * @return 속성
     */
    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    /**
     * 사용자 접근자
     * 
     * @return 사용자
     */
    public User getUser() {
        return user;
    }
}
