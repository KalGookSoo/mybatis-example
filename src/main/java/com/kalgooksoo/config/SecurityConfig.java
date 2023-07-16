package com.kalgooksoo.config;

import com.kalgooksoo.service.PrincipalOauth2UserService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.annotation.Nonnull;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {

    private final UserDetailsService userDetailsService;
    private final PrincipalOauth2UserService principalOauth2UserService;

    public SecurityConfig(UserDetailsService userDetailsService, PrincipalOauth2UserService principalOauth2UserService) {
        this.userDetailsService = userDetailsService;
        this.principalOauth2UserService = principalOauth2UserService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(@Nonnull HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .antMatchers("/users/**").authenticated()
                .antMatchers("/managers/**").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers("/admins/**").hasRole("ADMIN")
                .antMatchers("/sign-in").permitAll()    // "/sign-in" 요청은 인증 없이 접근 허용 합니다.
                .anyRequest().authenticated()                       // 모든 요청은 인증된 사용자만 접근 가능하게 설정합니다.
                .and()
                .formLogin()                                        // <form>을 활용한 로그인 설정합니다.
                .loginPage("/sign-in")                              // "/sign-in" 요청을 통해 포워드 되는 페이지에서 로그인 합니다.
                .loginProcessingUrl("/sign-in")                     // "/sign-in" 요청을 통해 로그인을 진행합니다.
                .successHandler((request, response, authentication) -> response.sendRedirect("/"))
                .usernameParameter("username")                      // 식별자 name을 "username"으로 설정합니다.
                .and()
                .oauth2Login()                                      // OAuth2.0을 활용한 로그인 설정입니다.
                .loginPage("/sign-in")                              // "/sign-in" 요청을 통해 포워드 되는 페이지에서 로그인 합니다.
                .successHandler((request, response, authentication) -> response.sendRedirect("/"))
//                .failureHandler((request, response, exception) -> {}) // DefaultOAuth2UserService#loadUser에서 UsernameNotFoundException 을 발생시킨 후 sign-up 폼으로 넘기면 OAuth2.0 기반 커스텀 sign-up이 가능합니다.
                .userInfoEndpoint()                                 // OAuth 2.0 제공 업체의 사용자 정보 엔드포인트에 대한 설정을 사용할 수 있도록 선언합니다.
                .userService(principalOauth2UserService);           // DefaultOAuth2UserService 을 확장한 클래스를 선언합니다.

        return http.build();
    }

    /**
     * 정적 리소스에 대해서는 시큐리티 필터를 적용하지 않는다.
     * {@link org.springframework.boot.autoconfigure.security.StaticResourceLocation}
     *
     */
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

/*
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }
*/

/*
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {

    }
*/
}
