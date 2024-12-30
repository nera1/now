package com.nera.now.repository;

import com.nera.now.member.Member;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);
}
