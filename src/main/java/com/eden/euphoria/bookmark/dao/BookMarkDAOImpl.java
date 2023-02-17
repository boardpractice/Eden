/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 2월 17일 송민우 All rights reserved.            │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
작성일시 : 2023-02-17
작성자 : Eden
작성시간 : 오전 7:05
용도 : 
*/

package com.eden.euphoria.bookmark.dao;

import com.eden.euphoria.bookmark.dto.BookMarkVo;
import com.eden.euphoria.commons.annotation.LogException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class BookMarkDAOImpl implements BookMarkDAO {

    private static final String NAMESPACE = "mappers.bookmark.BookMarkMapper";

    @Autowired
    SqlSession sqlSession;

    //  게시글 북마크 등록
    @Override
    @LogException
    public void doBookMark(BookMarkVo param) {
        sqlSession.insert(NAMESPACE + ".doBookMark", param);
    }

    //  게시글 북마크 상태
    @Override
    @LogException
    public int getMyBookMarkStatus(BookMarkVo param) {
        return sqlSession.selectOne(NAMESPACE + ".getMyBookMarkStatus", param);
    }

    //  게시글 북마크 취소
    @Override
    @LogException
    public void deleteBookMark(int board_no, int user_no) {
        HashMap<String, Object> data = new HashMap<>();
        data.put("boardNo", board_no);
        data.put("userNo", user_no);
        sqlSession.delete(NAMESPACE + ".deleteBookMark", data);
    }

}
