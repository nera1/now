package com.nera.moment;

import com.nera.moment.member.Grade;
import com.nera.moment.member.Member;
import com.nera.moment.service.MemberService;
import com.nera.moment.service.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "엄인용", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println(member.getName());
        System.out.println(findMember.getName());
    }
}
