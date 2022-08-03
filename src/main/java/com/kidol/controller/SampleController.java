package com.kidol.controller;

import com.kidol.dto.BoardRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class SampleController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @PostMapping("/checkDto")
    public String checkDto(@RequestBody BoardRequest boardRequest){
        log.info("Board Request is {}", boardRequest.toString());
        return boardRequest.toString();
    }
}
