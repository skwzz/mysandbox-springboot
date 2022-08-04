package com.kidol.domain.member.service;

import com.kidol.domain.member.entity.Member;
import com.kidol.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class MemberService {

    //private final BoardMapper boardMapper = Mappers.getMapper(BoardMapper.class);

    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public Page<Member> readMemberList(Pageable pageable){
        return memberRepository.findAll(pageable);
    }
}
