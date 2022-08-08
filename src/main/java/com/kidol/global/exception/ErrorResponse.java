package com.kidol.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;

import java.util.List;

@Slf4j
@Getter
@AllArgsConstructor
public class ErrorResponse {

    private boolean success;
    private String message;
    private int status;
    private List<FieldError> errors;
}
