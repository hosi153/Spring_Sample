package com.example._sampleproject_coffee.mapper;


import com.example._sampleproject_coffee.member.Member;
import com.example._sampleproject_coffee.member.DTO.MemberPatchDto;
import com.example._sampleproject_coffee.member.DTO.MemberPostDto;
import com.example._sampleproject_coffee.member.DTO.MemberResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDtoToMember(MemberPostDto memberPostDto);
    Member memberPatchDtoToMember(MemberPatchDto memberPatchDto);
    MemberResponseDto memberToMemberResponseDto (Member member);

}
