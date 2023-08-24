package com.example._sampleproject_coffee.response.v1;

import com.example._sampleproject_coffee.exception.BusinessLogicException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class ErrorResponse {
    private List<FieldError> fieldErrors;
    private List<ConstraintViolationError> violationErrors;
    private List<BusinessLogicException> businessLogicExceptions;


    private ErrorResponse(List<FieldError> fieldErrors, List<ConstraintViolationError> violationErrors, List<BusinessLogicException> businessLogicExceptions) {
        this.fieldErrors = fieldErrors;
        this.violationErrors = violationErrors;
        this.businessLogicExceptions = businessLogicExceptions;
    }
    //ErrorResponse -> FieldError , ConstraintViolationError

    public static ErrorResponse of(BindingResult bindingResult) {
        return new ErrorResponse(FieldError.of(bindingResult), null);
    }
    //ErrorResponse의 파라미터가  BindingResult 로 들어오는 경우 FieldError 반환
    // FieldeError = BindingResult 객체
    //ConstraintViolationError 반환은 null

    public static ErrorResponse of(Set<ConstraintViolation<?>> violations) {
        return new ErrorResponse(null, ConstraintViolationError.of(violations));
    }

    public static ErrorResponse of(List<BusinessLogicException> businessLogicExceptions){
        return new ErrorResponse()
    }


    @Getter
    public static class notFoundError {
        private Object status;
        private  String message;
        private Object fieldErrors;
        private Object violationErrors;

        private notFoundError(Object status,String message,Object fieldErrors , Object violationErrors){
            this.status=status;
            this.message = message;
            this.fieldErrors=fieldErrors;
            this.violationErrors = violationErrors;
        }

        public static List<>





    }

    @Getter
    public static class FieldError {
        private String field;
        private Object rejectedValue;
        private String reason;

        private FieldError(String field, Object rejectedValue, String reason) {
            this.field = field;
            this.rejectedValue = rejectedValue;
            this.reason = reason;
        }

        public static List<FieldError> of(BindingResult bindingResult) {
            final List<org.springframework.validation.FieldError> fieldErrors = bindingResult.getFieldErrors();
            //오류값인 FieldError 형 리스트 생성,
            return fieldErrors.stream().map(error -> new FieldError(
                            error.getField(),
                            error.getRejectedValue() == null ? "" : error.getRejectedValue().toString(),
                            error.getDefaultMessage()))
                    .collect(Collectors.toList());
        }
    }



    @Getter
    public static class ConstraintViolationError {
        private String propertyPath;
        private Object rejectedValue;
        private String reason;

        private ConstraintViolationError(String propertyPath, Object rejectedValue, String reason) {
            this.propertyPath = propertyPath;
            this.rejectedValue = rejectedValue;
            this.reason = reason;
        }

        public static List<ConstraintViolationError> of(Set<ConstraintViolation<?>> constraintViolations) {
            return constraintViolations.stream()
                    .map(constraintViolation -> new ConstraintViolationError(
                            constraintViolation.getPropertyPath().toString(),
                            constraintViolation.getInvalidValue().toString(),
                            constraintViolation.getMessage()
                    )).collect(Collectors.toList());
        }
    }
}
