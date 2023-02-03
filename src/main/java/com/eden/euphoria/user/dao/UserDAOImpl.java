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
import com.eden.euphoria.user.dto.LoginDTO;
import com.eden.euphoria.user.dto.QuestionVo;
import com.eden.euphoria.user.dto.UserVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //  아이디 중복체크
    @Override
    @LogException
    public int isExistId(String user_id) {
        return sqlSession.selectOne(NAMESPACE + ".isExistId", user_id);
    }

    //  닉네임 중복체크
    @Override
    @LogException
    public int isExistNickName(String user_nickname) {
        return sqlSession.selectOne(NAMESPACE + ".isExistNickName", user_nickname);
    }

    //  휴대폰 중복체크
    @Override
    @LogException
    public int isExistPhone(String user_phone) {
        return sqlSession.selectOne(NAMESPACE + ".isExistPhone", user_phone);
    }

    //  이메일 중복체크
    @Override
    @LogException
    public int isExistEmail(String user_email) {
        return sqlSession.selectOne(NAMESPACE + ".isExistEmail", user_email);
    }

    //  유저로그인
    @Override
    @LogException
    public UserVo selectByIdAndPw(LoginDTO dto) {
        return sqlSession.selectOne(NAMESPACE + ".selectByIdAndPw", dto);
    }

    //  아이디 찾기
    @Override
    @LogException
    public HashMap<String, Object> getUserIdByNickNameAndEmail(UserVo param) {
        return sqlSession.selectOne(NAMESPACE + ".getUserIdByNickNameAndEmail", param);
    }

    //  비밀번호 찾기 질문
    @Override
    @LogException
    public List<QuestionVo> getJoinQuestionList() {
        return sqlSession.selectList(NAMESPACE + ".getJoinQuestionList");
    }

    // 비밀번호 찾기 질문 조회
    @Override
    @LogException
    public HashMap<String, Object> getUserQuestionById(UserVo param) {
        return sqlSession.selectOne(NAMESPACE + ".getUserQuestionById", param);
    }

    //  비밀번호 찾기 질문 답변
    public UserVo getUserPwByfindAnswer(UserVo param) {
        return sqlSession.selectOne(NAMESPACE + ".getUserPwByfindAnswer", param);
    }

    //  임시 비밀번호 발급
    @Override
    @LogException
    public void getUserUpdatePw(UserVo param) {
        sqlSession.update(NAMESPACE + ".getUserUpdatePw", param);
    }

    // 로그인 유지
    @Override
    @LogException
    public void keepLogin(String user_id, String sessionId, Date next) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("user_id", user_id);
        paramMap.put("sessionId", sessionId);
        paramMap.put("next", next);

        sqlSession.update(NAMESPACE + ".keepLogin", paramMap);
    }

    // Session Key 확인
    @Override
    @LogException
    public UserVo checkUserWithSessionKey(String value) {
        return sqlSession.selectOne(NAMESPACE + ".checkUserWithSessionKey", value);
    }

    //  회원정보 조회
    public UserVo getUser(String user_id) {
        return sqlSession.selectOne(NAMESPACE + ".getUser", user_id);
    }

    //  회원정보 수정
    @Override
    @LogException
    public void updateUserInfo(UserVo param) {
        sqlSession.update(NAMESPACE + ".updateUserInfo", param);
    }

    //  회원정보 탈퇴
    @Override
    @LogException
    public void deleteUserInfoByUserNo(UserVo param) {
        sqlSession.update(NAMESPACE + ".deleteUserInfoByUserNo", param);
    }

    //  아이디 체크
    public int isCheckId(String user_id) {
        return sqlSession.selectOne(NAMESPACE + ".isCheckId", user_id);
    }

    //  닉네임 체크
    public int isCheckNickName(UserVo param) {
        return sqlSession.selectOne(NAMESPACE + ".isCheckNickName", param);
    }

    //  이메일 체크
    public int isCheckEmail(UserVo param) {
        return sqlSession.selectOne(NAMESPACE + ".isCheckEmail", param);
    }

    //  계정 복구 정보 조회
    public int checkUser(UserVo param) {
        return sqlSession.selectOne(NAMESPACE + ".checkUser", param);
    }

    //  계정 활성화
    public void recoveryUserByInfo(UserVo param) {
        sqlSession.update(NAMESPACE + ".recoveryUserByInfo", param);
    }
}
