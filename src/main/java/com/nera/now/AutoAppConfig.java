package com.nera.now;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class), basePackages = "com.nera.now")
public class AutoAppConfig {
    /*
     * 
     * basePackages = 스캔 시작 루트, 해당 위치부터 하위 파일을 모두 컴포넌트 스캔한다
     * 
     * @SpringBootApplication 를 프로젝트 시작위치에 두면 하위 파일을 스캔하도록 @ComponentScan에 디폴트로 되어있다
     * 
     * @Component, @Controller, @Service, @Repository 등을 모두 자동으로 스캔한다
     * 
     * Annotaion에는 상속관계라는 것이 없다, Annotation 이 다른 Annotation을 포함하고 있는 것을 인식할 수 있는것도
     * 자바 언어가 지원하는 기능이 아니라 스프링이 지원하는 기능이다
     * 
     * @Controller : 스프링 MVC 컨트롤러로 인식
     * 
     * @Rpository : 스프링 데이터 접근 계층으로 인식하고, 데이터 계층의 예외를 스프링 예외로 변환해준다
     * 
     * @Configuration : 스프링 설정 정보로 인식하고, 스프링 빈이 싱글톤을 유지하도록 추가 처리를 한다
     * 
     * @Service : 특별한 처리를 하지 않는다 다만 개발자들이 핵심 비즈니스 로직임을 인식하게 도움이 되는 것이다
     */
}
