package SelfProject.kangCoffee.member.service;

import SelfProject.kangCoffee.exception.BusinessLogicException;
import SelfProject.kangCoffee.exception.ExceptionCode;
import SelfProject.kangCoffee.member.entity.Member;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
//전체적으로 MemberController 메서드와 1대1로 매치가 됨
public class MemberService {
    public Member createMember(Member member){
        Member createMember = member;
        return createMember;
    }
    public  Member updateMember(Member member){
        Member updateMember = member;
        return updateMember;
    }
    public  Member findMember(long memberId){
        Member member =
                new Member(memberId, "ghd@gmail.com", "홍길동", "010-1234-5678");
        return member;
//        throw new RuntimeException("Not found member");
//        throw new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND);
    }

    //멤버 다수를 조회해야하므로 List로 가져옴
    public List<Member> findMembers(){
        List<Member> members = List.of(
            new Member(1, "ghd@gmail.com", "홍길동", "010-1234-5678"),
            new Member(2, "lml@gmail.com", "이몽룡", "010-1111-2222")
        );
        return members;
    }

    //회원 삭제
    public  void deleteMember(long memberId){

    }
}
