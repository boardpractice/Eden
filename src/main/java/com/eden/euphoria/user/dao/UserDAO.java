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

import com.eden.euphoria.user.dto.UserVo;

public interface UserDAO {

//  회원가입
    public void insertUser(UserVo param);
}
