package SelfProject.kangCoffee.coffee.mapper;

import SelfProject.kangCoffee.coffee.DTO.CoffeePatchDto;
import SelfProject.kangCoffee.coffee.DTO.CoffeePostDto;
import SelfProject.kangCoffee.coffee.DTO.CoffeeResponseDto;
import SelfProject.kangCoffee.coffee.entity.Coffee;
import org.springframework.stereotype.Component;

@Component
public class CoffeeMapper {
    public Coffee coffeePostDtoToCoffee(CoffeePostDto coffeePostDto) {
        return new Coffee(0L,
                coffeePostDto.getKorName(),
                coffeePostDto.getEngName(),
                coffeePostDto.getPrice());
    }

    public Coffee coffeePatchDtoToCoffee(CoffeePatchDto coffeePatchDto) {
        return new Coffee(coffeePatchDto.getCoffeeId(),
                coffeePatchDto.getKorName(),
                coffeePatchDto.getEngName(),
                coffeePatchDto.getPrice());
    }

    public CoffeeResponseDto coffeeToCoffeeResponseDto(Coffee coffee) {
        return new CoffeeResponseDto(coffee.getCoffeeId(),
                coffee.getKorName(),
                coffee.getEngName(),
                coffee.getPrice());
    }
}