package com.example._sampleproject_coffee.coffee;

import org.hibernate.validator.constraints.Range;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.Map;

public class CoffeePostDto {




    @NotNull
    @NotBlank

    private String KorName;
    //Request Body에 포함되는 필수 항목입니다(mandatory).
    //공백만으로 구성되지 않아야 합니다.
    //예) “”, 또는 “ ” 가 아니어야 함.





    @NotNull
    @NotBlank
    @Pattern(regexp = "^\\S+(\\s?\\S+)*$",message = "필수항목입니다, 공백만으로 구성될 수 없습니다. 워드사이에 공백은 한칸만 가능합니다. 공백으로 시작/ 끝을 할 수 없습니다.")
    //  ^ 시작 - $ 끝
    // \\S 공백이 아닌것
    // \\s 공백
    // + 최소 한개 or 여러개
    // ? 없거나 or 최대 한개
    // * 없거나 있거나
    // () 범위
    // \\S공백 아닌것 + 최소 한개,여러개 ( \\s? 공백이 최대 한개 \\S+ 공백아닌거 한개,여러개)* 괄호 안이 없거나 있거나
    private String engName;
    //Request Body에 포함되는 필수 항목입니다(mandatory).
    //공백만으로 구성되지 않아야 합니다.
    //예) “”, 또는 “ ” 가 아니어야 함.
    //영문(대소문자 모두 가능)만 허용합니다.
    //워드 사이에 한 칸의 공백(스페이스)만 포함될 수 있습니다.
    //예)
    //“Cafe Latte” (ㅇ)
    //“Ca fe Latte” (ㅇ)
    //“Cafe       Latte” (X)
    //“         Cafe Latte” (X)
    //“ Cafe Latte       ” (X)
    //“ Cafe Latte ” (X)

    @NotNull
    @Range(min=100, max=50000, message = "숫자 범위 틀리다")
    private int price;
    //Request Body에 포함되는 필수 항목입니다(mandatory).
    //100 이상 50000 이하의 숫자만 허용합니다.


    public String getKorName() {
        return KorName;
    }

    public void setKorName(String korName) {
        KorName = korName;
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
