package com.nera.now.service;

import com.nera.now.member.Member;

public interface MemberService {
    void join(Member member);

    Member findMember(Long memberId);
}
