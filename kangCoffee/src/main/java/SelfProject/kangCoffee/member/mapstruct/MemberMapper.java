package SelfProject.kangCoffee.member.mapstruct;

import SelfProject.kangCoffee.member.Dto.MemberPatchDto;
import SelfProject.kangCoffee.member.Dto.MemberPostDto;
import SelfProject.kangCoffee.member.Dto.MemberResponseDto;
import SelfProject.kangCoffee.member.entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")  // (1)
public interface MemberMapper {
    Member memberPostDtoToMember(MemberPostDto memberPostDto);
    Member memberPatchDtoToMember(MemberPatchDto memberPatchDto);
    MemberResponseDto memberToMemberResponseDto(Member member);
}