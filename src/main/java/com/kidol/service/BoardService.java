package com.kidol.service;

import com.kidol.dto.BoardRequest;
import com.kidol.dto.BoardResponse;
import com.kidol.entity.Board;
import com.kidol.mapstruct.BoardMapper;
import com.kidol.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class BoardService {

    private final BoardMapper boardMapper = Mappers.getMapper(BoardMapper.class);

    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public List<BoardResponse> readBoardList(){
        return boardMapper.toResponse(boardRepository.findAll());
    }

    @Transactional(readOnly = true)
    public BoardResponse readBoardDetail(Long boardId) throws Exception {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new Exception("NOT FOUND EXCEPTION"));
        return boardMapper.toResponse(board);
    }

    public Long createBoard(BoardRequest boardRequest) {
        Board board = boardMapper.toEntity(boardRequest);
        boardRepository.save(board);
        return board.getBoardId();
    }

    public BoardResponse updateBoard(BoardRequest boardRequest) {
        Board board = boardMapper.toEntity(boardRequest);
        boardRepository.save(board);
        return boardMapper.toResponse(board);
    }

    public void deleteBoard(Long boardId) {
        boardRepository.deleteById(boardId);
    }
}
