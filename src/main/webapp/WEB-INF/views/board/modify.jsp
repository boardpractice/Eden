<%--
  ~ ┌───────────────────────────────────────────────────────────────────┐
  ~ │ Copyright (c) 2023년 2월 4일 Eden All rights reserved.             │
  ~ └───────────────────────────────────────────────────────────────────┘
  --%>

<%--
작성일시 : 2023-02-04
작성자 : Eden
작성시간 : 오후 10:31
용도 : Board Modify View Page
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
        <section class="content container-fluid">

            <div class="col-lg-12">
                <form role="form" id="modifyForm" method="post" action="${path}/board/modifyProcess">
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">게시글 수정</h3>
                        </div>
                        <div class="box-body">
                            <input type="hidden" name="board_no" value="${data.boardVo.board_no}">
                            <div class="form-group">
                                <label for="title">제목</label>
                                <input class="form-control" id="title" name="board_title" placeholder="제목을 입력해주세요"
                                       value="${data.boardVo.board_title}">
                            </div>
                            <div class="form-group">
                                <label for="content">내용</label>
                                <textarea class="form-control" id="content" name="board_content" rows="30"
                                          placeholder="내용을 입력해주세요" style="resize: none;">${data.boardVo.board_content}</textarea>
                            </div>
                            <div class="form-group">
                                <label for="writer">작성자</label>
                                <input class="form-control" id="writer" name="writer" value="${data.userVo.user_nickname}"
                                       readonly>
                            </div>
                        </div>
                        <div class="box-footer">
                            <button type="button" class="btn btn-primary"><i class="fa fa-list"></i> 목록</button>
                            <div class="pull-right">
                                <button type="button" class="btn btn-warning cancelBtn"><i class="fa fa-trash"></i> 취소
                                </button>
                                <button type="submit" class="btn btn-success crystalBtn"><i class="fa fa-save"></i> 수정 저장
                                </button>
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