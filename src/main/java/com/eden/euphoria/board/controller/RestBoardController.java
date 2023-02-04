/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 2월 4일 Eden All rights reserved.             │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
작성일시 : 2023-02-04
작성자 : Eden
작성시간 : 오후 11:28
용도 : board web page data Json conversion requests Handling
*/

package com.eden.euphoria.board.controller;

import com.eden.euphoria.board.dto.BoardLikeVo;
import com.eden.euphoria.board.service.BoardService;
import com.eden.euphoria.user.dto.UserVo;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/board/*")

public class RestBoardController {

    @Autowired
    private BoardService boardService;

    private final HashMap<String, Object> data = new HashMap<>();

    //  게시글 좋아요 및 좋아요 취소
    @PostMapping(value = "doLike")
    public HashMap<String, Object> doLike(BoardLikeVo param, HttpSession session) {
        UserVo sessionUser = (UserVo) session.getAttribute("sessionUser");

        if (sessionUser == null) {
            data.put("result", "error");
            data.put("reason", "로그인이 필요합니다.");
            return data;
        }

        int myLikeCount = boardService.getMyLikeCount(param);

        data.put("result", "success");

        if (myLikeCount > 0) {
            data.put("status", "like");
        } else {
            data.put("status", "unlike");
        }

        int userNo = sessionUser.getUser_no();
        param.setUser_no(userNo);

        boardService.doLike(param);

        data.put("result", "success");

        return data;
    }

    //  게시글 좋아요 상태
    @PostMapping("getMyLikeStatus")
    public HashMap<String, Object> getMyLikeStatus(BoardLikeVo param, HttpSession session) {
        HashMap<String, Object> data = new HashMap<>();

        UserVo sessionUser = (UserVo) session.getAttribute("sessionUser");
        if (sessionUser == null) {
            data.put("result", "error");
            data.put("reason", "로그인이 필요합니다.");
            return data;
        }

        param.setUser_no(sessionUser.getUser_no());

        int myLikeCount = boardService.getMyLikeCount(param);

        data.put("result", "success");

        if (myLikeCount > 0) {
            data.put("status", "like");
        } else {
            data.put("status", "unlike");
        }

        return data;
    }

    //  게시글 좋아요 총 갯수
    @PostMapping(value = "getTotalLikeCount")
    @Length
    public HashMap<String, Object> getTotalLikeCount(int board_no){
        HashMap<String, Object> data = new HashMap<String, Object>();

        int totalLikeCount = boardService.getTotalLikeCount(board_no);
        data.put("totalLikeCount", totalLikeCount);

        System.out.println("발동");

        return data;
    }
}
