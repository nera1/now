package com.nera.moment;

import com.nera.moment.discount.DiscountPolicy;
import com.nera.moment.discount.RateDiscountPolicy;
import com.nera.moment.repository.MemberRepository;
import com.nera.moment.repository.MemoryMemberRepository;
import com.nera.moment.service.MemberService;
import com.nera.moment.service.MemberServiceImpl;
import com.nera.moment.service.OrderService;
import com.nera.moment.service.OrderServiceImpl;

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
