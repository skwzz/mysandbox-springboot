package com.kidol.controller;

import com.kidol.dto.BoardRequest;
import com.kidol.dto.BoardResponse;
import com.kidol.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class BoardController {

    public final BoardService boardService;

    @GetMapping("/board")
    public List<BoardResponse> readBoard(){
        return boardService.findAll();
    }

    @GetMapping("/board/{boardId}")
    public BoardResponse readBoardDetail(@PathVariable("boardId") Long boardId) throws Exception {
        return boardService.find(boardId);
    }

    @PostMapping("/board")
    public Long createBoard(@RequestBody BoardRequest boardRequest){
        return boardService.save(boardRequest);
    }
}
