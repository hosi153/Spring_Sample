package com.example._sampleproject_coffee.member.controller.v7;

import com.example._sampleproject_coffee.member.DTO.MemberPatchDto;
import com.example._sampleproject_coffee.member.DTO.MemberPostDto;
import com.example._sampleproject_coffee.member.DTO.MemberResponseDto;
import com.example._sampleproject_coffee.member.entity.Member;
import com.example._sampleproject_coffee.member.service.MemberService;
import com.example._sampleproject_coffee.response.MultiResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example._sampleproject_coffee.member.mapper.MemberMapper;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/v8/members")
@Validated

public class MemberController {
    private final MemberService memberService;
    private final MemberMapper memberMapper;

    // (1) MemberMapper DI
    public MemberController(MemberService memberService, MemberMapper memberMapper){
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }
    //Spring Bean에 등록된 MemberMapper 객체를 MemberController에서 사용하기 위해 DI 주입

    //회원 정보 등록
    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberPostDto memberPostDto){
//        Member member = new Member();
//        member.setEmail(memberPostDto.getEmail());
//        member.setName(member.getName());
//        member.setPhone(member.getPhone());

        // (2) 매퍼를 이용해서 MemberPostDto를 Member로 변환
        Member response = memberService.createMember(memberMapper.memberPostDtoToMember(memberPostDto));
        //MemberMapper 클래스를 이용해서 MemberPostDto 를 Member 로 변환

        // (3) 매퍼를 이용해서 Member를 MemberResponseDto로 변환
        return  new ResponseEntity<>(response, HttpStatus.CREATED);
    }




    @PatchMapping("/{member-id}")
    public  ResponseEntity patchMember (@PathVariable("member-id") @Min(1) long memberId,
                                        @Valid @RequestBody MemberPatchDto memberPatchDto){

//        memberPatchDto.setMemberId(memberId);
//        Member member = new Member();
//        member.setMemberId(memberPatchDto.getMemberId());
//        member.setName(memberPatchDto.getName());
//        member.setPhone(memberPatchDto.getPhone());

        // (4) 매퍼를 이용해서 MemberPatchDto를 Member로 변환
        Member response = memberService.updateMember(memberMapper.memberPatchDtoToMember(memberPatchDto));

        // (5) 매퍼를 이용해서 Member를 MemberResponseDto로 변환
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

    //단건 조회
    @GetMapping("/{member-id}")
    public  ResponseEntity getMember(@PathVariable("member-id")long memberId){
        // (6) 매퍼를 이용해서 Member를 MemberResponseDto로 변환
        return new ResponseEntity<>(memberMapper.memberToMemberResponseDto(memberService.findMember(memberId)), HttpStatus.OK);
    }
    //다건 조회
    @GetMapping
    public ResponseEntity getMembers(@Positive @RequestParam int page,
                                     @Positive @RequestParam int size) {
        Page<Member> pageMembers = memberService.findMembers(page - 1, size);
        List<Member> members = pageMembers.getContent();
        return new ResponseEntity<>(
                new MultiResponseDto<>(memberMapper.membersToMemberResponseDtos(members),
                        pageMembers),
                HttpStatus.OK);
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id")long memberId){

        memberService.deleteMember(memberId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

//
//    @ExceptionHandler
//    public ResponseEntity handleException (MethodArgumentNotValidException e){
//        final  List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
//
//        List<ErrorResponse.FieldError> errors = fieldErrors.stream()
//                .map(error -> new ErrorResponse.FieldError(
//                        error.getField(),
//                        error.getRejectedValue(),
//                        error.getDefaultMessage()
//                )).collect(Collectors.toList());
//
//        return  new ResponseEntity(new ErrorResponse(errors), HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler
//    public ResponseEntity handleException (ConstraintViolationException e){
//        //ConstraintViolationException 클래스는 getBindingResult().getFieldErrors() 로 에러 정보를 얻을 수 없다.
//        return new ResponseEntity(HttpStatus.BAD_REQUEST);
//    }




}