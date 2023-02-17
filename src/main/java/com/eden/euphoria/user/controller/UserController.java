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

import com.eden.euphoria.board.service.BoardService;
import com.eden.euphoria.bookmark.service.BookMarkService;
import com.eden.euphoria.comment.service.CommentService;
import com.eden.euphoria.commons.annotation.LogException;
import com.eden.euphoria.user.dto.QuestionVo;
import com.eden.euphoria.user.dto.UserVo;
import com.eden.euphoria.user.service.UserService;
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
import java.util.List;

@Controller
@RequestMapping(value = "/user/*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookMarkService bookMarkService;

    //  회원가입 페이지
    @GetMapping(value = "register")
    @LogException
    public String register(Model model, @ModelAttribute("userVo") UserVo param) {

        model.addAttribute("data", userService.getJoinQuestionList());

        return "user/register";
    }

    //  회원가입 프로세스
    @PostMapping(value = "insertUserProcess")
    @LogException
    public String insertUserProcess(Model model, @Valid UserVo param, BindingResult result) {

        if (result.hasErrors()) {

            model.addAttribute("data", userService.getJoinQuestionList());

            return "user/register";
        }

        userService.insertUser(param);
        return "redirect:../main/main";
    }

    // 내정보 페이지
    @GetMapping("profile")
    public String profile(Model model, HttpSession session) {
        UserVo sessionUser = (UserVo) session.getAttribute("sessionUser");

        ArrayList<HashMap<String, Object>> dataList = bookMarkService.getBookMarkList(sessionUser.getUser_no());
        model.addAttribute("data", userService.getJoinQuestionList());
        model.addAttribute("dataList", dataList);

        return "user/profile";
    }

    //  계정복구 페이지
    @GetMapping("userRecoveryPage")
    public String userRecoveryPage() {
        return "user/userRecoveryPage";
    }
}
