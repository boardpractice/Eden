<%--
  ~ ┌───────────────────────────────────────────────────────────────────┐
  ~ │ Copyright (c) 2023년 2월 4일 Eden All rights reserved.             │
  ~ └───────────────────────────────────────────────────────────────────┘
  --%>

<%--
작성일시 : 2023-02-04
작성자 : Eden
작성시간 : 오전 12:36
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

            <div class="col-lg-12">
                <form role="form" id="regForm" method="post" action="${path}/board/writeProcess">
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">게시글 작성</h3>
                        </div>
                        <div class="box-body">
                            <div class="form-group">
                                <label for="title">제목</label>
                                <input class="form-control" id="title" name="board_title" placeholder="제목을 입력해주세요">
                            </div>
                            <div class="form-group">
                                <label for="board_content">내용</label>
                                <textarea class="form-control" id="board_content" name="board_content" rows="30"
                                          placeholder="내용을 입력해주세요" style="resize: none;"></textarea>
                            </div>
                            <div class="form-group">
                                <label for="writer">작성자</label>
                                <input class="form-control" id="writer" value="${sessionUser.user_nickname}" readonly>
                            </div>
                        </div>

                        <div class="box-footer">
                            <div class="pull-right">
                                <a href="../board/list" class="btn btn-primary"><i class="fa fa-list"></i> 목록</a>
                                <button type="reset" class="btn btn-warning"><i class="fa fa-reply"></i> 초기화</button>
                                <button type="submit" class="btn btn-success"><i class="fa fa-save"></i> 저장</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </section>
    </div>

    <%@ include file="../include/footer.jsp" %>

</div>

<%@ include file="../include/plugin_js.jsp" %>
</body>