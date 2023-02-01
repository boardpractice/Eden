/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 2월 1일 Eden All rights reserved.            │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
작성일시 : 2023-02-01
작성자 : Eden
작성시간 : 오후 11:27
용도 : Interceptor for automatic login processing
*/

package com.eden.euphoria.commons.interceptor;

import com.eden.euphoria.user.dto.UserVo;
import com.eden.euphoria.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AutoLoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
        // 로그인 유지를 위한 쿠키가 존재하면
        if (loginCookie != null) {
            UserVo userVO = userService.checkLoginBefore(loginCookie.getValue());
            // session에 로그인 정보 저장
            if (userVO != null) {
                session.setAttribute("sessionUser", userVO);
            }
        }
        return true;
    }
}