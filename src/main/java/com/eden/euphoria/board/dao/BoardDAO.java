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

import com.eden.euphoria.board.dto.BoardLikeVo;
import com.eden.euphoria.board.dto.BoardVo;
import com.eden.euphoria.board.dto.CategoryVo;

import java.util.List;

public interface BoardDAO {

    //  게시글 목록
    public List<BoardVo> getBoardList(int pageNum);

    //  게시글 목록 (카테고리별 정렬)
    public List<BoardVo> getBoardByCategoryList(int category_no, int pageNum);

    //  게시글 작성
    public void insertBoard(BoardVo param);

    //  게시글 상세보기
    public BoardVo getBoardByNo(int board_no);

    //  게시글 수정
    public void updateBoard(BoardVo param);

    //  게시글 삭제
    public void deleteBoard(int board_no);

    //  게시글 좋아요
    public void doLike(BoardLikeVo likeVo);

    //  게시글 좋아요 상태
    public int getMyLikeCount(BoardLikeVo likeVo);

    //  게시글 좋아요 취소
    public void deleteLike(BoardLikeVo likeVo);

    //  게시글 좋아요 총 갯수
    public int getTotalLikeCount(int board_no);

    //  게시글 카테고리 정보
    public CategoryVo getCategoryByNo(int category_no);

    //  게시글 카테고리 목록
    public List<CategoryVo> getCategoryList();

    //  게시글 제목 검색
    public List<BoardVo> selectByTitle(String title, int category_no, int pageNum);

    //  게시글 내용 검색
    public List<BoardVo> selectByContent(String content, int category_no, int pageNum);

    //  게시글 작성자 검색
    public List<BoardVo> selectByNickName(String nickname, int category_no, int pageNum);

    //  게시글 총 갯수 ( 페이징 용도 )
    public int selectCount(String searchType, String searchWord, int category_no);
}
