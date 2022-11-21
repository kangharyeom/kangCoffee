package SelfProject.kangCoffee.order;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    private long memberId;
    private long coffeeId;
}