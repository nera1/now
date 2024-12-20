package com.nera.moment.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.nera.moment.member.Grade;
import com.nera.moment.member.Member;
import com.nera.moment.service.MemberService;
import com.nera.moment.service.MemberServiceImpl;
import com.nera.moment.service.OrderService;
import com.nera.moment.service.OrderServiceImpl;

public class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        long memberId = 1L;
        Member member = new Member(memberId, "nera", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
