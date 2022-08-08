package com.kidol.domain.member.controller;

import com.kidol.domain.member.dto.MemberRequest;
import com.kidol.domain.member.dto.MemberResponse;
import com.kidol.domain.member.entity.Member;
import com.kidol.domain.member.service.MemberService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @ApiOperation(value = "멤버 전체조회")
    @GetMapping("/member")
    public Page<MemberResponse> readMemberList(Pageable pageable){
        return memberService.readMemberList(pageable);
    }

    @ApiOperation(value = "멤버 전체조회 querydsl 테스트")
    @GetMapping("/memberQuerydsl1")
    public List<MemberResponse> memberQuerydsl1(){
        return memberService.memberQuerydsl1();
    }

    @ApiOperation(value = "회원 신규등록")
    @PostMapping("/member")
    public Member createMember(@RequestBody @Valid MemberRequest memberRequest){
        return memberService.createMember(memberRequest);
    }
}
