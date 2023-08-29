package com.example._sampleproject_coffee.member.service;


import com.example._sampleproject_coffee.exception.BusinessLogicException;
import com.example._sampleproject_coffee.exception.ExceptionCode;
import com.example._sampleproject_coffee.member.entity.Member;
import com.example._sampleproject_coffee.member.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class MemberService {

        private final MemberRepository memberRepository;

        public MemberService(MemberRepository memberRepository) {
            this.memberRepository = memberRepository;
        }

        public Member createMember(Member member) {
            verifyExistsEmail(member.getEmail());
            return memberRepository.save(member);
        }


        public Member updateMember(Member member) {
            Member findMember = findVerifiedMember(member.getMemberId());

            Optional.ofNullable(member.getName()).ifPresent(name -> findMember.setName(name));
            Optional.ofNullable(member.getPhone()).ifPresent(phone -> findMember.setPhone(phone));

            Optional.ofNullable(member.getMemberStatus()).ifPresent(memberStatus -> findMember.setMemberStatus(memberStatus));

            findMember.setModifiedAt(LocalDateTime.now());
            return memberRepository.save(findMember);
        }

        public Member findMember(long memberId) {
//        Member member = new Member(memberId, "hg@mail.com", "홍길동", "010-1111-1111");
//        return member;

//        throw new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND);
            return findVerifiedMember(memberId);
        }


        public Page<Member> findMembers(int page, int size) {
            // should business logic

            // member 객체는 나중에 DB에서 조회하는 것으로 변경 필요.
//        List<Member> members = List.of(
//                new Member(1, "hgd@gmail.com", "홍길동", "010-1234-5678"),
//                new Member(2, "lml@gmail.com", "이몽룡", "010-1111-2222")
//        );


            return memberRepository.findAll(PageRequest.of(page, size, Sort.by("memberId").descending()));

        }

        public void deleteMember(long memberId) {
            Member findMember = findVerifiedMember(memberId);
            memberRepository.delete(findMember);
        }


        public Member findVerifiedMember(long memberId) {
            Optional<Member> optionalMember =
                    memberRepository.findById(memberId);
            Member findMember =
                    optionalMember.orElseThrow(() ->
                            new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
            return findMember;
        }

        private void verifyExistsEmail(String email) {
            Optional<Member> member = memberRepository.findByEmail(email);
            if (member.isPresent())
                throw new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND);
        }
    }

