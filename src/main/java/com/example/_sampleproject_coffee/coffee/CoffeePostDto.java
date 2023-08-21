package com.example._sampleproject_coffee.coffee;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

public class CoffeePostDto {


    private String KorName;
    //Request Body에 포함되는 필수 항목입니다(mandatory).
    //공백만으로 구성되지 않아야 합니다.
    //예) “”, 또는 “ ” 가 아니어야 함.
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
