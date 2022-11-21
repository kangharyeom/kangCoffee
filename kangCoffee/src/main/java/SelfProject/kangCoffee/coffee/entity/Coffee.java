package SelfProject.kangCoffee.coffee.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coffee {
    private long coffeeId;
    private String korName;
    private String engName;
    private long price;

}
