package com.kidol.service;

import com.kidol.dto.BoardRequest;
import com.kidol.dto.BoardResponse;
import com.kidol.entity.Board;
import com.kidol.mapstruct.BoardMapper;
import com.kidol.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardMapper boardMapper = Mappers.getMapper(BoardMapper.class);

    private final BoardRepository sampleRepository;

    public List<BoardResponse> findAll(){
        return boardMapper.toResponse(sampleRepository.findAll());
    }

    public BoardResponse find(Long boardId) throws Exception {
        Board board = sampleRepository.findById(boardId).orElseThrow(() -> new Exception("NOT FOUND EXCEPTION"));
        return boardMapper.toResponse(board);
    }

    public Long save(BoardRequest boardRequest) {
        Board board = boardMapper.toEntity(boardRequest);
        sampleRepository.save(board);
        return board.getBoardId();
    }
}
