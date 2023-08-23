package com.example._sampleproject_coffee.mapper;

import com.example._sampleproject_coffee.member.Member;
import com.example._sampleproject_coffee.member.DTO.MemberPatchDto;
import com.example._sampleproject_coffee.member.DTO.MemberPostDto;
import com.example._sampleproject_coffee.member.DTO.MemberResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MemberMapperImpl implements MemberMapper {

    public Member memberPostDtoToMember(MemberPostDto memberPostDto) {
        return new Member(0L,
                memberPostDto.getEmail(), memberPostDto.getName(), memberPostDto.getPhone());
    }

    public Member memberPatchDtoToMember(MemberPatchDto memberPatchDto) {
        return new Member(memberPatchDto.getMemberId(), null, memberPatchDto.getName(), memberPatchDto.getPhone());
    }

    public MemberResponseDto memberToMemberResponseDto(Member member) {
        if (member == null) {
            return null;
        } else {
            long memberId = 0L;
            String email = null;
            String name = null;
            String phone = null;

            memberId = member.getMemberId();
            name = member.getName();
            phone = member.getPhone();
            MemberResponseDto memberResponseDto = new MemberResponseDto(memberId,email,name,phone);
            return memberResponseDto;
        }
    }
}