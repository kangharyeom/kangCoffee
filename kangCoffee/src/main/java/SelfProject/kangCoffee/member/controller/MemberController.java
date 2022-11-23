package SelfProject.kangCoffee.member.controller;


import SelfProject.kangCoffee.member.Dto.MemberPatchDto;
import SelfProject.kangCoffee.member.Dto.MemberPostDto;
import SelfProject.kangCoffee.member.Dto.MemberResponseDto;
import SelfProject.kangCoffee.member.entity.Member;
import SelfProject.kangCoffee.member.mapper.MemberMapper;
import SelfProject.kangCoffee.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/members")
@Validated
@Slf4j
public class MemberController {
    private final MemberService memberService;
    private final MemberMapper mapper;
    // MemberMapper DI
    public MemberController(MemberService memberService, MemberMapper mapper){
        this.memberService = memberService;
        this.mapper = mapper;
    }

    //회원 정보 등록
    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberPostDto memberDto) {
        // 매퍼를 이용해서 MemberPost를 Member로 변환
        Member member = mapper.memberPostDtoToMember(memberDto);
        Member response = memberService.createMember(member);

        // 매퍼를 이용해서 Member를 MemberResponseDTO로 변환
        return new ResponseEntity<>(mapper.memberToMemberResponseDto(response), HttpStatus.CREATED);
    }

    // 회원 정보 수정
    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") @Min(1) long memberId,
                                      @Valid @RequestBody MemberPatchDto memberPatchDto){
        memberPatchDto.setMemberId(memberId);

        //매퍼를 이용해서 MemberPatchDTO를 Member로 변환
        Member response = memberService.updateMember(mapper.memberPatchDtoToMember(memberPatchDto));

        // 매퍼를 이용해서 Member를 MemberResponseDTO로 변환
        return new ResponseEntity<>(mapper.memberToMemberResponseDto(response), HttpStatus.OK);
    }

    // 회원 조회
    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") long memberId){

        // MemberService 클래스의 findMember() 메서드를 호출 => 서비스 계층과 연결
        Member response = memberService.findMember(memberId);

        // 매퍼를 이용해서 Member를 MemberResponseDto로 변환
        return new ResponseEntity<>(mapper.memberToMemberResponseDto(response),HttpStatus.OK);
    }

    //다수 회원 조회
    @GetMapping
    public ResponseEntity getMembers(){
//        System.out.println("# get members");

        // MemberService 클래스의 findMembers() 메서드를 호출
        List<Member> members = memberService.findMembers();

        //매퍼를 이용해서 List<Member>를 MemberResponseDTO로 변환
        List<MemberResponseDto> response =
                members.stream()
                .map(mapper::memberToMemberResponseDto)
                .collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //회원 정보 삭제
    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("/{member-id}") long memberId){
        System.out.println("# delete member");

        // MemberService 클래스의 deleteMember() 메서드를 호출
        memberService.deleteMember(memberId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    // ExceptionAdvice를 사용하기 위한 ExceptionHandler 주석처리
    /*@ExceptionHandler
    public ResponseEntity handleException(MethodArgumentNotValidException e){
        // MethodArgumentNotValidException 객체에서 getBindingResult().getFieldErrors()를 통해 발생한 에러 정보를 확인할 수 있다.
        final List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();

        List<ErrorResponse.FieldError> errors =
                fieldErrors.stream()
                        .map(error -> new ErrorResponse.FieldError(
                                error.getField(),
                                error.getRejectedValue(),
                                error.getDefaultMessage()))
                        .collect(Collectors.toList());

        return new ResponseEntity<>(new ErrorResponse(errors), HttpStatus.BAD_REQUEST);
        // ResponseEntity를 통해 Response Body로 전달
//        return new ResponseEntity(fieldErrors, HttpStatus.BAD_REQUEST);
    }*/
}