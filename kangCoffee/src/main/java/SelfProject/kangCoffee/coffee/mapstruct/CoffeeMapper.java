package SelfProject.kangCoffee.coffee.mapstruct;

import SelfProject.kangCoffee.coffee.DTO.CoffeePatchDto;
import SelfProject.kangCoffee.coffee.DTO.CoffeePostDto;
import SelfProject.kangCoffee.coffee.DTO.CoffeeResponseDto;
import SelfProject.kangCoffee.coffee.entity.Coffee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoffeeMapper {
    Coffee coffeePostDtoToCoffee(CoffeePostDto coffeePostDto);
    Coffee coffeePatchDtoToCoffee(CoffeePatchDto coffeePatchDto);
    CoffeeResponseDto coffeeToCoffeeResponseDto(Coffee coffee);

}
