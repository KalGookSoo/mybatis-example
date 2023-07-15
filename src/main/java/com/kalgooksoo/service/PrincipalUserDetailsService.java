package com.kalgooksoo.service;

import com.kalgooksoo.mapper.UserMapper;
import com.kalgooksoo.model.User;
import com.kalgooksoo.security.UserPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * SecurityConfig에서 loginProcessingUrl에 명시한 요청이 오면 자동으로 UserDetailsService 타입으로 IoC되어 있는 loadUserByUsername 메소드가 호출된다.
 */
@Service
public class PrincipalUserDetailsService implements UserDetailsService {
    private final UserMapper userMapper;

    public PrincipalUserDetailsService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User foundUser = Optional.ofNullable(userMapper.findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return new UserPrincipal(foundUser);
    }

}
