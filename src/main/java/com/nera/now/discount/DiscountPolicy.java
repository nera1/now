package com.nera.now.discount;

import com.nera.now.member.Member;

public interface DiscountPolicy {
    public int discount(Member member, int price);
}
