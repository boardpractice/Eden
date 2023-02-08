<%--
  ┌───────────────────────────────────────────────────────────────────┐
  │ Copyright (c) 2023년 1월 23일 송민우 All rights reserved.           │
  └───────────────────────────────────────────────────────────────────┘
  --%>

<%--
Date Created : 2023-01-30
Code Author : 송민우
Creation Time : 오전 5:42
Purpose : head tag include jsp file
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--left_column.jsp--%>
<%-- Left side column. contains the logo and sidebar --%>
<aside class="main-sidebar">

    <%-- sidebar: style can be found in sidebar.less --%>
    <section class="sidebar">

        <div class="user-panel">
            <c:choose>
                <c:when test="${empty sessionUser}">
                    <div class="pull-left image">
                        <img src="../dist/img/default-user-image.jpg" class="img-circle" alt="User Image">
                    </div>

                    <div class="pull-left info">
                        <p>Guest</p>
                        <a href="#"><i class="fa fa-circle text-danger"></i>OFFLINE</a>
                    </div>
                </c:when>

                <c:otherwise>
                    <div class="pull-left image">
                        <img src="/dist/img/profile/${sessionUser.user_image}" class="img-circle" alt="User Image">
                    </div>

                    <div class="pull-left info">
                        <p>${sessionUser.user_nickname}</p>

                        <a href="#"><i class="fa fa-circle text-success"></i>ONLINE</a>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>

        <%-- search form (Optional) --%>
        <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
                <input type="text" name="q" class="form-control" placeholder="게시글 검색">
                <span class="input-group-btn">
              <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
              </button>
            </span>
            </div>
        </form>
        <%-- /.search form --%>

        <%-- Sidebar Menu --%>
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">메뉴</li>
            <%-- Optionally, you can add icons to the links --%>
            <li class="treeview active">
                <a href="#">
                    <i class="fa fa-clipboard"></i>
                    <span>게시판</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${path}/board/list"> <i class="fa-thin fa-user-magnifying-glass"></i><span>자유게시판</span></a></li>
                </ul>
            </li>

            <li class="treeview">
                <a href="#">
                    <i class="fa-solid fa-user"></i>
                    <span>계정관리</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="#" onclick="SearchId();"> <i class="fa-thin fa-user-magnifying-glass"></i><span>ID 찾기</span></a></li>
                    <li><a href="#" onclick="SearchPw();"> <i class="fa-thin fa-user-magnifying-glass"></i><span>PW 찾기</span></a></li>
                    <c:if test="${!empty sessionUser}">
                        <li><a href="${path}/user/profile">내 프로필</a></li>
                    </c:if>
                </ul>
            </li>
        </ul>
        <%-- /.sidebar-menu --%>
    </section>
    <%-- /.sidebar --%>
</aside>