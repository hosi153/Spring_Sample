package com.example._sampleproject_coffee.member.service;


import com.example._sampleproject_coffee.member.entity.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberSerivce {


    public Member createMember(Member member) {
        Member cteatedMember = member;
        return cteatedMember;

    }


    public Member updateMember(Member member) {
        Member updatedMember = member;
        return updatedMember;
    }

    public Member findMember(long memberId) {
        Member member = new Member(memberId, "hg@mail.com", "홍길동", "010-1111-1111");
        return member;
    }

    public List<Member> findMembers() {
        List<Member> members = List.of(
                new Member(1, "hg@mail.com", "홍길동", "010-1111-1111"),
                new Member(2, "lasd.mail.com", "이몽룡", "010-2222-2222")
        );
        return members;
    }

    public void deleteMember(long memberId) {

    }
}
