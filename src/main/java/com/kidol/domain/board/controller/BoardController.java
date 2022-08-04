package com.kidol.domain.board.controller;

import com.kidol.domain.board.dto.BoardRequest;
import com.kidol.domain.board.dto.BoardResponse;
import com.kidol.domain.board.service.BoardService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class BoardController {

    public final BoardService boardService;

    @ApiOperation(value = "게시글 전체조회")
    @GetMapping("/board")
    public List<BoardResponse> readBoardList(){
        return boardService.readBoardList();
    }

    @ApiOperation(value = "게시글 상세조회")
    @GetMapping("/board/{boardId}")
    public BoardResponse readBoardDetail(@PathVariable("boardId") Long boardId) throws Exception {
        return boardService.readBoardDetail(boardId);
    }

    @ApiOperation(value = "게시글 등록")
    @PostMapping("/board")
    public Long createBoard(@RequestBody @Valid BoardRequest boardRequest){
        return boardService.createBoard(boardRequest);
    }

    @ApiOperation(value="게시글 수정")
    @PutMapping("/board")
    public BoardResponse updateBoard(@RequestBody @Valid BoardRequest boardRequest){
        return boardService.updateBoard(boardRequest);
    }

    @ApiOperation(value = "게시글 삭제")
    @DeleteMapping("/board/{boardId}")
    public void deleteBoard(@PathVariable("boardId") Long boardId){
        boardService.deleteBoard(boardId);
    }
}
