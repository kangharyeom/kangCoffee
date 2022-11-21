package SelfProject.kangCoffee.coffee.service;

import SelfProject.kangCoffee.coffee.entity.Coffee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeService {
    public Coffee createCoffee(Coffee coffee){
        Coffee createCoffee = coffee;
        return createCoffee;
    }
    public  Coffee updateCoffee(Coffee coffee){
        Coffee updateCoffee = coffee;
        return updateCoffee;
    }
    public  Coffee findCoffee(long coffeeId){
        Coffee coffee =
                new Coffee(coffeeId, "아메리카노", "Americano", 1000);
        return coffee;
    }

    //멤버 다수를 조회해야하므로 List로 가져옴
    public List<Coffee> findCoffees(){
        List<Coffee> coffees = List.of(
                new Coffee(1L, "아메리카노", "Americano", 1000),
                new Coffee(2L, "카페라떼", "Cafelatte", 2000)
        );
        return coffees;
    }

    //회원 삭제
    public  void deleteCoffee(long coffeeId){

    }

}

