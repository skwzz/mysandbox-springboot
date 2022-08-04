package com.kidol.domain.board.dto;

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
}