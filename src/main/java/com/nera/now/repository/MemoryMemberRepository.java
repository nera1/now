package com.nera.now.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.nera.now.member.Member;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new ConcurrentHashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }

}
