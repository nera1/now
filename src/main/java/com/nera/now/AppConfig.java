package com.nera.now;

import com.nera.now.discount.DiscountPolicy;
import com.nera.now.discount.RateDiscountPolicy;
import com.nera.now.repository.MemberRepository;
import com.nera.now.repository.MemoryMemberRepository;
import com.nera.now.service.MemberService;
import com.nera.now.service.MemberServiceImpl;
import com.nera.now.service.OrderService;
import com.nera.now.service.OrderServiceImpl;

public class AppConfig {

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public MemberService memberservice() {
        return new MemberServiceImpl(memberRepository());
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
