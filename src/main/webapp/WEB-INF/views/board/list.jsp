<%--
  ~ ┌───────────────────────────────────────────────────────────────────┐
  ~ │ Copyright (c) 2023년 2월 3일 Eden All rights reserved.             │
  ~ └───────────────────────────────────────────────────────────────────┘
  --%>

<%--
작성일시 : 2023-02-03
작성자 : Eden
작성시간 : 오후 8:42
용도 : 
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../include/head.jsp" %>
<html>
<body class="hold-transition sidebar-mini" oncopy="return false" oncut="return false" onpaste="return false">
<div class="wrapper">

    <%@ include file="../include/top_menu.jsp" %>

    <%@ include file="../include/left_menu.jsp" %>

    <div class="content-wrapper">
        <section class="content container-fluid">
            <div class="box-header with-border">
                <form action="../board/list" method="get">
                    <div class="row mt-3">
                        <div class="col">
                            <select name ="category" class="form-select">
                                <option value="title">제목</option>
                                <option value="content">내용</option>
                                <option value="nick">닉네임</option>
                            </select>
                        </div>
                        <div class="col-8">
                            <input type="text" name="keyword" class="form-control" placeholder="검색할 단어를 입력하세요">
                        </div>
                        <div class="col d-grid">
                            <input type="submit" value="검색" class="btn btn-primary">
                        </div>
                    </div>
                </form>
            </div>
            <div class="box-body">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th scope="col">글 번호</th>
                        <th scope="col">제목</th>
                        <th scope="col">작성자</th>
                        <th scope="col">작성일</th>
                        <th scope="col">조회수</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${dataList }" var="data">
                        <tr>
                            <td class="text-center">${data.boardVo.board_no}</td>
                            <td class="text-center">${data.boardVo.board_title}</td>
                            <td class="text-center">${data.userVo.user_nickname}</td>
                            <td class="text-center">${data.boardTime}</td>
                            <td class="text-center">${data.boardVo.board_readcount}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

            </div>
            <div class="box-footer">
                <div class="pull-right">
                    <a class="btn btn-success btn-flat" href="../board/write">
                        <i class="fa fa-pencil"></i> 글쓰기
                    </a>
                </div>
            </div>
        </section>
    </div>

    <%@ include file="../include/footer.jsp" %>

</div>

<%@ include file="../include/plugin_js.jsp" %>
</body>