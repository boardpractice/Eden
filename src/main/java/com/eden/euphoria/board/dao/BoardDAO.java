/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 2월 3일 Eden All rights reserved.             │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
작성일시 : 2023-02-03
작성자 : Eden
작성시간 : 오후 8:21
용도 :
*/

package com.eden.euphoria.board.dao;

import com.eden.euphoria.board.dto.BoardVo;

import java.util.List;

public interface BoardDAO {

    //  게시글 목록
    public List<BoardVo> getBoardList();

    //  게시글 작성
    public void insertBoard(BoardVo param);
}
