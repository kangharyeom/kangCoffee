package SelfProject.kangCoffee.member.mapper;

import SelfProject.kangCoffee.member.Dto.MemberPatchDto;
import SelfProject.kangCoffee.member.Dto.MemberPostDto;
import SelfProject.kangCoffee.member.Dto.MemberResponseDto;
import SelfProject.kangCoffee.member.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MemberMapper {
    Member memberPostDtoToMember(MemberPostDto memberPostDto);
    Member memberPatchDtoToMember(MemberPatchDto memberPatchDto);
    MemberResponseDto memberToMemberResponseDto(Member member);
    List<MemberResponseDto> membersToMemberResponseDtos(List<Member> members);
}
