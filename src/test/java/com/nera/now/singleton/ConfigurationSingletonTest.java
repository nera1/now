package com.nera.now.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nera.now.AppConfig;
import com.nera.now.repository.MemberRepository;
import com.nera.now.service.MemberServiceImpl;
import com.nera.now.service.OrderServiceImpl;

public class ConfigurationSingletonTest {
    @Test
    void memberRepositoryTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl ms = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl os = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository m1 = ms.getMemberRepository();
        MemberRepository m2 = os.getMemberRepository();
        Assertions.assertThat(m1).isSameAs(m2);
    }
}
