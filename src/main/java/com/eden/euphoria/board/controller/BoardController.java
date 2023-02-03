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
import com.eden.euphoria.commons.annotation.LogException;
import com.eden.euphoria.user.dto.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping(value = "/board/*")
public class BoardController {

    @Autowired
    BoardService boardService;

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

    @PostMapping(value = "writeProcess")
    public String writeProcess(@Valid BoardVo param, BindingResult result, HttpSession session) {

        if (result.hasErrors()) {
            return "board/write";
        }

        UserVo sessionUser = (UserVo) session.getAttribute("sessionUser");
        param.setUser_no(sessionUser.getUser_no());

        boardService.insertBoard(param);

        return "redirect:../board/list";
    }
}
