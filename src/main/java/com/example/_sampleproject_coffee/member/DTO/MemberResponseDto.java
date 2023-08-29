package com.example._sampleproject_coffee.member.DTO;

import com.example._sampleproject_coffee.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;


import javax.validation.constraints.Pattern;


@Getter
@AllArgsConstructor
public class MemberResponseDto {


    private long memberId;
    private String email;
    @Pattern(regexp = "^\\S+(\\s?\\S+)*$",message = "회원 이름은 공백이 아니어야 합니다.")
    private String name;

    @Pattern(regexp = "^010-\\d{3,4}-\\d{4}$",
            message = "휴대폰 번호는 010으로 시작하는 11자리 숫자와 '-'로 구성되어야 합니다.")
    private String phone;
    private Member.MemberStatus memberStatus;

    public String getMemberStatus(){
        return memberStatus.getStatus();
    }


}
