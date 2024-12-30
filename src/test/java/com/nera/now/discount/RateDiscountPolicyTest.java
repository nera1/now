package com.nera.now.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.nera.now.AppConfig;
import com.nera.now.discount.DiscountPolicy;
import com.nera.now.member.Grade;
import com.nera.now.member.Member;

public class RateDiscountPolicyTest {
    private DiscountPolicy discountPolicy;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        discountPolicy = appConfig.discountPolicy();
    }

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")
    void vip_o() {
        Member member = new Member(1L, "nera", Grade.VIP);
        int discount = discountPolicy.discount(member, 10000);
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다")
    void vip_x() {
        Member member = new Member(2L, "nera", Grade.BASIC);
        int discount = discountPolicy.discount(member, 10000);
        Assertions.assertThat(discount).isEqualTo(1000);
    }

}
