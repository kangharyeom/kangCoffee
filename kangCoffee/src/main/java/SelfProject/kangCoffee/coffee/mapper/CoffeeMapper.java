package SelfProject.kangCoffee.coffee.mapper;

import SelfProject.kangCoffee.coffee.dto.CoffeePatchDto;
import SelfProject.kangCoffee.coffee.dto.CoffeePostDto;
import SelfProject.kangCoffee.coffee.dto.CoffeeResponseDto;
import SelfProject.kangCoffee.coffee.entity.Coffee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper(componentModel = "spring")
public interface CoffeeMapper {
    @Mapping(source = "price", target = "price.value")
    Coffee coffeePostDtoToCoffee(CoffeePostDto coffeePostDto);

    @Mapping(source = "price", target = "price.value")
    Coffee coffeePatchDtoToCoffee(CoffeePatchDto coffeePatchDto);

    @Mapping(source = "price.value", target = "price")
    CoffeeResponseDto coffeeToCoffeeResponseDto(Coffee coffee);

    List<CoffeeResponseDto> coffeesToCoffeeResponseDtos(List<Coffee> coffees);
}
