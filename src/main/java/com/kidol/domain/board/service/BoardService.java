package com.kidol.domain.board.service;

import com.kidol.domain.board.dto.BoardRequest;
import com.kidol.domain.board.dto.BoardResponse;
import com.kidol.domain.board.entity.Board;
import com.kidol.domain.board.repository.BoardQuerydslRepository;
import com.kidol.domain.common.mapstruct.BoardMapper;
import com.kidol.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class BoardService {

    private final BoardMapper boardMapper = Mappers.getMapper(BoardMapper.class);

    private final BoardRepository boardRepository;
    private final BoardQuerydslRepository boardQuerydslRepository;

    @Transactional(readOnly = true)
    public Page<BoardResponse> readBoardList(Pageable pageable){
        Page<Board> page = boardRepository.findAll(pageable);
        List<BoardResponse> list = toResponse(boardRepository.findAll(pageable).getContent());
        return new PageImpl<>(list, pageable, page.getTotalElements());
    }

    private List<BoardResponse> toResponse(List<Board> boards){
        if(boards == null){
            return null;
        }

        List<BoardResponse> list = new ArrayList<>();
        for(Board board : boards){
            BoardResponse br = BoardResponse.builder()
                    .boardId(board.getBoardId())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .memberId(board.getMember().getMemberId())
                    .email(board.getMember().getEmail())
                    .name(board.getMember().getName())
                    .build();
            list.add(br);
        }

        return list;
    }

    @Transactional(readOnly = true)
    public Page<Board> readBoardList_entity(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public List<BoardResponse> readBoardList_querydsl(Pageable pageable) {
        return boardQuerydslRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public BoardResponse readBoardDetail(Long boardId) throws Exception {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new Exception("NOT FOUND EXCEPTION"));
        return boardMapper.toResponse(board);
    }

    public Long createBoard(BoardRequest boardRequest) {
        Board board = boardMapper.toEntity(boardRequest);
        boardRepository.save(board);
        //return board.getBoardId();
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
