/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 2월 3일 Eden All rights reserved.             │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
작성일시 : 2023-02-03
작성자 : Eden
작성시간 : 오후 8:23
용도 :
*/

package com.eden.euphoria.board.dao;

import com.eden.euphoria.board.dto.BoardLikeVo;
import com.eden.euphoria.board.dto.BoardVo;
import com.eden.euphoria.commons.annotation.LogException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDAOImpl implements BoardDAO {

    private static final String NAMESPACE = "mappers.board.BoardSQLMapper";

    @Autowired
    SqlSession sqlSession;

    //  게시글 목록
    @Override
    @LogException
    public List<BoardVo> getBoardList() {
        return sqlSession.selectList(NAMESPACE + ".getBoardList");
    }

    //  게시글 작성
    @Override
    @LogException
    public void insertBoard(BoardVo param) {
        sqlSession.insert(NAMESPACE + ".write", param);
    }

    //  게시글 상세보기
    @Override
    @LogException
    public BoardVo getBoardByNo(int board_no) {
        return sqlSession.selectOne(NAMESPACE + ".getBoardByNo", board_no);
    }

    //  게시글 수정
    @Override
    @LogException
    public void updateBoard(BoardVo param) {
        sqlSession.update(NAMESPACE + ".updateBoard", param);
    }

    //  게시글 삭제
    @Override
    @LogException
    public void deleteBoard(int board_no) {
        sqlSession.delete(NAMESPACE + ".deleteBoard", board_no);
    }

    //  게시글 좋아요
    @Override
    @LogException
    public void doLike(BoardLikeVo likeVo) {
        sqlSession.insert(NAMESPACE + ".doLike", likeVo);
    }

    //  게시글 좋아요 상태
    @Override
    @LogException
    public int getMyLikeCount(BoardLikeVo likeVo) {
        return sqlSession.selectOne(NAMESPACE + ".getMyLikeCount", likeVo);
    }

    //  게시글 좋아요 취소
    @Override
    @LogException
    public void deleteLike(BoardLikeVo likeVo) {
        sqlSession.delete(NAMESPACE + ".deleteLike", likeVo);
    }

    //  게시글 좋아요 총 갯수
    @Override
    @LogException
    public int getTotalLikeCount(int board_no) {
        return sqlSession.selectOne(NAMESPACE + ".getTotalLikeCount", board_no);
    }
}
