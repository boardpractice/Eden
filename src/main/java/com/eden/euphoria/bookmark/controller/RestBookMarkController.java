/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 2월 17일 송민우 All rights reserved.            │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
작성일시 : 2023-02-17
작성자 : Eden
작성시간 : 오전 7:03
용도 : 
*/

package com.eden.euphoria.bookmark.controller;

import com.eden.euphoria.bookmark.dto.BookMarkVo;
import com.eden.euphoria.bookmark.service.BookMarkService;
import com.eden.euphoria.user.dto.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/bookmark/*")

public class RestBookMarkController {

    HashMap<String, Object> data = new HashMap<>();

    @Autowired
    BookMarkService bookMarkService;

    //  게시글 북마크 등록
    @PostMapping(value = "doBookMark")
    public HashMap<String, Object> doBookMark(BookMarkVo param, HttpSession session) {
        UserVo sessionUser = (UserVo) session.getAttribute("sessionUser");
        if (sessionUser == null) {
            data.put("result", "error");
            data.put("reason", "로그인이 필요합니다.");
            return data;
        }

        int userNo = sessionUser.getUser_no();
        int myBookMarkStatus = bookMarkService.getMyBookMarkStatus(param);

        if (myBookMarkStatus > 0) {
            data.put("status", "bookMark");
        } else {
            data.put("status", "unBookMark");
        }

        param.setUser_no(userNo);

        data.put("result", "success");

        bookMarkService.doBookMark(param);
        return data;
    }

    //  게시글 북마크 상태
    @PostMapping("getMyBookMarkStatus")
    public HashMap<String, Object> getMyBookMarkStatus(BookMarkVo param, HttpSession session) {

        UserVo sessionUser = (UserVo) session.getAttribute("sessionUser");

        int userNo = sessionUser.getUser_no();
        param.setUser_no(userNo);

        int bookMarkStatus = bookMarkService.getMyBookMarkStatus(param);

        if (bookMarkStatus > 0) {
            data.put("status", "bookMark");
        } else {
            data.put("status", "unBookMark");
        }

        return data;
    }
}
