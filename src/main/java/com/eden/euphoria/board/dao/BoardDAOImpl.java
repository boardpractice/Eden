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
        return sqlSession.selectList(NAMESPACE +".getBoardList");
    }

    //  게시글 작성
    @Override
    @LogException
    public void insertBoard(BoardVo param) {
        sqlSession.insert(NAMESPACE + ".write", param);
    }
}
