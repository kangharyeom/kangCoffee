package SelfProject.kangCoffee.member.mapper;

import SelfProject.kangCoffee.member.dto.MemberPatchDto;
import SelfProject.kangCoffee.member.dto.MemberPostDto;
import SelfProject.kangCoffee.member.entity.Member;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDtoToMember(MemberPostDto memberDto);
    Object memberToMemberResponseDto(Member member);
    Member memberPatchDtoToMember(MemberPatchDto memberPatchDto);
    Object membersToMemberResponseDtos(List<Member> members);
}
