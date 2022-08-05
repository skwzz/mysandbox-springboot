package com.kidol.domain.board.dto;

import com.kidol.domain.member.entity.Member;
import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardResponse {

    private Long boardId;
    private String title;
    private String content;
    private Long memberId;
    private String email;
    private String name;

}