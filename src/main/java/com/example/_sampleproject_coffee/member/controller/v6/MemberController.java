//package com.example._sampleproject_coffee.member.controller.v6;
//
//import com.example._sampleproject_coffee.member.DTO.MemberPatchDto;
//import com.example._sampleproject_coffee.member.DTO.MemberPostDto;
//import com.example._sampleproject_coffee.member.DTO.MemberResponseDto;
//import com.example._sampleproject_coffee.member.entity.Member;
//import com.example._sampleproject_coffee.member.mapper.MemberMapper;
//import com.example._sampleproject_coffee.member.service.MemberService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.FieldError;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import javax.validation.constraints.Min;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping(path = "/v6/members")
//@Validated
//
//public class MemberController {
//    private final MemberService memberSerivce;
//    private final MemberMapper memberMapper;
//
//    // (1) MemberMapper DI
//    public MemberController(MemberService memberSerivce, MemberMapper memberMapper){
//        this.memberSerivce = memberSerivce;
//        this.memberMapper = memberMapper;
//    }
//    //Spring Bean에 등록된 MemberMapper 객체를 MemberController에서 사용하기 위해 DI 주입
//
//    //회원 정보 등록
//    @PostMapping
//    public ResponseEntity postMember(@Valid @RequestBody MemberPostDto memberDto) {
//        Member member = memberMapper.memberPostDtoToMember(memberDto);
//
//        Member response = memberSerivce.createMember(member);
//
//        return new ResponseEntity<>(memberMapper.memberToMemberResponseDto(response),
//                HttpStatus.CREATED);
//    }
//
//
//
//
//    @PatchMapping("/{member-id}")
//    public  ResponseEntity patchMember (@PathVariable("member-id") @Min(1) long memberId,
//                                        @Valid @RequestBody MemberPatchDto memberPatchDto){
//
////        memberPatchDto.setMemberId(memberId);
////        Member member = new Member();
////        member.setMemberId(memberPatchDto.getMemberId());
////        member.setName(memberPatchDto.getName());
////        member.setPhone(memberPatchDto.getPhone());
//
//        // (4) 매퍼를 이용해서 MemberPatchDto를 Member로 변환
//        Member response = memberSerivce.updateMember(memberMapper.memberPatchDtoToMember(memberPatchDto));
//
//        // (5) 매퍼를 이용해서 Member를 MemberResponseDto로 변환
//        return  new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    //단건 조회
//    @GetMapping("/{member-id}")
//    public  ResponseEntity getMember(@PathVariable("member-id")long memberId){
//        // (6) 매퍼를 이용해서 Member를 MemberResponseDto로 변환
//        return new ResponseEntity<>(memberMapper.memberToMemberResponseDto(memberSerivce.findMember(memberId)), HttpStatus.OK);
//    }
//    //다건 조회
//    @GetMapping
//    public ResponseEntity getMembers(){
//        List<Member> members = memberSerivce.findMembers();
//        // (7) 매퍼를 이용해서 List<Member>를 MemberResponseDto로 변환
//        List<MemberResponseDto> response = members.stream().
//                map(member -> memberMapper.memberToMemberResponseDto(member))
//                .collect(Collectors.toList());
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{member-id}")
//    public ResponseEntity deleteMember(@PathVariable("member-id")long memberId){
//
//        memberSerivce.deleteMember(memberId);
//
//        return new ResponseEntity(HttpStatus.NO_CONTENT);
//    }
//
//
//    @ExceptionHandler
//    public ResponseEntity handleException(MethodArgumentNotValidException e) {
//        final List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
//
//        return new ResponseEntity<>(fieldErrors, HttpStatus.BAD_REQUEST);
//    }
//
//
//
//
//}