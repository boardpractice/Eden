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
import com.eden.euphoria.user.dto.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @LogException
    public void insertUser(UserVo param) {
        userDAO.insertUser(param);
    }
}
