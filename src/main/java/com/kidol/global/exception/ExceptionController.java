package com.kidol.global.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e, HttpServletRequest request, BindingResult bindingResult){
        log.error("Occurred Exception...");
        List<FieldError> fieldErrorList = bindingResult.getFieldErrors();
        Map<String, String> hm = new HashMap<>();
        hm.put("message", e.getMessage());
        return new ResponseEntity<Map<String, String>>(hm, HttpStatus.BAD_REQUEST);
    }
}
