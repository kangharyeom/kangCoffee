package SelfProject.kangCoffee.coffee;

import SelfProject.kangCoffee.coffee.entity.Coffee;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CoffeeRepository extends CrudRepository<Coffee, Long> {
    // WHERE 절에서 COFFEE_CODE를 조건으로 질의하게 해주는 쿼리 메서드
    Optional<Coffee> findByCoffeeCode(String coffeeCode);

    // @Query 애너테이션은 쿼리 메서드명을 기준으로 SQL 쿼리문을 생성하는 것이 아니라 개발자가 직접 쿼리문을 작성해서 질의를 할 수 있도록 해준다.
    @Query("SELECT * FROM COFFEE WHERE COFFEE_ID = :coffeeId")
    Optional<Coffee> findByCoffee(Long coffeeId);
}
