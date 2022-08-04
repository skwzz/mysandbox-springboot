package com.kidol.domain.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserController {

    @ApiOperation(value = "멤버 전체조회")
    @GetMapping("/member")
    public String readMemberList(){
        return "ALL MEMBER LIST";
    }
}
