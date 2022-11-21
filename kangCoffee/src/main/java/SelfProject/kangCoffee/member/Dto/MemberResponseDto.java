package SelfProject.kangCoffee.member.Dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponseDto {
    private long memberId;

    private String email;

    private String name;

    private String phone;


}
