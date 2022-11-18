package SelfProject.kangCoffee.coffee.controller;

import SelfProject.kangCoffee.coffee.DTO.CoffeePatchDTO;
import SelfProject.kangCoffee.coffee.DTO.CoffeePostDTO;
import SelfProject.kangCoffee.member.mapper.MemberMapper;
import SelfProject.kangCoffee.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/v1/coffees")
@Validated
public class CoffeeController {

    @PostMapping
    public ResponseEntity postCoffee(@Valid @RequestBody CoffeePostDTO coffeePostDTO){
        return new ResponseEntity<>(coffeePostDTO, HttpStatus.CREATED);
    }
    @PatchMapping("/{coffee-id}")
    public ResponseEntity patchCoffee( @PathVariable("coffee-id") @Min(1) long coffeeId,
                                       @Valid @RequestBody CoffeePatchDTO coffeePatchDTO){
        coffeePatchDTO.setCoffeeId(coffeeId);
        return new ResponseEntity<>(coffeePatchDTO, HttpStatus.OK);
    }
    @GetMapping("/{coffee-id}")
    public ResponseEntity getCoffee(@PathVariable("coffee-id") long coffeeId){
        System.out.println("# coffeeId: "+ coffeeId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getCoffees(){
        System.out.println("# get coffees");

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{coffee-id}")
    public ResponseEntity deleteCoffee(@PathVariable("/{coffee-id}") long coffeeId){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
