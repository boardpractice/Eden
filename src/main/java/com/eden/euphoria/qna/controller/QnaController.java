/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 2월 19일 송민우 All rights reserved.            │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
작성일시 : 2023-02-19
작성자 : Eden
작성시간 : 오전 11:14
용도 : 
*/

package com.eden.euphoria.qna.controller;

import com.eden.euphoria.qna.service.QnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@Controller
@RequestMapping(value = "/qna/*")
public class QnaController {

    @Autowired
    QnaService qnaService;

    @RequestMapping(value = "list")
    public String QnaList(Model model) {
        ArrayList<HashMap<String, Object>> dataList = qnaService.getQnaList();
        model.addAttribute("dataList", dataList);

        return "qna/list";
    }
}
