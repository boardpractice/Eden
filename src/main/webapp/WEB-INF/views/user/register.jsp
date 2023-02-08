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
<body class="hold-transition skin-green-light sidebar-mini register-page" oncopy="return false" oncut="return false"
      onpaste="return false">
<div id="loading" style="display: none; ">
    <div id="loading_bar">
        <!-- 로딩바의 경로를 img 태그안에 지정해준다. -->
        <img src="/dist/img/loading.gif">
        <p style="font-size: x-large; font-weight: bold;">로딩 중 입니다 ...</p>
    </div>
</div>
<div class="register-box">
    <div class="register-logo">
        <a href="${path}/">
            <b>EdenDEV</b><br/>
            SpringMVC-Examples
        </a>
    </div>

    <div class="register-box-body">
        <p class="login-box-msg">회원가입 페이지</p>

        <form:form action="${path}/user/insertUserProcess" modelAttribute="userVo" id="insertForm" method="post">
            <div class="row mt-2">
                <div class="col">
                    <div class="row mt-1">
                        <div class="col">
                            <label for="joinIdInput">아이디</label>
                        </div>
                    </div>

                    <div class="row mt-1">
                        <div class="col">
                            <form:input type="text" id="joinIdInput" class="form-control" path="user_id"
                                        placeholder="아이디를 입력하세요"/>
                        </div>
                    </div>

                    <div class="row mt-1">
                        <div class="col" id="alertId"><form:errors path="user_id" id="error_message"/></div>
                    </div>

                    <div class="row mt-1">
                        <div class="col">
                            <label for="changePassword">비밀번호</label>
                        </div>
                    </div>

                    <div class="row mt-1">
                        <div class="col">
                            <form:input type="password" id="changePassword" class="form-control"
                                        placeholder="비밀번호를 입력하세요" path="user_pw"/>
                        </div>
                    </div>

                    <div class="row mt-1">
                        <div class="col" id="alterPassword"><form:errors path="user_pw" id="error_message"/></div>
                    </div>

                    <div class="row mt-1">
                        <div class="col">
                            <label for="confirmPassword">비밀번호 확인</label>
                        </div>
                    </div>

                    <div class="row mt-1">
                        <div class="col">
                            <input type="password" id="confirmPassword" class="form-control"
                                   placeholder="비밀번호를 한번 더 입력해주세요">
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
                        <form:input type="text" id="userNickName" class="form-control" path="user_nickname"
                                    placeholder="닉네임을 입력해주세요"/>
                    </div>

                    <div class="row mt-1">
                        <div class="col" id="alertNickName"><form:errors path="user_nickname" id="error_message"/></div>
                    </div>

                    <div class="row mt-1">
                        <div class="col">
                            <label for="userGender">성별</label>
                        </div>
                    </div>

                    <div class="row mt-1">
                        <div class="col">
                            <form:radiobutton id="userGender" path="user_gender" value="M"/>남
                            <form:radiobutton id="userGender" path="user_gender" value="W"/>여
                        </div>
                    </div>

                    <div class="row mt-1">
                        <div class="col" id="alertGender"><form:errors path="user_gender" id="error_message"/></div>
                    </div>

                    <div class="row mt-1">
                        <div class="col">
                            <label for="userBirth">생년월일</label>
                        </div>
                    </div>

                    <div class="row mt-1">
                        <div class="col">
                            <form:input type="date" id="userBirth" class="form-control" path="user_birth"
                                        placeholder="생년월일을 선택해주세요"/>
                        </div>
                    </div>

                    <div class="row mt-1">
                        <div class="col" id="alertBirth"><form:errors path="user_birth"/></div>
                    </div>

                    <div class="row mt-1">
                        <div class="col">
                            <label for="userPhone">휴대폰번호</label>
                        </div>
                    </div>

                    <div class="row mt-1">
                        <div class="col">
                            <form:input type="text" id="userPhone" class="form-control" path="user_phone"
                                        placeholder="휴대폰번호를 입력해주세요"/>
                        </div>
                    </div>

                    <div class="row mt-1">
                        <div calss="col" id="alertPhone"><form:errors path="user_phone" id="error_message"/></div>
                    </div>

                    <div class="row mt-1">
                        <div class="col">
                            <label for="userEmail">이메일</label>
                        </div>
                    </div>

                    <div class="row mt-1">
                        <div class="col">
                            <form:input type="text" id="userEmail" class="form-control" path="user_email"
                                        placeholder="이메일주소를 입력해주세요"/>
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
                        <div class="col" id="alertEmail"><form:errors path="user_email" id="error_message"/></div>
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
                            <form:select path="question_no" class="form-select" id="userQuestion">
                                <c:forEach items="${data}" var="question">
                                    <form:option value="${question.question_no}">
                                        ${question.question_content}
                                    </form:option>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>

                    <div class="row mt-3">
                        <div class="col fs-5"><form:input class="form-control" id="userFindAnswer" path="user_findAnswer"
                                                          type="text" placeholder="비밀번호 찾기 정답을 입력해주세요" aria-label="default input example" />
                        </div>
                    </div>

                    <div class="row mt-3">
                        <div class="col my-auto"><form:errors path="user_findAnswer" id="error_message" /></div>
                    </div>

                    <div class="row mt-3">
                        <div class="col-7 bi bi-exclamation-square-fill orange" style="font-size : 10px;">
                            비밀번호 찾기 답변은 고객님의 비밀번호 분실시 이용됩니다. 신중하게 기입해주시기 바랍니다.
                        </div>
                    </div>

                    <div class="row mt-1">
                        <div class="col">
                            <a type="button" class="btn btn-default pull-left" href="../main/main">취소</a>
                            <button type="button" class="btn btn-primary infoModBtn pull-right" id="joinButton">가입하기
                            </button>
                        </div>
                    </div>
                </div>
            </div>
            <input type="hidden" id="user_image" name="user_image" value="default-user-image.jpg">
        </form:form>

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