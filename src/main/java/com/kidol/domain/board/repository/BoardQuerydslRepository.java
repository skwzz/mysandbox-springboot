package com.kidol.domain.board.repository;

import com.kidol.domain.board.dto.BoardResponse;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.kidol.domain.board.entity.QBoard.board;
import static com.kidol.domain.member.entity.QMember.member;

@Slf4j
@RequiredArgsConstructor
@Repository
public class BoardQuerydslRepository{

    private final JPAQueryFactory jpaQueryFactory;

    public List<BoardResponse> findAll(Pageable pageable) {
        return jpaQueryFactory
                .select(Projections.fields(BoardResponse.class
                        ,board.boardId
                        ,board.title
                        ,board.content
                        ,board.member.memberId
                        ,board.member.email
                        ,board.member.name
                ))
                .from(board)
                .innerJoin(member).on(board.member.memberId.eq(member.memberId))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }


}
