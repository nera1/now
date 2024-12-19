package com.nera.moment.discount;

import com.nera.moment.member.Member;

public interface DiscountPolicy {
    public int discount(Member member, int price);
}
