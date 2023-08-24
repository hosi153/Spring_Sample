package com.example._sampleproject_coffee.exception;

import lombok.Getter;

public enum ExceptionCode {

    MEMBER_NOTFOUND(404,"Memeber Not Found");

    @Getter
    private int status;
    @Getter
    private String message;

    ExceptionCode(int status, String message){
        this.status= status;
        this.message =message;
    }
}
