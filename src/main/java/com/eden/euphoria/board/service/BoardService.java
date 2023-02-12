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

import com.eden.euphoria.board.dto.BoardLikeVo;
import com.eden.euphoria.board.dto.BoardVo;
import com.eden.euphoria.board.dto.CategoryVo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface BoardService {

    //  게시글 목록
    public ArrayList<HashMap<String, Object>> getBoardList(int category_no, String category, String keyword);

    //  게시글 작성
    public void insertBoard(BoardVo param);

    //  게시글 상세보기
    public HashMap<String, Object> getBoard(int board_no);

    //  게시글 수정
    public void updateBoard(BoardVo param);

    //  게시글 삭제
    public void deleteBoard(int board_no);

    //  게시글 좋아요
    public void doLike(BoardLikeVo likeVo);

    //  게시글 좋아요 상태
    public int getMyLikeCount(BoardLikeVo likeVo);

    //  게시글 좋아요 총 갯수
    public int getTotalLikeCount(int board_no);

    //  게시글 카테고리 목록
    public List<CategoryVo> getCategoryList();

    //  게시글 카테고리 정보
    public CategoryVo getCategoryByNo(int category_no);
}
