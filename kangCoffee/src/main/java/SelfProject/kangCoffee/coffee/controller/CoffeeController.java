package SelfProject.kangCoffee.coffee.controller;

import SelfProject.kangCoffee.coffee.DTO.CoffeePatchDto;
import SelfProject.kangCoffee.coffee.DTO.CoffeePostDto;
import SelfProject.kangCoffee.coffee.DTO.CoffeeResponseDto;
import SelfProject.kangCoffee.coffee.entity.Coffee;
import SelfProject.kangCoffee.coffee.mapstruct.CoffeeMapper;
import SelfProject.kangCoffee.coffee.service.CoffeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/coffees")
@Validated
public class CoffeeController {
    private final CoffeeService coffeeService;
    private final CoffeeMapper mapper;

    public CoffeeController(CoffeeService coffeeService, CoffeeMapper mapper) {
        this.coffeeService = coffeeService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postCoffee(@Valid @RequestBody CoffeePostDto coffeeDto){

        Coffee coffee = mapper.coffeePostDtoToCoffee(coffeeDto);
        Coffee response = coffeeService.createCoffee(coffee);

        return new ResponseEntity<>(mapper.coffeeToCoffeeResponseDto(response), HttpStatus.CREATED);
    }
    @PatchMapping("/{coffee-id}")
    public ResponseEntity patchCoffee( @PathVariable("coffee-id") @Min(1) long coffeeId,
                                       @Valid @RequestBody CoffeePatchDto coffeePatchDto){
        coffeePatchDto.setCoffeeId(coffeeId);

        // CoffeeService 연동
        Coffee response = coffeeService.updateCoffee(mapper.coffeePatchDtoToCoffee(coffeePatchDto));

        // Dto - Entity 변환 Mapping

        return new ResponseEntity<>(mapper.coffeeToCoffeeResponseDto(response), HttpStatus.OK);
    }
    @GetMapping("/{coffee-id}")
    public ResponseEntity getCoffee(@PathVariable("coffee-id") long coffeeId){
        System.out.println("# coffeeId: "+ coffeeId);

       Coffee response = coffeeService.findCoffee(coffeeId);

        return new ResponseEntity<>(mapper.coffeeToCoffeeResponseDto(response), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getCoffees(){
        System.out.println("# get coffees");

        List<Coffee> coffees = coffeeService.findCoffees();

        List<CoffeeResponseDto> response =
                coffees.stream()
                .map(mapper::coffeeToCoffeeResponseDto)
                .collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{coffee-id}")
    public ResponseEntity deleteCoffee(@PathVariable("/{coffee-id}") long coffeeId){

        coffeeService.deleteCoffee(coffeeId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
