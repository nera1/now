package com.nera.moment.service;

import com.nera.moment.member.Member;

public interface MemberService {
    void join(Member member);

    Member findMember(Long memberId);
}
