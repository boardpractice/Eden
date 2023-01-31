<%--
  ~ ┌───────────────────────────────────────────────────────────────────┐
  ~ │ Copyright (c) 2023년 1월 31일 Eden All rights reserved.            │
  ~ └───────────────────────────────────────────────────────────────────┘
  --%>

<%--
작성일시 : 2023-01-31
작성자 : Eden
작성시간 : 오후 7:20
용도 : 
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../include/head.jsp" %>
<html>
<body class="hold-transition skin-blue-light sidebar-mini register-page" oncopy="return false" oncut="return false"
      onpaste="return false">
<div class="register-box">
    <div class="register-logo">
        <a href="${path}/">
            <b>EdenDEV</b><br/>
            SpringMVC-Examples
        </a>
    </div>

    <div class="register-box-body">
        <p class="login-box-msg">회원가입 페이지</p>

        <form action="${path}/user/insertUserProcess" id="insertForm" method="post">
            <div class="row mt-2">
                <div class="col">
                    <div class="row mt-1">
                        <div class="col">
                            <label for="joinIdInput">아이디</label>
                        </div>
                    </div>

                    <div class="row mt-1">
                        <div class="col">
                            <input type="text" id="joinIdInput" class="form-control" name="user_id" placeholder="아이디를 입력하세요">
                        </div>
                    </div>

                    <div class="row mt-1">
                        <div class="col" id="alertId"></div>
                    </div>

                    <div class="row mt-1">
                        <div class="col">
                            <label for="changePassword">비밀번호</label>
                        </div>
                    </div>

                    <div class="row mt-1">
                        <div class="col">
                            <input type="password" id="changePassword" class="form-control" placeholder="비밀번호를 입력하세요">
                        </div>
                    </div>

                    <div class="row mt-1">
                        <div class="col">
                            <div class="col" id="alterPassword"></div>
                        </div>
                    </div>

                    <div class="row mt-1">
                        <div class="col">
                            <label for="confirmPassword">비밀번호 확인</label>
                        </div>
                    </div>

                    <div class="row mt-1">
                        <div class="col">
                            <input type="password" id="confirmPassword" class="form-control" name="user_pw" placeholder="비밀번호를 한번 더 입력해주세요">
                        </div>
                    </div>

                    <div class="row mt-1">
                        <div class="col" id="alterPassword2"></div>
                    </div>

                    <div class="row mt-1">
                        <div class="col">
                            <label for="userNickName">닉네임</label>
                        </div>
                    </div>

                    <div class="row mt-1">
                        <input type="text" id="userNickName" class="form-control" name="user_nickname" placeholder="닉네임을 입력해주세요">
                    </div>

                    <div class="row mt-1">
                        <div class="col" id="alertNickName"></div>
                    </div>

                    <div class="row mt-1">
                        <div class="col">
                            <label for="userGender">성별</label>
                        </div>
                    </div>

                    <div class="row mt-1">
                        <div class="col">
                            <input type="radio" id="userGender" name="user_gender" value="M">남
                            <input type="radio" id="userGender" name="user_gender" value="Y">여
                        </div>
                    </div>

                    <div class="row mt-1">
                        <div class="col" id="alertGender"></div>
                    </div>

                    <div class="row mt-1">
                        <div class="col">
                            <label for="userBirth">생년월일</label>
                        </div>
                    </div>

                    <div class="row mt-1">
                        <div class="col">
                            <input type="date" id="userBirth" class="form-control" name="user_birth" placeholder="생년월일을 선택해주세요">
                        </div>
                    </div>

                    <div class="row mt-1">
                        <div class="col" id="alertBirth"></div>
                    </div>

                    <div class="row mt-1">
                        <div class="col">
                            <label for="userPhone">휴대폰번호</label>
                        </div>
                    </div>

                    <div class="row mt-1">
                        <div class="col">
                            <input type="text" id="userPhone" class="form-control" name="user_phone" placeholder="휴대폰번호를 입력해주세요">
                        </div>
                    </div>

                    <div class="row mt-1">
                        <div calss="col" id="alertPhone"></div>
                    </div>

                    <div class="row mt-1">
                        <div class="col">
                            <label for="userEmail">이메일</label>
                        </div>
                    </div>

                    <div class="row mt-1">
                        <div class="col">
                            <input type="text" id="userEmail" class="form-control" name="user_email" placeholder="이메일주소를 입력해주세요">
                        </div>
                    </div>

                    <div class="row mt-1">
                        <div class="col d-grid">
                            <button type="button" id="checkEmailButton"
                                    class="btn btn-primary" style="height:36px;" disabled='disabled'>인증번호 발송
                            </button>
                        </div>
                    </div>

                    <div class="row mt-1">
                        <div class="col" id="alertEmail"></div>
                    </div>

                    <div class="row mt-1">
                        <div class="col bi bi-exclamation-square-fill deepblue">
                            인증번호 발송은 서버 상황에따라 5초에서 10초정도 시간이 걸릴 수 있습니다.
                        </div>
                    </div>

                    <div class="row mt-1">
                        <div class="col">
                            <input class="form-control" id="checkEmail" type="text"
                                   placeholder="인증번호를 입력해주세요." aria-label="default input example"
                                   disabled="disabled">
                        </div>
                    </div>

                    <div class="row mt-1">
                        <div class="col" id="alertCertified"></div>
                    </div>

                    <div class="row mt-1">
                        <div class="col">
                            <a type="button" class="btn btn-default pull-left" href="../main/main">취소</a>
                            <button type="button" class="btn btn-primary infoModBtn pull-right" id="joinButton">가입하기</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>

        <div class="social-auth-links text-center">
            <p>- 또는 -</p>
            <a href="#" class="btn btn-block btn-social btn-facebook btn-flat">
                <i class="fa fa-facebook"></i> 페이스북으로 로그인
            </a>
            <a href="#" class="btn btn-block btn-social btn-google btn-flat">
                <i class="fa fa-google-plus"></i> 구글 계정으로 로그인
            </a>
        </div>
    </div>
    <!-- /.form-box -->
</div>
<!-- /.register-box -->

<%@ include file="../include/plugin_js.jsp" %>
</body>