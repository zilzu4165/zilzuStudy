package me.zilzustudy.user;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

    /*
    ConditionalOnProperty
    속성의 존재 여부에 따라 조건부로 빈을 등록 할 수 있음
    name : 테스트할 속성의 이름
    havingValue : 특성에 대한 기대 값의 문자열 표현이다.

    */


    @Bean
    @ConditionalOnProperty(name = "get.user.config", havingValue = "true")
    public UserService getUser() {
        return new UserServiceImpl();
    }

    @Bean
    @ConditionalOnProperty(name = "get.zilzu.config", havingValue = "false")
    public UserService getZilzu() {
        return new ZilzuUserServiceImpl();
    }
}
