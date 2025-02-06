package com.nera.now.sinlgeton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nera.now.AppConfig;
import com.nera.now.repository.MemberRepository;

public class StatefulServiceTest {
    @Test
    void StatefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        int price1 = statefulService1.order("nera", 1000);
        int price2 = statefulService2.order("aren", 2000);

        System.out.println(price1);
        System.out.println(price2);
    }

    @Test
    void ConfigAnnotationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService service1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService service2 = ac.getBean("statefulService", StatefulService.class);

        System.out.println(service1);
        System.out.println(service2);

        Assertions.assertThat(service1).isSameAs(service2);
    }

    static class TestConfig {
        @Bean
        StatefulService statefulService() {
            return new StatefulService();
        }
    }
}
