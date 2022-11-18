package SelfProject.kangCoffee.member.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberResponseDTO {
    private long memberId;

    private String email;

    private String name;

    private String phone;
}