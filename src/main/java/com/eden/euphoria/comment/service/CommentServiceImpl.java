/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 2월 5일 송민우 All rights reserved.            │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
작성일시 : 2023-02-05
작성자 : Eden
작성시간 : 오후 3:28
용도 : Performing Comment Business Logic
*/

package com.eden.euphoria.comment.service;

import com.eden.euphoria.comment.dao.CommentDAO;
import com.eden.euphoria.comment.dto.CommentLikeVo;
import com.eden.euphoria.comment.dto.CommentVo;
import com.eden.euphoria.commons.annotation.LogException;
import com.eden.euphoria.user.dao.UserDAO;
import com.eden.euphoria.user.dto.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDAO commentDAO;

    @Autowired
    UserDAO userDAO;

    //  댓글 목록
    public ArrayList<HashMap<String, Object>> getCommentList(int board_no) {

        ArrayList<HashMap<String, Object>> dataList = new ArrayList<HashMap<String, Object>>();
        List<CommentVo> commentVoList = commentDAO.getCommentList(board_no);

        for (CommentVo commentVo : commentVoList) {

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss");

            UserVo userVo = userDAO.getUserByNo(commentVo.getUser_no());
            HashMap<String, Object> map = new HashMap<String, Object>();

            map.put("commentVo", commentVo);
            map.put("userVo", userVo);
            map.put("totalCommentLikeCount", commentDAO.getTotalCommentLikeCount(commentVo.getComment_no()));

            dataList.add(map);
        }
        return dataList;
    }

    //  댓글 총 갯수
    @Override
    @LogException
    public int getTotalCommentCount(int board_no) {
        return commentDAO.getTotalCommentCount(board_no);
    }

    //  댓글 작성
    @Override
    @LogException
    public void writeComment(CommentVo commentVo) {
        commentDAO.writeComment(commentVo);
    }

    //  댓글 수정
    @Override
    @LogException
    public void updateComment(CommentVo commentVo) {
        commentDAO.updateComment(commentVo);
    }

    //  댓글 삭제
    public void deleteComment(int comment_no) {
        commentDAO.deleteComment(comment_no);
    }

    //  댓글 좋아요
    @Override
    @LogException
    public void doCommentLike(CommentLikeVo param) {
        if (getMyCommentLikeCount(param) < 1) {
            commentDAO.doCommentLike(param);
        } else {
            commentDAO.deleteCommentLike(param);
        }
    }

    //  댓글 좋아요 상태
    @Override
    @LogException
    public int getMyCommentLikeCount(CommentLikeVo param) {
        return commentDAO.getMyCommentLikeCount(param);
    }

    //  댓글 좋아요 총 갯수
    @Override
    @LogException
    public int getTotalCommentLikeCount(int comment_no) {
        return commentDAO.getTotalCommentLikeCount(comment_no);
    }
}
