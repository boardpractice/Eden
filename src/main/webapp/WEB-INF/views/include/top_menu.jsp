<%--
  ┌───────────────────────────────────────────────────────────────────┐
  │ Copyright (c) 2023년 1월 23일 송민우 All rights reserved.          │
  └───────────────────────────────────────────────────────────────────┘
  --%>

<%--
Date Created : 2023-01-30
Code Author : 송민우
Creation Time : 오전 5:42
Purpose : head tag include jsp file
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<header class="main-header">

    <a href="/" class="logo">
        <span class="logo-mini"><b>S</b>E</span>
        <span class="logo-lg"><b>Spring</b> - Examples</span>
    </a>

    <nav class="navbar navbar-static-top" role="navigation">
        <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
            <span class="sr-only">Toggle navigation</span>
        </a>
        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <c:choose>
                    <c:when test="${!empty sessionUser }">

                        <li class="dropdown messages-menu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-envelope-o"></i>
                                <span class="label label-success">4</span>
                            </a>
                            <ul class="dropdown-menu">
                                <li class="header">You have 4 messages</li>
                                <li>
                                    <ul class="menu">
                                        <li>
                                            <a href="#">
                                                <div class="pull-left">
                                                    <img src="/dist/img/${sessionUser.user_image}"
                                                         class="img-circle"
                                                         alt="User Image">
                                                </div>
                                                <h4>
                                                    Support Team
                                                    <small><i class="fa fa-clock-o"></i> 5 mins</small>
                                                </h4>
                                                <p>Why not buy a new awesome theme?</p>
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                                <li class="footer"><a href="#">See All Messages</a></li>
                            </ul>
                        </li>

                        <li class="dropdown notifications-menu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-bell-o"></i>
                                <span class="label label-warning">10</span>
                            </a>
                            <ul class="dropdown-menu">
                                <li class="header">You have 10 notifications</li>
                                <li>
                                    <ul class="menu">
                                        <li>
                                            <a href="#">
                                                <i class="fa fa-users text-aqua"></i> 5 new members joined today
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                                <li class="footer"><a href="#">View all</a></li>
                            </ul>
                        </li>
                        <li class="dropdown tasks-menu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-flag-o"></i>
                                <span class="label label-danger">9</span>
                            </a>
                            <ul class="dropdown-menu">
                                <li class="header">You have 9 tasks</li>
                                <li>
                                    <ul class="menu">
                                        <li>
                                            <a href="#">
                                                <h3>
                                                    Design some buttons
                                                    <small class="pull-right">20%</small>
                                                </h3>
                                                <div class="progress xs">
                                                    <div class="progress-bar progress-bar-aqua" style="width: 20%"
                                                         role="progressbar"
                                                         aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                                        <span class="sr-only">20% Complete</span>
                                                    </div>
                                                </div>
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                                <li class="footer">
                                    <a href="#">View all tasks</a>
                                </li>
                            </ul>
                        </li>
                        <li class="dropdown user user-menu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <img src="/dist/img/profile/${sessionUser.user_image}" class="user-image"
                                     alt="User Image">
                                <span class="hidden-xs">${sessionUser.user_nickname}</span>
                            </a>
                            <ul class="dropdown-menu">
                                <li class="user-header">
                                    <img src="/dist/img/profile/${sessionUser.user_image}" class="img-circle"
                                         alt="User Image">
                                    <p>
                                        <small>
                                            가입일자 : <fmt:formatDate value="${sessionUser.user_join_date}" pattern="yyyy-MM-dd"/>
                                        </small>
                                        <small>
                                            최근로그인일자 : <fmt:formatDate value="${sessionUser.user_last_connection_date}"
                                                                      pattern="yyyy-MM-dd a HH:mm"/>
                                        </small>
                                    </p>
                                </li>
                                <li class="user-body">
                                    <div class="row">
                                        <div class="col-xs-4 text-center">
                                            <a href="#">게시글</a>
                                        </div>
                                        <div class="col-xs-4 text-center">
                                            <a href="#">추천글</a>
                                        </div>
                                        <div class="col-xs-4 text-center">
                                            <a href="#">북마크</a>
                                        </div>
                                    </div>
                                </li>
                                <li class="user-footer">
                                    <div class="pull-left">
                                        <a href="${path}/user/profile" class="btn btn-primary btn-flat"><i
                                                class="fa fa-info-circle"></i><b> 내 프로필</b></a>
                                    </div>
                                    <div class="pull-right">
                                        <a type="button" id="logoutButton" class="btn btn-primary btn-flat"><i
                                                class="glyphicon glyphicon-log-out"></i><b> 로그아웃</b></a>
                                    </div>
                                </li>
                            </ul>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="dropdown user user-menu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <img src="../dist/img/default-user-image.jpg" class="user-image"
                                     alt="User Image">
                                <span class="hidden-xs">회원가입 또는 로그인</span>
                            </a>
                            <ul class="dropdown-menu">
                                <li class="user-header">
                                    <img src="../dist/img/default-user-image.jpg" class="img-circle"
                                         alt="User Image">
                                    <p>
                                        <b>회원가입 또는 로그인해주세요</b>
                                        <small></small>
                                    </p>
                                </li>
                                <li class="user-footer">
                                    <div class="pull-left">
                                        <a href="${path}/user/register" class="btn btn-primary btn-flat"><i
                                                class="fa fa-user-plus"></i><b> 회원가입</b></a>
                                    </div>
                                    <div class="pull-right">
                                        <a href="${path}/user/login" class="btn btn-primary btn-flat"><i
                                                class="glyphicon glyphicon-log-in"></i><b> 로그인</b></a>
                                    </div>
                                </li>
                            </ul>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </nav>
</header>