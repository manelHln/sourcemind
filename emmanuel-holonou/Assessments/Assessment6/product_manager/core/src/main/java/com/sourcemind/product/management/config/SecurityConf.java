package com.sourcemind.product.management.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
public class SecurityConf {
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((authorize) -> authorize
//                        .requestMatchers(HttpMethod.GET, "/products").hasRole("PRODUCT_OWNER")
//                        .requestMatchers(HttpMethod.DELETE, "/products").hasRole("PRODUCT_OWNER")
//                        .requestMatchers(HttpMethod.POST, "/products").hasRole("PRODUCT_OWNER")
//                        .anyRequest()
//                        .authenticated()
//                )
//                .httpBasic(withDefaults());
//        return http.build();
    }
}
