package com.nera.now;

import com.nera.now.member.Grade;
import com.nera.now.member.Member;
import com.nera.now.service.MemberService;

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
