/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 1월 31일 Eden All rights reserved.            │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
작성일시 : 2023-01-31
작성자 : Eden
작성시간 : 오후 7:07
용도 : User Data Access Object Interface
*/

package com.eden.euphoria.user.dao;

import com.eden.euphoria.user.dto.LoginDTO;
import com.eden.euphoria.user.dto.QuestionVo;
import com.eden.euphoria.user.dto.UserVo;

import java.util.HashMap;
import java.util.List;

public interface UserDAO {

    //  회원가입
    public void insertUser(UserVo param);

    //  아이디 중복체크
    public int isExistId(String user_id);

    //  닉네임 중복체크
    public int isExistNickName(String user_nickname);

    //  휴대폰 중복체크
    public int isExistPhone(String user_phone);

    //  이메일 중복체크
    public int isExistEmail(String user_email);

    //  로그인
    public UserVo selectByIdAndPw(LoginDTO loginDto);

    //  아이디 찾기
    public HashMap<String, Object> getUserIdByNickNameAndEmail(UserVo param);

    //  비밀번호 질문 조회
    public List<QuestionVo> getJoinQuestionList();

    // 비밀번호 찾기 질문 조회
    public HashMap<String, Object> getUserQuestionById(UserVo param);

    // 비밀번호 질문 답변
    public UserVo getUserPwByfindAnswer(UserVo param);

    // 임시비밀번호 발급
    public void getUserUpdatePw(UserVo param);
}
