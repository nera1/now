package com.nera.now.singleton;

import java.lang.reflect.Member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nera.now.AppConfig;
import com.nera.now.service.MemberService;

public class SingletonTest {
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        Assertions.assertThat(memberService).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("Singleton Test")
    void singletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();
        Assertions.assertThat(singletonService1).isSameAs(singletonService2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        Assertions.assertThat(memberService).isSameAs(memberService2);
    }
}
