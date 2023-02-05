/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 2월 3일 Eden All rights reserved.             │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
작성일시 : 2023-02-03
작성자 : Eden
작성시간 : 오후 8:20
용도 : Web Board Page Request Client Handling
*/

package com.eden.euphoria.board.controller;

import com.eden.euphoria.board.dto.BoardVo;
import com.eden.euphoria.board.service.BoardService;
import com.eden.euphoria.comment.service.CommentService;
import com.eden.euphoria.commons.annotation.LogException;
import com.eden.euphoria.user.dto.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping(value = "/board/*")
public class BoardController {

    @Autowired
    BoardService boardService;

    @Autowired
    CommentService commentService;

    //  게시글 목록
    @GetMapping(value = "list")
    @LogException
    public String list(Model model) {

        ArrayList<HashMap<String, Object>> dataList = boardService.getBoardList();

        model.addAttribute("dataList", dataList);

        return "board/list";
    }

    //  게시글 작성 페이지
    @GetMapping("write")
    @LogException
    public String write(@ModelAttribute("boardVo") BoardVo vo) {
        return "board/write";
    }

    //  게시글 작성 프로시저
    @PostMapping(value = "writeProcess")
    @LogException
    public String writeProcess(@Valid BoardVo param, BindingResult result, HttpSession session) {

        if (result.hasErrors()) {
            return "board/write";
        }

        UserVo sessionUser = (UserVo) session.getAttribute("sessionUser");
        param.setUser_no(sessionUser.getUser_no());

        boardService.insertBoard(param);

        return "redirect:../board/list";
    }

    //  게시글 보기 페이지
    @PostMapping(value = "read")
    @LogException
    public String read(int board_no, Model model) {

        model.addAttribute("data", boardService.getBoard(board_no));
        model.addAttribute("dataList", commentService.getCommentList(board_no));
        return "board/read";
    }

    //  게시글 수정
    @PostMapping(value = "modify")
    @LogException
    public String modify(Model model, @RequestParam(value = "board_no", defaultValue = "0") int boardNo) {

        model.addAttribute("data", boardService.getBoard(boardNo));

        return "board/modify";
    }

    //  게시글 수정 프로시져
    @PostMapping(value = "modifyProcess")
    @LogException
    public String modifyProcess(BoardVo boardVo) {

        boardService.updateBoard(boardVo);

        return "redirect:../board/list";
    }

    //  게시글 삭제 프로시져
    @PostMapping(value = "delete")
    @LogException
    public String delete(int board_no) {

        boardService.deleteBoard(board_no);

        return "redirect:../board/list";
    }
}
