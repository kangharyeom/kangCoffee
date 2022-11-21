package SelfProject.kangCoffee.coffee.DTO;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CoffeeResponseDto {
    private long coffeeId;
    private String korName;
    private String engName;
    private long price;
}
