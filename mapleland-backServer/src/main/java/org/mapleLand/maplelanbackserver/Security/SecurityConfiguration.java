package org.mapleLand.maplelanbackserver.Security;

import lombok.RequiredArgsConstructor;
import org.mapleLand.maplelanbackserver.Service.CustomerOauth2UserService;
import org.mapleLand.maplelanbackserver.handler.Oauth2FailHandler;
import org.mapleLand.maplelanbackserver.handler.Oauth2LoginSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuration  : 이 클래스가 설정 클래스임을 의미(Spring 설정 Bean 등록)
 * EnableWebSecurity : Spring Security 활성화
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final CustomerOauth2UserService customerOauth2UserService;
    private final Oauth2LoginSuccessHandler oauth2LoginSuccessHandler;
    private final Oauth2FailHandler oauth2FailHandler;
    /**
     * Bean : Spring Security가 사용할 보안 필터 체인(SecurityFilterChain)을 직접 커스터 마이징
     * 이게 없으면 Spring이 기본 설정으로 필터체인을 만든다.
     * 실행되면 Bean으로 등록한 SecurityFilterChain이 DelegatingFilterProxy에 있는
     * SecurityFilterChain으로 바꿔준다.
     */
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().permitAll()
                )
                .oauth2Login(oauth2 ->
                        oauth2.loginPage("/login")
                                .userInfoEndpoint(userInfo ->
                                        userInfo.userService(customerOauth2UserService))
                                .successHandler(oauth2LoginSuccessHandler)
                                .failureHandler((request, response, exception) -> {
                                    response.sendRedirect("/oauth2/failure");
                                }));

        return http.build();

    }
}
