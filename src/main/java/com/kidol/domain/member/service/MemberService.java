package com.kidol.domain.member.service;

import com.kidol.domain.common.mapstruct.MemberMapper;
import com.kidol.domain.member.dto.MemberResponse;
import com.kidol.domain.member.entity.Member;
import com.kidol.domain.member.repository.MemberQuerydslRepository;
import com.kidol.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class MemberService {

    private final MemberMapper memberMapper = Mappers.getMapper(MemberMapper.class);

    private final MemberRepository memberRepository;
    private final MemberQuerydslRepository memberQuerydslRepository;

    @Transactional(readOnly = true)
    public Page<MemberResponse> readMemberList(Pageable pageable){
        Page<Member> page = memberRepository.findAll(pageable);
        return new PageImpl<>(memberMapper.toResponse(memberRepository.findAll(pageable).getContent()), pageable, page.getTotalElements());
    }

    @Transactional(readOnly = true)
    public List<MemberResponse> memberQuerydsl1() {
        return memberQuerydslRepository.memberQuerydsl1();
    }
}
