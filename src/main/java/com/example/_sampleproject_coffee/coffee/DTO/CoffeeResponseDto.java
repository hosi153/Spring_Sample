package com.example._sampleproject_coffee.coffee.DTO;

import com.example._sampleproject_coffee.CommonResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CoffeeResponseDto extends CommonResponseDto {
    private long coffeeId;

    private String name;
    private String korName;
    private String engname;
    private int price;

    //response 전용으로 데이터 처리 해야 할 시각 값을 추가한다.




}
