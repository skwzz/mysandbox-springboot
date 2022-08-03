package com.kidol.controller;

import com.kidol.dto.BoardRequest;
import com.kidol.dto.BoardResponse;
import com.kidol.service.BoardService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
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
    public List<BoardResponse> readBoard(){
        return boardService.findAll();
    }

    @ApiOperation(value = "게시글 단건조회 (by boardId)")
    @GetMapping("/board/{boardId}")
    public BoardResponse readBoardDetail(@PathVariable("boardId") Long boardId) throws Exception {
        return boardService.find(boardId);
    }

    @ApiOperation(value = "게시글 등록")
    @PostMapping("/board")
    public Long createBoard(@RequestBody @Valid BoardRequest boardRequest){
        return boardService.save(boardRequest);
    }
}
