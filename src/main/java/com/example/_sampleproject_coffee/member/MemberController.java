package com.example._sampleproject_coffee.member;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path="/v1/members")
public class MemberController {
    private final Map<String, Map<String, Object>> members = new HashMap<>();

    @PostConstruct
    public void init() {
        Map<String, Object> member1 = new HashMap<>();
        String memberId = "1L";
        member1.put("memberId", memberId);
        member1.put("email", "hgd@gmail.com");
        member1.put("name", "홍길동");
        member1.put("phone", "010-1234-5678");

        members.put(memberId, member1);
    }



    @PostMapping
    public ResponseEntity postMember(@RequestParam("email") String email,
                                     @RequestParam("name") String name,
                                     @RequestParam("phone") String phoneNumber) {
        Map<String, String> map = new HashMap<>();
        map.put("email", email);
        map.put("name", name);
        map.put("phone", phoneNumber);

        return new ResponseEntity<Map>(map, HttpStatus.CREATED);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") long memberId) {
        System.out.println("# memberId: " + memberId);

        // not implementation
        return new ResponseEntity<Map>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getMembers() {
        System.out.println("# get Members");

        // not implementation

        return new ResponseEntity<Map>(HttpStatus.OK);
    }


    //---------------- 여기서 부터 아래에 코드를 구현하세요! -------------------//
    // 1. 회원 정보 수정을 위한 핸들러 메서드 구현

    @PatchMapping("/{member-id}")
    public ResponseEntity parhMember(
            @PathVariable("member-id") String memberId,
            @RequestParam String phone
    ) {

        Map<String, Object> member = members.get(memberId);

        if (member == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            member.put("phone", phone);
        }
        return new ResponseEntity(member, HttpStatus.OK);

    }


    // 2. 회원 정보 삭제를 위한 핸들러 메서드 구현
    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") String memberId) {
        if (members.containsKey(memberId)) {
            members.remove(memberId);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}