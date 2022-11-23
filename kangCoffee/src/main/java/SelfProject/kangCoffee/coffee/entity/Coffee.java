package SelfProject.kangCoffee.coffee.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Coffee {
    @Id
    private long coffeeId;

    private String korName;
    private String engName;
    private int price;
    //    private Money price;
    private String coffeeCode;
}
