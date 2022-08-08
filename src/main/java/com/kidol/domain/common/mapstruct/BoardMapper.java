package com.kidol.domain.common.mapstruct;

import com.kidol.domain.board.dto.BoardRequest;
import com.kidol.domain.board.dto.BoardResponse;
import com.kidol.domain.board.entity.Board;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BoardMapper extends GenericMapper<BoardRequest, BoardResponse, Board> {
}
