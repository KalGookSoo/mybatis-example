package com.kalgooksoo.service;

import com.kalgooksoo.mapper.RoleMapper;
import com.kalgooksoo.mapper.UserMapper;
import com.kalgooksoo.mapper.UserRoleMapper;
import com.kalgooksoo.model.Role;
import com.kalgooksoo.model.User;
import com.kalgooksoo.model.UserRole;
import com.kalgooksoo.security.UserPrincipal;
import com.kalgooksoo.security.provider.FacebookUserDetail;
import com.kalgooksoo.security.provider.GoogleUserDetail;
import com.kalgooksoo.security.provider.NaverUserDetail;
import com.kalgooksoo.security.provider.OAuth2UserDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import java.util.Optional;

@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

    /**
     * Logger 출력을 위한 객체
     */
    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 사용자 MyBatis 매퍼
     */
    private final UserMapper userMapper;

    /**
     * 역할 MyBatis 매퍼
     */
    private final RoleMapper roleMapper;

    /**
     * 사용자 - 역할 연계 MyBatis 매퍼
     */
    private final UserRoleMapper userRoleMapper;

    /**
     * 생성자
     *
     * @param userMapper     사용자 MyBatis 매퍼
     * @param roleMapper     역할 MyBatis 매퍼
     * @param userRoleMapper 사용자 - 역할 연계 MyBatis 매퍼
     */
    public PrincipalOauth2UserService(UserMapper userMapper, RoleMapper roleMapper, UserRoleMapper userRoleMapper) {
        this.userMapper = userMapper;
        this.roleMapper = roleMapper;
        this.userRoleMapper = userRoleMapper;
    }

    /**
     * OAuth2.0 로그인에 성공하면 호출됩니다.
     * 로그인 버튼 클릭 -> 로그인창 -> 로그인 완료 -> code를 return -> AccessToken 요청
     * userRequest 정보 -> loadUser 호출 -> 회원프로필이 OAuth2UserRequest 에 담겨있음
     * 
     * @param userRequest the user request
     * @return OAuth2User
     * @throws OAuth2AuthenticationException
     */
    @Override
    public OAuth2User loadUser(@Nonnull OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        logger.info("AccessToken: {}",userRequest.getAccessToken());
        logger.info("ClientRegistration: {}", userRequest.getClientRegistration());

        OAuth2User oAuth2User = super.loadUser(userRequest);
        logger.info("Attributes: {}", oAuth2User.getAttributes());

        /* 페이스북의 PK가 다르므로 */
        OAuth2UserDetail oAuth2UserDetail;
        if ("google".equals(userRequest.getClientRegistration().getRegistrationId())) {
            oAuth2UserDetail = new GoogleUserDetail(oAuth2User.getAttributes());
        } else if ("facebook".equals(userRequest.getClientRegistration().getRegistrationId())) {
            oAuth2UserDetail = new FacebookUserDetail(oAuth2User.getAttributes());
        } else if ("naver".equals(userRequest.getClientRegistration().getRegistrationId())) {
            oAuth2UserDetail = new NaverUserDetail(oAuth2User.getAttributes());
        } else {
            throw new OAuth2AuthenticationException("OAuth2.0 에러에 대한 커스텀 에러코드를 여기에 넣어야 합니다.");
        }

        String provider = oAuth2UserDetail.getProvider();
        String providerId = oAuth2UserDetail.getProviderId();
        String username = provider + "_" + providerId;
        String email = oAuth2UserDetail.getEmail();

        /* 사용자를 조회했을 때 없으면 생성하여 반환합니다. */
        User foundUser = Optional.ofNullable(userMapper.findByUsername(email)).orElseGet(() -> {

            /* ROLE_USER 역할을 가진 사용자를 생성합니다. */
            Role role = roleMapper.findByName("ROLE_USER");
            User user = new User(username, email).addRole(role);
            Long userId = userMapper.insert(user);

            /* 회원을 역할에 매핑합니다. */
            UserRole userRole = new UserRole(userId, role.getId());
            userRoleMapper.insert(userRole);
            return user;
        });

        return new UserPrincipal(foundUser, oAuth2User.getAttributes());
    }
}
