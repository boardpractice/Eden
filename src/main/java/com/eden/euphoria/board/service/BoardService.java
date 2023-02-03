/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 2월 3일 Eden All rights reserved.             │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
작성일시 : 2023-02-03
작성자 : Eden
작성시간 : 오후 8:27
용도 :
*/

package com.eden.euphoria.board.service;

import com.eden.euphoria.board.dto.BoardVo;

import java.util.ArrayList;
import java.util.HashMap;

public interface BoardService {

    //  게시글 목록
    public ArrayList<HashMap<String, Object>> getBoardList();

    //  게시글 작성
    public void insertBoard(BoardVo param);
}