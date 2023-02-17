/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 2월 5일 송민우 All rights reserved.            │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
작성일시 : 2023-02-05
작성자 : Eden
작성시간 : 오후 3:25
용도 : Comment business logic Interface
*/

package com.eden.euphoria.comment.service;

import com.eden.euphoria.comment.dto.CommentLikeVo;
import com.eden.euphoria.comment.dto.CommentVo;

import java.util.ArrayList;
import java.util.HashMap;

public interface CommentService {

    //  댓글 목록
    public ArrayList<HashMap<String, Object>> getCommentList(int board_no);

    //  댓글 총 갯수
    public int getTotalCommentCount(int board_no);

    //  댓글 작성
    public void writeComment(CommentVo commentVo);

    //  댓글 수정
    public void updateComment(CommentVo commentVo);

    //  댓글 삭제
    public void deleteComment(int comment_no);

    //  댓글 좋아요
    public void doCommentLike(CommentLikeVo like);

    //  댓글 좋아요 상태
    public int getMyCommentLikeCount(CommentLikeVo like);

    //  댓글 좋아요 총 갯수
    public int getTotalCommentLikeCount(int comment_no);

    //  내가 작성한 댓글
    public ArrayList<HashMap<String, Object>> getMyCommentList(int user_no);
}
