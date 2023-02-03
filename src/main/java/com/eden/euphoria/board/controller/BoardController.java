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

import com.eden.euphoria.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping(value = "/board/*")
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping(value = "list")
    public String list(Model model) {

        ArrayList<HashMap<String, Object>> dataList = boardService.getBoardList();

        model.addAttribute("dataList", dataList);

        return "board/list";
    }
}
