package SelfProject.kangCoffee.member.mapper;

import SelfProject.kangCoffee.member.DTO.MemberPatchDTO;
import SelfProject.kangCoffee.member.DTO.MemberPostDTO;
import SelfProject.kangCoffee.member.entity.Member;
import SelfProject.kangCoffee.member.response.MemberResponseDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

//@Component
// componentModel = "spring"을 지정해주면 Spring의 Bean으로 등록이 된다
@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDTOToMember(MemberPostDTO memberPostDTO);
    Member memberPatchDTOToMember(MemberPatchDTO memberPatchDTO);
    MemberResponseDTO memberToMemberResponseDTO(Member member);

    // 로MemberPostDto를 Member 변환
  /*  public Member memberPostDTOToMember(MemberPostDTO memberPostDTO){
        return new Member(0L,
                memberPostDTO.getEmail(),
                memberPostDTO.getName(),
                memberPostDTO.getPhone());
    }
//    MemberPatchDto를 Member로 변환
    public Member memberPatchDTOToMember(MemberPatchDTO memberPatchDTO){
        return new Member(memberPatchDTO.getMemberId(),
                null,
                memberPatchDTO.getName(),
                memberPatchDTO.getPhone());
    }
//    Member를 MemberResponseDto로 변환
    public MemberResponseDTO memberToMemberResponseDTO(Member member){
        return new MemberResponseDTO(member.getMemberId(),
                member.getEmail(),
                member.getName(),
                member.getPhone());

    }*/
}
