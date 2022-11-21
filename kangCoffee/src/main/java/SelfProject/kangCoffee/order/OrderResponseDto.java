package SelfProject.kangCoffee.order;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponseDto {
    private long memberId;
    private long coffeeId;
}