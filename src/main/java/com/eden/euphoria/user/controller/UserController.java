/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 1월 31일 Eden All rights reserved.            │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
작성일시 : 2023-01-31
작성자 : Eden
작성시간 : 오후 7:04
용도 : Web User Page Request Client Handling
*/

package com.eden.euphoria.user.controller;

import com.eden.euphoria.commons.annotation.LogException;
import com.eden.euphoria.user.dto.UserVo;
import com.eden.euphoria.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user/*")
public class UserController {

    @Autowired
    private UserService userService;

//  회원가입 페이지
    @GetMapping(value = "register")
    @LogException
    public String register() {
        return "user/register";
    }

//  회원가입 프로세스
    @PostMapping(value = "insertUserProcess")
    @LogException
    public String insertUserProcess(UserVo param) {
        userService.insertUser(param);
        return "redirect:../main/main";
    }

}
