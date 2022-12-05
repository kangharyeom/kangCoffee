package SelfProject.kangCoffee.coffee.repository;

import SelfProject.kangCoffee.coffee.entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
    Optional<Coffee> findByCoffeeCode(String CoffeeCode);

    @Query(value = "SELECT c FROM Coffee c WHERE c.coffeeId = :coffeeId")
    Optional<Coffee> findById(Long aLong);

    Optional<Coffee> findByCoffee(long coffeeId);
}