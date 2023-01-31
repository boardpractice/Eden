/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 1월 31일 Eden All rights reserved.            │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
작성일시 : 2023-01-31
작성자 : Eden
작성시간 : 오후 7:10
용도 : User Business Logic interface
*/

package com.eden.euphoria.user.service;

import com.eden.euphoria.user.dto.UserVo;

public interface UserService {

//  회원가입
    public void insertUser(UserVo param);

}
