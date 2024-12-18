package com.nera.moment.repository;

import com.nera.moment.member.Member;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);
}
