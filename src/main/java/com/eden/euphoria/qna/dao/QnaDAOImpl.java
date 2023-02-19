/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 2월 19일 송민우 All rights reserved.            │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
작성일시 : 2023-02-19
작성자 : Eden
작성시간 : 오전 11:18
용도 : 
*/

package com.eden.euphoria.qna.dao;

import com.eden.euphoria.commons.annotation.LogException;
import com.eden.euphoria.qna.dto.QnaVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QnaDAOImpl implements QnaDAO{

    private final String NAMESPACE = "mappers.qna.QnaSQLMapper";

    @Autowired
    SqlSession sqlSession;

    //  목록
    @Override
    @LogException
    public List<QnaVo> getQnaList() {
        return sqlSession.selectList(NAMESPACE + ".getQnaList");
    }

}
