/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 1월 31일 Eden All rights reserved.            │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
작성일시 : 2023-01-31
작성자 : Eden
작성시간 : 오후 7:06
용도 : User Data Access Object Request Handling
*/

package com.eden.euphoria.user.dao;

import com.eden.euphoria.commons.annotation.LogException;
import com.eden.euphoria.user.dto.UserVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

    private static final String NAMESPACE = "mappers.user.UserSQLMapper";

    @Autowired
    private SqlSession sqlSession;

//  회원가입
    @Override
    @LogException
    public void insertUser(UserVo param) {
        sqlSession.insert(NAMESPACE + ".insertUser", param);
    }
}
