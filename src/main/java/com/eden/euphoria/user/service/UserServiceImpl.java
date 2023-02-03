/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 1월 31일 Eden All rights reserved.            │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
작성일시 : 2023-01-31
작성자 : Eden
작성시간 : 오후 7:11
용도 :
*/

package com.eden.euphoria.user.service;

import com.eden.euphoria.commons.annotation.LogException;
import com.eden.euphoria.user.dao.UserDAO;
import com.eden.euphoria.user.dto.LoginDTO;
import com.eden.euphoria.user.dto.QuestionVo;
import com.eden.euphoria.user.dto.UserVo;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserDAO userDAO;

    // 회원가입
    @Override
    @LogException
    public void insertUser(UserVo param) {

        // 비밀번호 암호화
        String password = BCrypt.hashpw(param.getUser_pw(), BCrypt.gensalt());
        param.setUser_pw(password);

        userDAO.insertUser(param);
    }

    //  아이디 중복체크
    @Override
    @LogException
    public boolean isExistId(String user_id) {
        return userDAO.isExistId(user_id) > 0;
    }

    //  닉네임 중복체크
    @Override
    @LogException
    public boolean isExistNickName(String user_nickname) {
        return userDAO.isExistNickName(user_nickname) > 0;
    }

    //  휴대폰 중복체크
    @Override
    @LogException
    public boolean isExistPhone(String user_phone) {
        return userDAO.isExistPhone(user_phone) > 0;
    }

    //  이메일 중복체크
    @Override
    @LogException
    public boolean isExistEmail(String user_email) {
        return userDAO.isExistEmail(user_email) > 2;
    }

    //  로그인
    @Override
    @LogException
    public UserVo selectByIdAndPw(LoginDTO loginDto) {
        return userDAO.selectByIdAndPw(loginDto);
    }

    // 아이디 찾기
    @Override
    @LogException
    public HashMap<String, Object> getUserIdByNickNameAndEmail(UserVo param) {
        return userDAO.getUserIdByNickNameAndEmail(param);
    }
    
    // 비밀번호 찾기 질문
    @Override
    @LogException
    public List<QuestionVo> getJoinQuestionList() {
        return userDAO.getJoinQuestionList();
    }
    
    //  비밀번호 찾기 질문 조회
    @Override
    @LogException
    public HashMap<String, Object> getUserQuestionById(UserVo param) {
        return userDAO.getUserQuestionById(param);
    }

    //  비밀번호 질문 답변
    public UserVo getUserPwByfindAnswer(UserVo param) {
        return userDAO.getUserPwByfindAnswer(param);
    }

    //  임시 비밀번호 발급
    public void getUserUpdatePw(UserVo param) {
        userDAO.getUserUpdatePw(param);
    }

    //  자동로그인
    @Override
    @LogException
    public void keepLogin(String user_id, String sessionId, Date next) {
        userDAO.keepLogin(user_id, sessionId, next);
    }

    // Session Key 확인
    @Override
    @LogException
    public UserVo checkLoginBefore(String value) {
        return userDAO.checkUserWithSessionKey(value);
    }

    // 회원정보 조회
    public UserVo getUser(String user_id) {
        return userDAO.getUser(user_id);
    }

    //  회원정보 수정
    @Override
    @LogException
    public void updateUserInfo(UserVo param) {
        userDAO.updateUserInfo(param);
    }

    //  회원정보 탈퇴
    public void deleteUserInfoByUserNo(UserVo param) {
        userDAO.deleteUserInfoByUserNo(param);
    }
}
