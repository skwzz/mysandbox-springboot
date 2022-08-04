package com.kidol.domain.member.controller;

import com.kidol.domain.member.entity.Member;
import com.kidol.domain.member.service.MemberService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @ApiOperation(value = "멤버 전체조회")
    @GetMapping("/member")
    public Page<Member> readMemberList(Pageable pageable){
        return memberService.readMemberList(pageable);
    }
}
