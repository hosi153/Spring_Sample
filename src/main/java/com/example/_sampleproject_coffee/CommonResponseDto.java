package com.example._sampleproject_coffee;

import java.time.LocalDateTime;

public class CommonResponseDto {
    //response 전용으로 데이터 처리 해야 할 시각 값을 추가한다.

    private LocalDateTime completedAt;
    // 시간 표현 이름  At
    //

    public LocalDateTime getCompletedAt(){
        return this.completedAt = LocalDateTime.now();
    }



}
