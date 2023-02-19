<%--
  ~ ┌───────────────────────────────────────────────────────────────────┐
  ~ │ Copyright (c) 2023년 2월 3일 Eden All rights reserved.             │
  ~ └───────────────────────────────────────────────────────────────────┘
  --%>

<%--
작성일시 : 2023-02-19
작성자 : Eden
작성시간 : 오후 7:00
용도 : Qna List View Page
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../include/head.jsp" %>
<html>
<body class="hold-transition skin-green-light sidebar-mini" oncopy="return false" oncut="return false"
      onpaste="return false">

<div class="wrapper">

    <%@ include file="../include/top_menu.jsp" %>

    <%@ include file="../include/left_menu.jsp" %>

    <div class="content-wrapper">
        <form name="readForm" role="form" method="post">
            <input type="hidden" id="BOARD_NO" name="board_no" value="">
            <input type="hidden" id="CATEGORY_NO" name="category_no" value="">
            <input type="hidden" id="pageNum" name="pageNum" value="">
        </form>
        <form name="writeForm" role="form" method="post">
            <input type="hidden" id="category" name="category_no" value="">
        </form>
        <section class="content container-fluid">
            <div class="box-header with-border">
                <form action="../qna/list" method="post">
                    <div class="row mt-3">
                        <div class="col-2">
                            <select name="searchType" class="form-control">
                                <option value="title">제목</option>
                                <option value="content">내용</option>
                                <option value="nick">닉네임</option>
                            </select>
                        </div>
                        <div class="col-8">
                            <input type="text" name="searchWord" class="form-control" placeholder="검색할 단어를 입력하세요">
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
                        <th class="col-xs-2">번호</th>
                        <th class="col-xs-4">제목</th>
                        <th class="col-xs-2">작성자</th>
                        <th class="col-xs-2">작성일자</th>
                        <th class="col-xs-2">조회수</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${dataList }" var="data">
                        <tr>
                            <td>${data.qnaVo.qna_no}</td>
                            <td>
                                <c:forEach var="i" begin="1" end="${data.qnaVo.indent }">
                                    ${i eq data.qnaVo.indent ? "<img src='img/re.gif' />" : "&nbsp;&nbsp;" }
                                </c:forEach>
                                <a href="../qna/detail?qna_no=${data.qnaVo.qna_no }">${data.qnaVo.title }</a>
                            </td>
                            <td>${data.userVo.user_nickname}</td>
                            <td><fmt:formatDate value="${data.qnaVo.qna_write_date }"
                                                pattern="yyyy:MM:dd: HH:mm:ss"/></td>
                            <td><span class="badge bg-red">${data.qnaVo.qna_read_count}</span></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

            <div class="box-footer">
                <div class="pull-right">
                    <a class="btn btn-success btn-flat" href="javascript:writeQna();">
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