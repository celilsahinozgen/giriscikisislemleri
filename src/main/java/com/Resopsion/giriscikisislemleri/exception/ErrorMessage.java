package com.Resopsion.giriscikisislemleri.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Builder
@Component
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {

    private int code;
    private String message;
    private List<String> fields;
}
