package com.nera.moment;

import com.nera.moment.member.Grade;
import com.nera.moment.member.Member;
import com.nera.moment.service.MemberService;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberservice();
        Member member = new Member(1L, "nera", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println(member.getName());
        System.out.println(findMember.getName());
    }
}
