package SelfProject.kangCoffee.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ErrorResponse {
    // 변수들이 하나 이상일 가능성이 있기 때문에 에러 역시 하나 이상이 될 수 있다.
    // 따라서 응답 객체를 배열로 설정
    private List<FieldError> fieldErrors;
    @Getter
    @AllArgsConstructor
    public static class FieldError {
        private String field;
        private Object rejectedValue;
        private String reason;
    }
}
