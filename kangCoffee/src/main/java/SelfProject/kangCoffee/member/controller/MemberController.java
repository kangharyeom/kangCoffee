package SelfProject.kangCoffee.member.controller;


import SelfProject.kangCoffee.member.DTO.MemberPatchDTO;
import SelfProject.kangCoffee.member.DTO.MemberPostDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/v1/members")
@Validated
public class MemberController {

    //회원 정보 등록
    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberPostDTO memberPostDTO) {
        return new ResponseEntity<>(memberPostDTO, HttpStatus.CREATED);
    }

    // 회원 정보 수정
    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") @Min(1) long memberId,
                                      @Valid @RequestBody MemberPatchDTO memberPatchDTO){
        memberPatchDTO.setMemberId(memberId);
        memberPatchDTO.setName("홍길동");  // patch는 값을 변경해주는 것이기 때문
        return new ResponseEntity<>(memberPatchDTO, HttpStatus.OK);
    }

    // 회원 조회
    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") long memberId){
        System.out.println("# memberId: "+memberId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    //다수 회원 조회
    @GetMapping
    public ResponseEntity getMembers(){
        System.out.println("# get members");

        return new ResponseEntity<>(HttpStatus.OK);
    }

    //회원 정보 삭제
    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("/{member-id}") long memberId){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}