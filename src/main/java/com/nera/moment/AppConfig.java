package com.nera.moment;

import com.nera.moment.discount.FixDiscountPolicy;
import com.nera.moment.repository.MemoryMemberRepository;
import com.nera.moment.service.MemberService;
import com.nera.moment.service.MemberServiceImpl;
import com.nera.moment.service.OrderService;
import com.nera.moment.service.OrderServiceImpl;

public class AppConfig {
    public MemberService memberservice() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
