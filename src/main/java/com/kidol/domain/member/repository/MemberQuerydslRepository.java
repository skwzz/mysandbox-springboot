package com.kidol.domain.member.repository;

import com.kidol.domain.member.dto.MemberResponse;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.kidol.domain.member.entity.QMember.member;

@Slf4j
@RequiredArgsConstructor
@Repository
public class MemberQuerydslRepository{

    private final JPAQueryFactory jpaQueryFactory;

    public List<MemberResponse> memberQuerydsl1() {
        return jpaQueryFactory
                .select(Projections.fields(MemberResponse.class
                        ,member.memberId
                        ,member.email
                        ,member.name
                ))
                .from(member)
                .fetch();
    }
}
