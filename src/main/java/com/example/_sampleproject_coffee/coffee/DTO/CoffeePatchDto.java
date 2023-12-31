package com.example._sampleproject_coffee.coffee.DTO;

import com.example._sampleproject_coffee.ResponseTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CoffeePatchDto {

    private long coffeeId;




    private String responseTime;

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }
    //    public String getResponseTime() {
//        Date today = new Date();
//        return String.valueOf(today);
//    }


    @NotBlank
    private String KorName;
    //Request Body에 선택적으로 포함될 수 있습니다(포함될 수도 있고 그렇지 않을 수도 있다).
    //즉, Request Body에 포함되지 않으면 유효성 검증을 하지 않거나 항상 검증을 통과해야 합니다.
    //Request Body에 포함되는 경우
    //공백만으로 구성되지 않아야 합니다.
    //예)
    //“”(X)
    //“ ” (X)

    @Pattern(regexp = "^([A-Za-z])+(\\s?([A-Za-z])+)*$",message = "공백 확인하세욧")

    private String engName;
    //Request Body에 선택적으로 포함될 수 있습니다(포함될 수도 있고 그렇지 않을 수도 있다).
    //즉, Request Body에 포함되지 않으면 유효성 검증을 하지 않거나 항상 검증을 통과해야 합니다.
    //Request Body에 포함되는 경우
    //공백만으로 구성되지 않아야 합니다.
    //예) “”, 또는 “ ” 가 아니어야 함.
    //영문(대소문자 모두 가능)만 허용합니다.
    //워드 사이에 한 칸의 공백(스페이스)만 포함될 수 있습니다.
    //예)
    //“Cafe Latte” (ㅇ)
    //“Ca fe Latte” (ㅇ)
    //“Cafe Latte” (X)
    //“ Cafe Latte” (X)
    //“ Cafe Latte ” (X)
    //“ Cafe Latte ” (X)

    @Range(min = 100, max = 50000,message = "숫자 범위를 확인하세욧")
    private int price;
    //Request Body에 선택적으로 포함될 수 있습니다(포함될 수도 있고 그렇지 않을 수도 있다).
    //즉, Request Body에 포함되지 않으면 유효성 검증을 하지 않거나 항상 검증을 통과해야 합니다.
    //Request Body에 포함되는 경우
    //100 이상 50000 이하의 숫자만 허용합니다.


}

