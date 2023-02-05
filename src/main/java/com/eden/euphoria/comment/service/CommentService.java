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

import java.util.ArrayList;
import java.util.HashMap;

public interface CommentService {

    //  댓글 목록
    public ArrayList<HashMap<String, Object>> getCommentList(int board_no);

    //  댓글 총 갯수
    public int getTotalCommentCount(int board_no);
}
