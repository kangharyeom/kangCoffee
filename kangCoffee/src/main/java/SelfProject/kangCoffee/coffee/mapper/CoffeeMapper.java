package SelfProject.kangCoffee.coffee.mapper;

import SelfProject.kangCoffee.coffee.DTO.CoffeePatchDto;
import SelfProject.kangCoffee.coffee.DTO.CoffeePostDto;
import SelfProject.kangCoffee.coffee.DTO.CoffeeResponseDto;
import SelfProject.kangCoffee.coffee.entity.Coffee;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CoffeeMapper {
    Coffee coffeePostDtoToCoffee(CoffeePostDto coffeePostDto);
    Coffee coffeePatchDtoToCoffee(CoffeePatchDto coffeePatchDto);
    CoffeeResponseDto coffeeToCoffeeResponseDto(Coffee coffee);
    List<CoffeeResponseDto> coffeesToCoffeeResponseDtos(List<Coffee> coffees);
}