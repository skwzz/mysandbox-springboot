package com.kidol.domain.board.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BoardType {

    BOARD_POST("post", "게시글"),
    BOARD_NOTICE("notice", "공지사항");

    private String boardTypeEng;
    private String boardTypeKor;
}
