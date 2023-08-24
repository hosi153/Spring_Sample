//package com.example._sampleproject_coffee.response.v1;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import org.springframework.validation.FieldError;
//
//import java.util.List;
//
//@Getter
//@AllArgsConstructor
//public class ErrorResponse {
//
//    private List<FieldError> fieldErrors;
//
//    @Getter
//    @AllArgsConstructor
//    public static class FieldError{
//
//        // DTO 클래스 유혀성 검증 실패 시, 실패한 필드에 대한 Error 정보만 담아서 응답
//        private String field;
//        private  Object rejectValue;
//        private  String reason;
//
//
//    }
//
//
//}
