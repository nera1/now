package com.nera.moment.service;

import com.nera.moment.discount.DiscountPolicy;
import com.nera.moment.member.Member;
import com.nera.moment.order.Order;
import com.nera.moment.repository.MemberRepository;
import com.nera.moment.repository.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

}
