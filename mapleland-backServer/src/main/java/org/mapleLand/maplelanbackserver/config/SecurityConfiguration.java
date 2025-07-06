package org.mapleLand.maplelanbackserver.config;

import lombok.RequiredArgsConstructor;
import org.mapleLand.maplelanbackserver.filter.JwtTokenFilter;
import org.mapleLand.maplelanbackserver.jwtUtil.JwtUtil;
import org.mapleLand.maplelanbackserver.service.CustomerOauth2UserService;
import org.mapleLand.maplelanbackserver.handler.Oauth2FailHandler;
import org.mapleLand.maplelanbackserver.handler.Oauth2LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.crypto.SecretKey;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    @Value("${frontend.redirect-url}")
    String redirectUrl;

    private final CustomerOauth2UserService customerOauth2UserService;
    private final Oauth2LoginSuccessHandler oauth2LoginSuccessHandler;
    private final Oauth2FailHandler oauth2FailHandler;
    private final JwtTokenFilter jwtFilter;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http, ClientRegistrationRepository clients) throws Exception {
//        DefaultOAuth2AuthorizationRequestResolver resolver =
//                new DefaultOAuth2AuthorizationRequestResolver(clients, "/oauth2/authorization");
//        resolver.setAuthorizationRequestCustomizer(customizer ->
//                customizer.redirectUri("https://bug-known-goblin.ngrok-free.app/login/oauth2/code/discord")
//        );

        http
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .csrf(csrf -> csrf.disable())
                .formLogin(form -> form.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                        .requestMatchers("/manager/**").hasAnyRole("MANAGER","ADMIN")
                        .requestMatchers("api/create/**").hasAnyRole("USER","MANAGER","ADMIN")
                        .requestMatchers("/api/**").permitAll()
                        .anyRequest().permitAll()
                )
                .oauth2Login(oauth2 ->
                        oauth2
                                .userInfoEndpoint(userInfo -> userInfo.userService(customerOauth2UserService))
                                .successHandler(oauth2LoginSuccessHandler)
                                .failureHandler((req, res, exc) -> res.sendRedirect("/oauth2/failure"))
                );

        return http.build();
    }


    @Bean
    public JwtDecoder jwtDecoder() {
        SecretKey key = JwtUtil.getSecretKey();
        return NimbusJwtDecoder
                .withSecretKey(key)
                .macAlgorithm(MacAlgorithm.HS256)
                .build();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins(redirectUrl)
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowCredentials(true);
            }
        };
    }

}
