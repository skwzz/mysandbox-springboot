package com.kidol.domain.board.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardResponse {

    private Long boardId;
    private String title;
    private String content;
    private Long memberId;
    private String email;
    private String name;

}