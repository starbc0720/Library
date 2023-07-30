package com.group.libraryapp.config;

import org.springframework.context.annotation.Configuration;

@Configuration //@Configuration + @Bean -> 외부 라이브러리, 프레임워크에서 만든 클래스 등록 시 사용
public class UserConfiguration {

//    @Bean
//    public UserJdbcRepository userRepository(JdbcTemplate jdbcTemplate){
//        return new UserJdbcRepository(jdbcTemplate);
//    }
}
