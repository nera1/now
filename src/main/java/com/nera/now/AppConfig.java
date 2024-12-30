package com.nera.now;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nera.now.discount.DiscountPolicy;
import com.nera.now.discount.RateDiscountPolicy;
import com.nera.now.repository.MemberRepository;
import com.nera.now.repository.MemoryMemberRepository;
import com.nera.now.service.MemberService;
import com.nera.now.service.MemberServiceImpl;
import com.nera.now.service.OrderService;
import com.nera.now.service.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
