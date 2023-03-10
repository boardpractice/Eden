/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 2월 1일 Eden All rights reserved.            │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
작성일시 : 2023-02-01
작성자 : Eden
작성시간 : 오후 6:34
용도 : Check site login access permissions
*/

package com.eden.euphoria.commons.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        /* session 객체를 가져옴 */
        HttpSession session = request.getSession();
        /* login처리를 담당하는 사용자 정보를 담고 있는 객체를 가져옴 */
        Object obj = session.getAttribute("sessionUser");
        /* 로그인이 안되있을 경우 */
        if (obj == null) {
            saveDestination(request);
            // 로그인이 안되어 있는 상태임으로 로그인 페이지로 되돌려보냄
            response.sendRedirect("../main/main");
            /*컨트롤러 수행하지 않게끔 리턴 false로 반환*/
            return false;
        }
        return true;
    }

    // 로그인 페이지 이동 전 페이지 저장
    private void saveDestination(HttpServletRequest request) {
        String uri = request.getRequestURI();   // 현재 페이지
        String query = request.getQueryString(); // 쿼리
        if (query == null || query.equals("null")) {
            query = "";
        } else {
            query = "?" + query;
        }
        // 현재 페이지 + get 파라미터 저장
        if (request.getMethod().equals("GET")) {
            request.getSession().setAttribute("destination", uri + query);
        }
    }
}
