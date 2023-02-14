<%--
  ~ ┌───────────────────────────────────────────────────────────────────┐
  ~ │ Copyright (c) 2023년 2월 3일 Eden All rights reserved.             │
  ~ └───────────────────────────────────────────────────────────────────┘
  --%>

<%--
작성일시 : 2023-02-03
작성자 : Eden
작성시간 : 오후 8:42
용도 : board list web view page
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
        <section class="content container-fluid">
            <div class="box-header with-border">
                <form action="../board/list" method="post">
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
                        <input type="hidden" id="categoryNo" name="category_no" value="${category_no}">
                    </div>
                </form>
            </div>
            <div class="box-body">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th scope="col">글 번호</th>
                        <th scope="col">카테고리</th>
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
                            <td class="text-center">${data.categoryVo.category_name}</td>
                            <td class="text-center"><a
                                    href="javascript:goPage(${data.boardVo.board_no});">${data.boardVo.board_title }</a>
                            </td>
                            <td class="text-center">${data.userVo.user_nickname}</td>
                            <td class="text-center">${data.boardTime}</td>
                            <td class="text-center">${data.boardVo.board_readcount}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

            </div>
            <div class="box-footer">
                <div class="col" align="center"><!-- 페이징...UI -->
                    <nav aria-label="Page navigation example">
                        <ul class="pagination">
                            <c:choose>
                                <c:when test="${startPage <= 1}">
                                    <li class="page-item disabled"><a class="page-link" href="#">&lt;</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li class="page-item"><a class="page-link"
                                                             href="javascript:paging('${startPage - 1}', '${category_no}');">&lt;</a>
                                    </li>
                                </c:otherwise>
                            </c:choose>


                            <c:forEach begin="${startPage }" end="${endPage }" var="i">
                                <c:choose>
                                    <c:when test="${i == currentPageNum }">
                                        <li class="page-item active"><a class="page-link"
                                                                        href="javascript:paging('${i}', '${category_no}');">${i}</a>
                                        </li>
                                    </c:when>
                                    <c:otherwise>
                                        <li class="page-item"><a class="page-link"
                                                                 href="javascript:paging('${i}', ${category_no});">${i}</a>
                                        </li>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                            <c:choose>
                                <c:when test="${endPage >= totalPageCount}">
                                    <li class="page-item disabled"><a class="page-link">&gt;</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li class="page-item"><a class="page-link"
                                                             href="javascript:paging('${endPage + 1}', '${category_no}');">&gt;</a>
                                    </li>
                                </c:otherwise>
                            </c:choose>
                        </ul>
                    </nav>
                </div>
            </div>
            <div class="box-footer">
                <div class="pull-right">
                    <a class="btn btn-success btn-flat" href="../board/write&category_no=${category_no}">
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