package com.nera.moment;

import com.nera.moment.member.Grade;
import com.nera.moment.member.Member;
import com.nera.moment.order.Order;
import com.nera.moment.service.MemberService;
import com.nera.moment.service.OrderService;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberservice();
        OrderService orderService = appConfig.orderService();

        Long memberId = 2L;
        Member member = new Member(memberId, "nera", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);
        System.out.println(order);
        System.out.println(order.calculatePrice());
    }
}
