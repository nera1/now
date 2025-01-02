package com.nera.now.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nera.now.AppConfig;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("All bean print")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefitionName);
            System.out.println("name = " + beanDefitionName + " object = " + bean);
        }
    }

    @Test
    @DisplayName("All application bean print")
    void findAllApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefitionName);
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                // 사용자가 어플리케이션에서 등록한 빈 또는 라이브러리에서 사용한 빈만 출력
                continue;
                // Object bean = ac.getBean(beanDefitionName);
                // System.out.println("name = " + beanDefitionName + " object = " + bean);
            } else if (beanDefinition.getRole() == BeanDefinition.ROLE_INFRASTRUCTURE) {
                // 스프링이 내부에서 사용하는 빈
                Object bean = ac.getBean(beanDefitionName);
                System.out.println("name = " + beanDefitionName + " object = " + bean);
            }
        }
    }
}
