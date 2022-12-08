package SelfProject.kangCoffee.coffee.service;

import SelfProject.kangCoffee.coffee.entity.Coffee;
import SelfProject.kangCoffee.coffee.repository.CoffeeRepository;
import SelfProject.kangCoffee.exception.BusinessLogicException;
import SelfProject.kangCoffee.exception.ExceptionCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoffeeService {
    private CoffeeRepository coffeeRepository;

    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    public Coffee createCoffee(Coffee coffee){
        // 커피코드를 받아와서 대문자로 변경
        String coffeeCode = coffee.getCoffeeCode().toUpperCase();
        //Di를 받을 때 대소문자 구분해서 코딩하기.

        // 등록된 커피코드인지 확인
        verifyExistCoffee(coffeeCode);
        coffee.setCoffeeCode(coffeeCode);

        // 저장소에 넘김
        return coffeeRepository.save(coffee);
    }


    // 엔티티를 변경하는 역할
    public Coffee updateCoffee(Coffee coffee){
        // 커피를 조회한다. / 조회 하고자하는 커피가 검증된 커피인지 확인
        Coffee findCoffee = findVerifiedCoffee(coffee.getCoffeeId());

        Optional.ofNullable(coffee.getKorName())
                // .ifPresent(); 만약 ()괋호 안을 가지고 있다면 true
                .ifPresent(korName->findCoffee.setKorName(korName)); // 한글 값 변경

        Optional.ofNullable(coffee.getEngName())
                .ifPresent(engName->findCoffee.setEngName(engName)); // 영어 값 변경

        Optional.ofNullable(coffee.getPrice())
                .ifPresent(price->findCoffee.setPrice(price)); // 가격 값 변경

        Optional.ofNullable(coffee.getCoffeeStatus())
                .ifPresent(coffeeStatus->findCoffee.setCoffeeStatus(coffeeStatus)); // 상태 값 변경

        return coffeeRepository.save(findCoffee);
    }
    // 커피를 조회
    public Coffee findCoffee(long coffeeId){
        return findVerifiedCoffeeByQuery(coffeeId);
    }

    public Page<Coffee> findCoffees(int page, int size){
        return coffeeRepository.findAll(PageRequest.of(page, size, Sort.by("coffeeId").descending()));
    }

    public void deleteCoffee(long coffeeId){
        Coffee coffee = findVerifiedCoffee(coffeeId);
        coffeeRepository.delete(coffee);
    }


    private Coffee findVerifiedCoffeeByQuery(long coffeeId) {
        Optional<Coffee> optionalCoffee = coffeeRepository.findByCoffee(coffeeId);
        Coffee findCoffee =
                optionalCoffee.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.COFFEE_NOT_FOUND));

        return findCoffee;
    }

    private Coffee findVerifiedCoffee(long coffeeId) {
        Optional<Coffee> optionalCoffee = coffeeRepository.findById(coffeeId);
        Coffee findCoffee =
                optionalCoffee.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.COFFEE_NOT_FOUND));

        return findCoffee;
    }


    private void verifyExistCoffee(String coffeeCode) {
    }
}
