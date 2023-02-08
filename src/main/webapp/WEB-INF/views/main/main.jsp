<%--
  ~ ┌───────────────────────────────────────────────────────────────────┐
  ~ │ Copyright (c) 2023년 1월 30일 송민우 All rights reserved.          │
  ~ └───────────────────────────────────────────────────────────────────┘
  --%>

<%--
Date Created : 2023-01-30
Code Author : 송민우
Creation Time : 오전 5:44
Purpose : Main Web View Page
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../include/head.jsp" %>
<html>
<body class="hold-transition skin-green-light sidebar-mini" oncopy="return false" oncut="return false" onpaste="return false">
<div id="loading" style="display: none; ">
    <div id="loading_bar">
        <!-- 로딩바의 경로를 img 태그안에 지정해준다. -->
        <img src="/dist/img/loading.gif">
        <p style="font-size: x-large; font-weight: bold;">로딩 중 입니다 ...</p>
    </div>
</div>
<div class="wrapper">

    <%@ include file="../include/top_menu.jsp" %>

    <%@ include file="../include/left_menu.jsp" %>

    <div class="content-wrapper">

    </div>

    <%@ include file="../include/footer.jsp" %>

</div>

<%@ include file="../include/plugin_js.jsp" %>
</body>
</html>