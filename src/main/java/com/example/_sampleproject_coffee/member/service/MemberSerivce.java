package com.example._sampleproject_coffee.member.service;


import com.example._sampleproject_coffee.exception.BusinessLogicException;
import com.example._sampleproject_coffee.exception.ExceptionCode;
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
//        Member member = new Member(memberId, "hg@mail.com", "홍길동", "010-1111-1111");
//        return member;

        throw new BusinessLogicException(ExceptionCode.MEMBER_NOTFOUND);
    }

    public List<Member> findMembers() {
        // should business logic

        // member 객체는 나중에 DB에서 조회하는 것으로 변경 필요.
        List<Member> members = List.of(
                new Member(1, "hgd@gmail.com", "홍길동", "010-1234-5678"),
                new Member(2, "lml@gmail.com", "이몽룡", "010-1111-2222")
        );
        return members;
    }

    public void deleteMember(long memberId) {

    }
}
