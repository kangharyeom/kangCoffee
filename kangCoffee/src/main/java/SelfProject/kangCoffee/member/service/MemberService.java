package SelfProject.kangCoffee.member.service;

import SelfProject.kangCoffee.member.entity.Member;

import java.util.List;

//전체적으로 MemberController 메서드와 1대1로 매치가 됨
public class MemberService {
    public Member createMember(Member member){
        return null;
    }
    public  Member updateMember(Member member){
        return null;
    }
    public  Member findMember(long memberId){
        return null;
    }
    //멤버 다수를 조회해야하므로 List로 가져옴
    public List<Member> findMembers(){
        return null;
    }

    //회원 삭제
    public  void deleteMember(long memberId){

    }
}
