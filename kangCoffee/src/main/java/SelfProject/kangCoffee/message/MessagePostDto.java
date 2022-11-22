package SelfProject.kangCoffee.message;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class MessagePostDto {
    @NotBlank
    private String message;
}