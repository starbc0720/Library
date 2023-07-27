package com.group.libraryapp.config;

import com.group.libraryapp.repository.user.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration //@Configuration + @Bean -> 외부 라이브러리, 프레임워크에서 만든 클래스 등록 시 사용
public class UserConfiguration {

//    @Bean
//    public UserRepository userRepository(JdbcTemplate jdbcTemplate){
//        return new UserRepository(jdbcTemplate);
//    }
}
