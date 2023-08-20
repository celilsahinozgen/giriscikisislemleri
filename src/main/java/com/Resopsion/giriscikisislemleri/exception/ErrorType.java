package com.Resopsion.giriscikisislemleri.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;


@AllArgsConstructor
@NoArgsConstructor
@Getter

public enum ErrorType {

    INTERNAL_ERROR(2000, "Internal Server Error", INTERNAL_SERVER_ERROR),
    BAD_REQUEST_ERROR(2001, "Invalid Parameter Error", BAD_REQUEST);

    private int code;
    private String message;
    private HttpStatus httpStatus;
}