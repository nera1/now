package com.nera.now.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class StatefulServiceTest {
    @Test
    void ConfigAnnotationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        TestConfig bean = ac.getBean(TestConfig.class);
        System.out.println(bean);
    }

    @Configuration
    static class TestConfig {
        @Bean
        StatefulService statefulService() {
            return new StatefulService();
        }
    }
}
