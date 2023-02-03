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
import org.springframework.web.util.WebUtils;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
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
    public HashMap<String, Object> userLoginProcess(LoginDTO loginDto, HttpSession session, HttpServletResponse response, HttpServletRequest request) {

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
                if (loginDto.isUseCookie()) { // 로그인 유지 체크시
                    // 로그인 유지 유효기간 : 일주일
                    int amount = 60 * 60 * 24 * 7;
                    // 로그인 유지 유효 일자
                    Date sessionLimit = new Date(System.currentTimeMillis() + (1000 * amount));
                    // 로그인 유지 기간 갱신(아이디, 세션아이디, 유효일자)
                    userService.keepLogin(sessionUser.getUser_id(), session.getId(), sessionLimit);

                    // 로그인 쿠키 객체 생성
                    Cookie loginCookie = new Cookie("loginCookie", session.getId());
                    // 모든 경로에서 접근 가능하게 처리
                    loginCookie.setPath("/");
                    // 쿠키 유효 기간
                    loginCookie.setMaxAge(60 * 60 * 24 * 7);
                    // 쿠키 저장
                    response.addCookie(loginCookie);
                }

                /* 아이디 저장 */
                if (loginDto.isSaveCookie()) {
                    // 아이디 저장 유효기간 : 30일
                    int amount = 60 * 60 * 24 * 30;
                    // 아이디저장 쿠키 객체 생성
                    Cookie saveIdCooke = new Cookie("setCookieYN", "Y");
                    Cookie userInputId = new Cookie("userInputId", loginDto.getUser_id());
                    // 모든 경로에서 접근 가능하게 처리
                    saveIdCooke.setPath("/");
                    userInputId.setPath("/");
                    // 쿠키 유효 기간
                    saveIdCooke.setMaxAge(amount);
                    userInputId.setMaxAge(amount);
                    // 쿠키 저장
                    response.addCookie(saveIdCooke);
                    response.addCookie(userInputId);
                } else {
                    Cookie saveCookie = WebUtils.getCookie(request, "setCookieYN");
                    Cookie userInputId = WebUtils.getCookie(request, "userInputId");
                    if (saveCookie != null && userInputId != null) {
                        saveCookie.setPath("/");
                        userInputId.setPath("/");
                        // 쿠키 유효기간 0
                        saveCookie.setMaxAge(0);
                        userInputId.setMaxAge(0);
                        // 쿠키 저장
                        response.addCookie(saveCookie);
                        response.addCookie(userInputId);
                    }
                }
                Object destination = session.getAttribute("destination");
                // 삼항 연산자로 이전페이지가 존재하지 않으면 메인페이지로 이동
                if (destination != null) {
                    data.put("destination", destination);
                } else {
                    data.put("destination", request.getContextPath() + "/");
                }
            }
        }
        return data;
    }

    //  유저로그아웃
    @PostMapping(value = "userLogoutProcess")
    @LogException
    public HashMap<String, Object> userLogoutProcess(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        HashMap<String, Object> data = new HashMap<>();
        UserVo sessionUser = (UserVo) session.getAttribute("sessionUser");

        Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
        if (loginCookie != null) {
            loginCookie.setPath("/");
            // 쿠키 유효기간 0
            loginCookie.setMaxAge(0);
            // 쿠키 저장
            response.addCookie(loginCookie);
            // 로그인 유지 갱신
            userService.keepLogin(sessionUser.getUser_id(), "none", new Date());
        }

        session.removeAttribute("sessionUser");
        session.invalidate();
        return data;
    }

    //  아이디 찾기
    @PostMapping("getUserIdByNickNameAndEmail")
    public HashMap<String, Object> getUserIdByNickNameAndEmail(UserVo param) {

        HashMap<String, Object> data = new HashMap<>();

        HashMap<String, Object> userInfo = userService.getUserIdByNickNameAndEmail(param);

        if (userInfo == null) {
            data.put("result", "fail");
        } else {
            data.put("result", "success");
            data.put("userInfo", userInfo);
        }

        return data;
    }

    //  비밀번호 찾기 질문 조회
    @PostMapping(value = "getUserQuestionById")
    @LogException
    public HashMap<String, Object> getUserQuestionById(UserVo param) {

        HashMap<String, Object> data = new HashMap<>();

        HashMap<String, Object> userInfo = userService.getUserQuestionById(param);

        if (userInfo == null) {
            data.put("result", "fail");
        } else {
            data.put("userInfo", userInfo);
        }

        return data;
    }

    //  비밀번호 질문 답변 조회
    @PostMapping(value = "getUserPwByfindAnswer")
    @LogException
    public HashMap<String, Object> getUserPwByfindAnswer(UserVo param) {
        HashMap<String, Object> data = new HashMap<>();
        UserVo userInfo = userService.getUserPwByfindAnswer(param);

        if (userInfo == null) {
            data.put("result", "fail");
        } else {
            data.put("result", "success");
        }
        return data;
    }

    //  비밀번호 찾기 - 수정
    @PostMapping("getUserUpdatePw")
    @LogException
    public HashMap<String, Object> getUserUpdatePw(UserVo param) {

        HashMap<String, Object> data = new HashMap<String, Object>();
        boolean exist = userService.isExistId(param.getUser_id());
        if (exist) {
            data.put("result", "success");
            String password = BCrypt.hashpw(param.getUser_pw(), BCrypt.gensalt());
            param.setUser_pw(password);
            userService.getUserUpdatePw(param);
        } else {
            data.put("result", "fail");
        }
        return data;
    }

    //  회원정보 수정
    @PostMapping("updateUserInfo")
    public HashMap<String, Object> updateUserInfo(UserVo param, HttpSession session) {

        HashMap<String, Object> data = new HashMap<String, Object>();

        UserVo sessionUser = userService.getUser(param.getUser_id());

        if (sessionUser != null) {
            data.put("result", "success");
            userService.updateUserInfo(param);
        } else {
            data.put("result", "fail");
        }
        return data;
    }

    //  현재 비밀번호 체크
    @PostMapping("checkPw")
    @LogException
    public HashMap<String, Object> checkPw(String current_password, String user_id) {

        HashMap<String, Object> data = new HashMap<>();

        UserVo userVo = userService.getUser(user_id);

        if (userVo != null) {
            if (BCrypt.checkpw(current_password, userVo.getUser_pw())) {
                data.put("result", "success");
            } else {
                data.put("result", "fail");
            }
        }

        return data;
    }

    //  비밀번호 수정
    @PostMapping(value = "modifyPassword")
    @LogException
    public HashMap<String, Object> modifyPassword(UserVo userVo, HttpSession session) {

        HashMap<String, Object> data = new HashMap<>();

        UserVo sessionUser = userService.getUser(userVo.getUser_id());

        if (sessionUser != null) {

            /* 비밀번호 변경 */
            String changePassword = BCrypt.hashpw(userVo.getUser_pw(), BCrypt.gensalt());
            sessionUser.setUser_pw(changePassword);
            userService.getUserUpdatePw(sessionUser);

            /* 비밀번호 변경후 로그아웃 */
            session.invalidate();
        }

        return data;
    }

    //  회원탈퇴
    @PostMapping(value = "deleteUserInfoByUserNo")
    public HashMap<String, Object> deleteUserInfoByUserNo(UserVo vo, HttpSession session, HttpServletRequest request, HttpServletResponse response) {

        HashMap<String, Object> data = new HashMap<String, Object>();

        UserVo sessionUser = (UserVo) session.getAttribute("sessionUser");
        String password = vo.getUser_pw();

        if (!BCrypt.checkpw(vo.getUser_pw(), sessionUser.getUser_pw())) {
            data.put("result", "fail");
        } else {
            data.put("result", "success");

            Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
            if (loginCookie != null) {
                loginCookie.setPath("/");
                // 쿠키 유효기간 0
                loginCookie.setMaxAge(0);
                // 쿠키 저장
                response.addCookie(loginCookie);
                // 로그인 유지 갱신
                userService.keepLogin(sessionUser.getUser_id(), "none", new Date());
            }
            userService.deleteUserInfoByUserNo(sessionUser);
            session.invalidate();
        }
        return data;
    }
}
