package SelfProject.kangCoffee.member.service;

import SelfProject.kangCoffee.exception.BusinessLogicException;
import SelfProject.kangCoffee.exception.ExceptionCode;
import SelfProject.kangCoffee.member.MemberRepository;
import SelfProject.kangCoffee.member.entity.Member;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//전체적으로 MemberController 메서드와 1대1로 매치가 됨
public class MemberService {
    private MemberRepository memberRepository;

    // (1) MemberRepository DI
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    public Member createMember(Member member){
        // (2) 이미 등록된 이메일인지 검증
        verifyExistsEmail(member.getEmail());
        // (3) 회원 정보 저장
        return memberRepository.save(member);
    }
    public  Member updateMember(Member member){
        // (4) 존재하는 회원인지 검증
        Member findMember = findVerifiedMember(member.getMemberId());

        // (5) 이름 정보와 휴대폰 번호 정보 업데이트
        Optional.ofNullable(member.getName())
                .ifPresent(name -> findMember.setName(name));
        Optional.ofNullable(member.getPhone())
                .ifPresent(phone -> findMember.setPhone(phone));
        // (6) 회원 정보 업데이트
        return memberRepository.save(findMember);
    }
    public  Member findMember(long memberId){
        return findVerifiedMember(memberId);

//        throw new RuntimeException("Not found member");
//        throw new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND);
    }

    //멤버 다수를 조회해야하므로 List로 가져옴
    public List<Member> findMembers(){
        return (List<Member>) memberRepository.findAll();
    }

    //회원 삭제
    public  void deleteMember(long memberId){
        Member findMember = findVerifiedMember(memberId);
        memberRepository.delete(findMember);
    }

    // (10) 이미 존재하는 회원인지를 검증
    public Member findVerifiedMember(long memberId) {
        Optional<Member> optionalMember =
                memberRepository.findById(memberId);
        Member findMember =
                optionalMember.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        return findMember;
    }

    // (11) 이미 등록된 이메일 주소인지 검증
    private void verifyExistsEmail(String email) {
        Optional<Member> member = memberRepository.findByEmail(email);
        if (member.isPresent())
            throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
    }

}
