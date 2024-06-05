//package com.example.projectbe.Configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;

//

//@Configuration
//@EnableWebSecurity

//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .csrf().disable() // Vô hiệu hóa CSRF
//                .authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/**").permitAll() // Cho phép các yêu cầu POST đến bất kỳ URL nào
//                .anyRequest().authenticated(); // Các yêu cầu khác phải xác thực
//        return httpSecurity.build();
//    }
//}
