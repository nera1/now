package com.nera.moment.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.nera.moment.service.MemberService;
import com.nera.moment.service.MemberServiceImpl;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        // given
        Member member = new Member(1L, "nera", Grade.VIP);

        // when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
