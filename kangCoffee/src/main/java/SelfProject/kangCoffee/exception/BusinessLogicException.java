package SelfProject.kangCoffee.exception;

import lombok.Getter;

public class BusinessLogicException extends RuntimeException {
    //BusinessLogicException은 서비스 계층에서 개발자가 의도적으로 예외를 던져야 하는 다양한 상황에서 ExceptionCode 정보만 바꿔가며 던질 수 있습니다.

    @Getter
    private ExceptionCode exceptionCode;

    public BusinessLogicException(ExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
        this.exceptionCode = exceptionCode;
    }
}