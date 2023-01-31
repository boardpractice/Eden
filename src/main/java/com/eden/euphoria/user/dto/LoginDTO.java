/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 2월 1일 Eden All rights reserved.            │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
작성일시 : 2023-02-01
작성자 : Eden
작성시간 : 오전 5:21
용도 : Login Data Transfer Object
*/

package com.eden.euphoria.user.dto;

public class LoginDTO {
    private String user_id; // 아이디
    private String user_pw; // 비밀번호
    private boolean useCookie; // 로그인 유지 여부
    private boolean saveCookie; // 아이디 저장 여부

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_pw() {
        return user_pw;
    }

    public void setUser_pw(String user_pw) {
        this.user_pw = user_pw;
    }

    public boolean isUseCookie() {
        return useCookie;
    }

    public void setUseCookie(boolean useCookie) {
        this.useCookie = useCookie;
    }

    public boolean isSaveCookie() {
        return saveCookie;
    }

    public void setSaveCookie(boolean saveCookie) {
        this.saveCookie = saveCookie;
    }
}