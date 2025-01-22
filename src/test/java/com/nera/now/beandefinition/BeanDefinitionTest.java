package com.nera.now.beandefinition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nera.now.AppConfig;

public class BeanDefinitionTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 설정 메타정보 확인")
    void findApplicationBean() {
        String[] beanDefintionNames = ac.getBeanDefinitionNames();
        for (String beanDefintionName : beanDefintionNames) {
            BeanDefinition bd = ac.getBeanDefinition(beanDefintionName);
            if (bd.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinitionName = " + beanDefintionName + " beanDefinition = " + bd);
            }
        }
    }
}
