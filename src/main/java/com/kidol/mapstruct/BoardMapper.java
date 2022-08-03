package com.kidol.mapstruct;

import com.kidol.dto.BoardRequest;
import com.kidol.dto.BoardResponse;
import com.kidol.entity.Board;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BoardMapper extends GenericMapper<BoardRequest, BoardResponse, Board> {
}
