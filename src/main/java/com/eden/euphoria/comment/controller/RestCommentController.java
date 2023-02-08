/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 2월 5일 송민우 All rights reserved.            │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
작성일시 : 2023-02-05
작성자 : Eden
작성시간 : 오후 3:20
용도 : comment web page data Json conversion requests Handling
*/

package com.eden.euphoria.comment.controller;

import com.eden.euphoria.comment.dto.CommentVo;
import com.eden.euphoria.comment.service.CommentService;
import com.eden.euphoria.commons.annotation.LogException;
import com.eden.euphoria.user.dto.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/comment/*")
public class RestCommentController {

    @Autowired
    CommentService commentService;

    HashMap<String, Object> data = new HashMap<>();

    //  댓글 목록 + 댓글 총 갯수
    @PostMapping(value = "getCommentList")
    public HashMap<String, Object> getCommentList(int board_no) {

        data.put("commentInfo", commentService.getCommentList(board_no));
        data.put("totalCommentCount", commentService.getTotalCommentCount(board_no));

        return data;
    }

    //  댓글 작성
    @PostMapping(value = "writeComment")
    @LogException
    public HashMap<String, Object> writeComment(CommentVo commentVo, HttpSession session) {

        UserVo sessionUser = (UserVo) session.getAttribute("sessionUser");

        if (sessionUser == null) {
            data.put("result", "fail");
        } else {
            int userNo = sessionUser.getUser_no();
            commentVo.setUser_no(userNo);

            commentService.writeComment(commentVo);
        }
        return data;
    }

    //  댓글 수정
    @PostMapping(value = "commentModify")
    public HashMap<String, Object> commentModify(CommentVo commentVo) {

        commentService.updateComment(commentVo);

        data.put("result", "success");

        return data;
    }

    //  댓글 삭제
    @PostMapping(value = "deleteComment")
    public HashMap<String, Object> deleteComment(int comment_no) {

        commentService.deleteComment(comment_no);

        return data;
    }
}
