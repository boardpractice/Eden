/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 1월 30일 송민우 All rights reserved.          │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
Date Created : 2023-01-30
Code Author : 송민우
Creation Time : 오전 5:58
Purpose : Custom Exception Message Source
*/

package com.eden.euphoria.commons.exception;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomExceptionReSolver  extends AbstractHandlerExceptionResolver {

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("exception/exception_page");

        if (handler != null) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            modelAndView.addObject("errorMethod", handlerMethod.getMethod().getName());
        }
        modelAndView.addObject("errorCause", ex.getCause());
        modelAndView.addObject("errorClass", ex.getClass().getSimpleName());
        modelAndView.addObject("errorMessage", ex.getMessage());

        return modelAndView;
    }
}