//package com.example._sampleproject_coffee.member.controller.v4;
//
//import com.example._sampleproject_coffee.member.DTO.MemberPatchDto;
//import com.example._sampleproject_coffee.member.DTO.MemberPostDto;
//import com.example._sampleproject_coffee.member.DTO.MemberResponseDto;
//import com.example._sampleproject_coffee.member.entity.Member;
//import com.example._sampleproject_coffee.member.service.MemberService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.FieldError;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.*;
//import com.example._sampleproject_coffee.member.mapper.MemberMapper;
//
//import javax.validation.Valid;
//import javax.validation.constraints.Min;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping(path = "/v4/members")
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
//    public ResponseEntity postMember(@Valid @RequestBody MemberPostDto memberPostDto){
////        Member member = new Member();
////        member.setEmail(memberPostDto.getEmail());
////        member.setName(member.getName());
////        member.setPhone(member.getPhone());
//
//        // (2) 매퍼를 이용해서 MemberPostDto를 Member로 변환
//        Member response = memberSerivce.createMember(memberMapper.memberPostDtoToMember(memberPostDto));
//        //MemberMapper 클래스를 이용해서 MemberPostDto 를 Member 로 변환
//
//        // (3) 매퍼를 이용해서 Member를 MemberResponseDto로 변환
//        return  new ResponseEntity<>(response, HttpStatus.CREATED);
//    }
//
//
//
//
//    @PatchMapping("/{member-id}")
//    public  ResponseEntity patchMember (@PathVariable("member-id") @Min(1) long memberId,
//                                  @Valid @RequestBody MemberPatchDto memberPatchDto){
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
//    public ResponseEntity handleException(MethodArgumentNotValidException e){
//        final List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
//        return  new ResponseEntity(fieldErrors, HttpStatus.BAD_REQUEST);
//    }
//
//
////    private final Map<String, Map<String, Object>> members = new HashMap<>();
////
////    @PostConstruct
////    public void init() {
////        Map<String, Object> member1 = new HashMap<>();
////        String memberId = "1L";
////        member1.put("memberId", memberId);
////        member1.put("email", "hgd@gmail.com");
////        member1.put("name", "홍길동");
////        member1.put("phone", "010-1234-5678");
////
////        members.put(memberId, member1);
////    }
////
////
////    @PostMapping
////    public ResponseEntity postMember(@RequestParam("memberId") String memberId,
////                                     @RequestParam("email") String email,
////                                     @RequestParam("name") String name,
////                                     @RequestParam("phone") String phoneNumber) {
////        Map<String, Object> map = new HashMap<>();
////        map.put("memberId",memberId);
////        map.put("email", email);
////        map.put("name", name);
////        map.put("phone", phoneNumber);
////        members.put(memberId, map);
////
////        return new ResponseEntity<>(members, HttpStatus.CREATED);
////    }
////
////    @GetMapping("/{member-id}")
////    public ResponseEntity getMember(@PathVariable("member-id") String memberId) {
////        System.out.println("# memberId: " + memberId);
////
////        // not implementation
////        return new ResponseEntity<>(members.get(memberId), HttpStatus.OK);
////    }
////
////    @GetMapping
////    public ResponseEntity getMembers() {
////        System.out.println("# get Members");
////
////        // not implementation
////
////        return new ResponseEntity<>(members, HttpStatus.OK);
////    }
////
////
////    //---------------- 여기서 부터 아래에 코드를 구현하세요! -------------------//
////    // 1. 회원 정보 수정을 위한 핸들러 메서드 구현
////
////    @PatchMapping("/{member-id}")
////    public ResponseEntity parhMember(
////            @PathVariable("member-id") String memberId,
////            @RequestParam String phone
////    ) {
////
////        Map<String, Object> member = members.get(memberId);
////
////        if (member == null) {
////            return new ResponseEntity(HttpStatus.NOT_FOUND);
////        } else {
////            member.put("phone", phone);
////        }
////        return new ResponseEntity(member, HttpStatus.OK);
////
////    }
////
////
////    // 2. 회원 정보 삭제를 위한 핸들러 메서드 구현
////    @DeleteMapping("/{member-id}")
////    public ResponseEntity deleteMember(@PathVariable("member-id") String memberId) {
////        if (members.containsKey(memberId)) {
////            members.remove(memberId);
////        } else {
////            return new ResponseEntity(HttpStatus.NOT_FOUND);
////        }
////        return new ResponseEntity(HttpStatus.NO_CONTENT);
////    }
//
//
//}