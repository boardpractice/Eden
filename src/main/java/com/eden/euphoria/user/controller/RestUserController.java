/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 1월 31일 Eden All rights reserved.            │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
작성일시 : 2023-01-31
작성자 : Eden
작성시간 : 오후 7:58
용도 : user web page data Json conversion requests Handling
*/

package com.eden.euphoria.user.controller;

import com.eden.euphoria.commons.annotation.LogException;
import com.eden.euphoria.user.dto.LoginDTO;
import com.eden.euphoria.user.dto.UserVo;
import com.eden.euphoria.user.service.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Random;

@RestController
@RequestMapping(value = "/user/*")
public class RestUserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JavaMailSender javaMailSender;

    //  아이디 중복 체크
    @PostMapping(value = "isExistId")
    @LogException
    public HashMap<String, Object> isExistId(String user_id) {

        HashMap<String, Object> data = new HashMap<String, Object>();

        boolean exist = userService.isExistId(user_id);

        if (exist) {
            data.put("result", "fail");
        } else {
            data.put("result", "success");
        }

        return data;
    }

    //  닉네임 중복 체크
    @PostMapping(value = "isExistNickName")
    public HashMap<String, Object> isExistNickName(String user_nickname) {

        HashMap<String, Object> data = new HashMap<String, Object>();

        boolean exist = userService.isExistNickName(user_nickname);

        if (exist) {
            data.put("result", "fail");
        } else {
            data.put("result", "success");
        }
        return data;
    }

    //  휴대폰번호 중복 체크
    @PostMapping(value = "isExistPhone")
    public HashMap<String, Object> isExistPhone(String user_phone) {

        HashMap<String, Object> data = new HashMap<String, Object>();

        boolean exist = userService.isExistPhone(user_phone);

        if (exist) {
            data.put("result", "fail");
        } else {
            data.put("result", "success");
        }

        return data;
    }

    //  이메일 중복 체크
    @PostMapping(value = "isExistEmail")
    public HashMap<String, Object> isExistEmail(String user_email) {

        HashMap<String, Object> data = new HashMap<String, Object>();

        boolean exist = userService.isExistEmail(user_email);

        if (exist) {
            data.put("result", "fail");
        } else {
            data.put("result", "success");
        }

        return data;
    }

    //  이메일 유효성 검사
    @PostMapping(value = "checkEmail")
    public HashMap<String, Object> checkEmail(String user_email) {

        HashMap<String, Object> data = new HashMap<String, Object>();

        Random random = new Random();
        int checkNum = random.nextInt(888888) + 111111;

        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

            messageHelper.setFrom("hanbyeols333z@gmail.com", "관리자"); // 보내는사람 이메일 여기선 google 메일서버 사용하는 아이디를 작성하면됨
            messageHelper.setTo(user_email); // 받는사람 이메일
            messageHelper.setSubject("회원가입 인증메일입니다."); // 메일제목
            messageHelper.setText("홈페이지를 방문해주셔서 감사합니다." +
                    "인증 번호는 " + checkNum + " 입니다." +
                    "\r\n" +
                    "해당 인증번호를 인증번호 확인란에 기입하여 주세요."); // 메일 내용

            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }

        data.put("code", checkNum);

        return data;
    }

    //  유저로그인
    @PostMapping(value = "userLoginProcess")
    @LogException
    public HashMap<String, Object> userLoginProcess(LoginDTO loginDto, HttpSession session, HttpServletResponse response) {

        HashMap<String, Object> data = new HashMap<String, Object>();

        UserVo sessionUser = userService.selectByIdAndPw(loginDto);

        if (sessionUser != null) {
            String state = sessionUser.getUser_status();
            if (state.equals("Inactive")) {
                data.put("result", "out");
            } else if (!BCrypt.checkpw(loginDto.getUser_pw(), sessionUser.getUser_pw())) {
                data.put("result", "fail");
            } else {
                data.put("result", "success");
                session.setAttribute("sessionUser", sessionUser);
            }
        }
        return data;
    }

    //  유저로그아웃
    @PostMapping(value = "userLogoutProcess")
    @LogException
    public HashMap<String, Object> userLogoutProcess(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        HashMap<String, Object> data = new HashMap<>();
        session.removeAttribute("sessionUser");
        session.invalidate();
        return data;
    }
}
