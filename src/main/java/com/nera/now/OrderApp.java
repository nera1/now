package com.nera.now;

import com.nera.now.member.Grade;
import com.nera.now.member.Member;
import com.nera.now.order.Order;
import com.nera.now.service.MemberService;
import com.nera.now.service.OrderService;

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
