package SelfProject.kangCoffee.member.mapper;

import SelfProject.kangCoffee.member.Dto.MemberPatchDto;
import SelfProject.kangCoffee.member.Dto.MemberPostDto;
import SelfProject.kangCoffee.member.Dto.MemberResponseDto;
import SelfProject.kangCoffee.member.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {
    public Member memberPostDtoToMember(MemberPostDto memberPostDto) {
        return new Member(0L,
                memberPostDto.getEmail(),
                memberPostDto.getName(),
                memberPostDto.getPhone());
    }

    public Member memberPatchDtoToMember(MemberPatchDto memberPatchDto) {
        return new Member(memberPatchDto.getMemberId(),
                null,
                memberPatchDto.getName(),
                memberPatchDto.getPhone());
    }

    public MemberResponseDto memberToMemberResponseDto(Member member) {
        return new MemberResponseDto(member.getMemberId(),
                member.getEmail(),
                member.getName(),
                member.getPhone());
    }
}
