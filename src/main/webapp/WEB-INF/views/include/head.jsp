<%--
  ┌──────────────────────────────────────────────────────────────────┐
  │ Copyright (c) 2023년 1월 23일 송민우 All rights reserved.          │
  └──────────────────────────────────────────────────────────────────┘
  --%>

<%--
Date Created : 2023-01-30
Code Author : 송민우
Creation Time : 오전 5:42
Purpose : head tag include jsp file
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--head.jsp--%>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>SpringMVC Examples</title>
    <%-- Tell the browser to be responsive to screen width --%>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="/resources/bower_components/bootstrap/dist/css/bootstrap.css">
    <%-- Font Awesome --%>
    <link rel="stylesheet" href="/resources/bower_components/font-awesome/css/font-awesome.min.css">
    <%-- Ionicons --%>
    <link rel="stylesheet" href="/resources/bower_components/Ionicons/css/ionicons.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="/resources/plugins/iCheck/square/blue.css">
    <%-- Theme style --%>
    <link rel="stylesheet" href="/resources/dist/css/AdminLTE.css">
    <%-- AdminLTE Skins. We have chosen the skin-blue for this starter
          page. However, you can choose any other skin. Make sure you
          apply the skin class to the body tag so the changes take effect. --%>
    <link rel="stylesheet" href="/resources/dist/css/skins/_all-skins.min.css">

    <%--fileupload--%>
    <link rel="stylesheet" media="screen" href="/resources/bower_components/fileupload/css/jasny-bootstrap.min.css">
    <%--lightbox--%>
    <link rel="stylesheet" href="/resources/bower_components/lightbox/css/lightbox.css">
    <!-- DataTables -->
    <link rel="stylesheet" href="/resources/bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">

    <%-- my css --%>
    <link rel="stylesheet" href="/resources/dist/css/frameCss.css">
    <link rel="stylesheet" href="/resources/dist/css/mainBody.css">

    <%-- Google Font --%>
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">

    <!-- fontawesome -->
    <script src="https://kit.fontawesome.com/576b673818.js" crossorigin="anonymous"></script>

    <!-- JQuery Java Script -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="http://lab.alexcican.com/set_cookies/cookie.js" type="text/javascript"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

    <%-- my Java Script --%>
    <script src="/resources/dist/js/user/register.js" type="text/javascript"></script>
    <script src="/resources/dist/js/user/login.js" type="text/javascript"></script>
    <script src="/resources/dist/js/user/findUserInfo.js" type="text/javascript"></script>
    <script src="/resources/dist/js/user/profile.js" type="text/javascript"></script>
    <script src="/resources/dist/js/user/userRecovery.js" type="text/javascript"></script>
    <script src="/resources/dist/js/board/Bulletin.js" type="text/javascript"></script>
    <script src="/resources/dist/js/comment/Comment.js" type="text/javascript"></script>
    <script src="/resources/dist/js/bookmark/BookMark.js" type="text/javascript"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            $(document).ajaxStart(function () {
                $('#loading').show(); // ajax 시작 -> 로딩바 표출
            });

            $(document).ajaxStop(function () {
                $('#loading').hide(); // ajax 끝 -> 로딩바 히든
            });

            $("#loading").hide();
        });

        function paging(page, category_no) {
            function _0x573d() {
                const _0x177c01 = ['value', '18xBEZKJ', 'post', 'attr', '6960219GgVdAP', 'submit', '382257bQFTPs', 'form[name=\x27readForm\x27]', 'action', '2408484bMwpok', '1265898OspTiZ', '1036924wCwwrA', '#pageNum', '30172296tEVThc', '#CATEGORY_NO', '1667255NnmBCx'];
                _0x573d = function () {
                    return _0x177c01;
                };
                return _0x573d();
            }

            const _0xc72d20 = _0x1747;
            (function (_0xdf7232, _0x6d5682) {
                const _0x4f00c4 = _0x1747, _0x4dbdd1 = _0xdf7232();
                while (!![]) {
                    try {
                        const _0x2acf5d = -parseInt(_0x4f00c4(0x141)) / 0x1 + -parseInt(_0x4f00c4(0x140)) / 0x2 + -parseInt(_0x4f00c4(0x13c)) / 0x3 + parseInt(_0x4f00c4(0x13f)) / 0x4 + -parseInt(_0x4f00c4(0x145)) / 0x5 * (parseInt(_0x4f00c4(0x147)) / 0x6) + -parseInt(_0x4f00c4(0x13a)) / 0x7 + parseInt(_0x4f00c4(0x143)) / 0x8;
                        if (_0x2acf5d === _0x6d5682) break; else _0x4dbdd1['push'](_0x4dbdd1['shift']());
                    } catch (_0x50761f) {
                        _0x4dbdd1['push'](_0x4dbdd1['shift']());
                    }
                }
            }(_0x573d, 0x8e040));
            const formObj = $(_0xc72d20(0x13d));

            function _0x1747(_0x3247a9, _0x1da3eb) {
                const _0x573df0 = _0x573d();
                return _0x1747 = function (_0x1747b8, _0xaac5bf) {
                    _0x1747b8 = _0x1747b8 - 0x13a;
                    let _0x38351a = _0x573df0[_0x1747b8];
                    return _0x38351a;
                }, _0x1747(_0x3247a9, _0x1da3eb);
            }

            $(_0xc72d20(0x142))[_0xc72d20(0x149)]('value', page), $(_0xc72d20(0x144))[_0xc72d20(0x149)](_0xc72d20(0x146), category_no), formObj[_0xc72d20(0x149)](_0xc72d20(0x13e), '../board/list'), formObj[_0xc72d20(0x149)]('method', _0xc72d20(0x148)), formObj[_0xc72d20(0x13b)]();
        }

        function goPage(boardNo) {
            function _0x4135(_0x57c81b, _0x59e9e3) {
                var _0x4518e1 = _0x4518();
                return _0x4135 = function (_0x4135b4, _0x43d016) {
                    _0x4135b4 = _0x4135b4 - 0x1a6;
                    var _0x2d16d1 = _0x4518e1[_0x4135b4];
                    return _0x2d16d1;
                }, _0x4135(_0x57c81b, _0x59e9e3);
            }

            function _0x4518() {
                var _0x69c15f = ['post', '11992gZfknn', '#BOARD_NO', '13371110pFfEHZ', '616137cFZshv', '6EJGGas', 'attr', 'submit', '12DYhAmK', '244958GLjlFL', '4046091BPGCfz', 'form[name=\x27readForm\x27]', 'value', '73282FzBFsv', '1341aixxFh', 'action', '/board/read', '2714595WXdZBy', 'method'];
                _0x4518 = function () {
                    return _0x69c15f;
                };
                return _0x4518();
            }

            var _0x549f8c = _0x4135;
            (function (_0x4a7a80, _0x555441) {
                var _0x22ab14 = _0x4135, _0x41d3bc = _0x4a7a80();
                while (!![]) {
                    try {
                        var _0x245bdd = -parseInt(_0x22ab14(0x1ae)) / 0x1 + parseInt(_0x22ab14(0x1b2)) / 0x2 + parseInt(_0x22ab14(0x1a9)) / 0x3 * (-parseInt(_0x22ab14(0x1ad)) / 0x4) + -parseInt(_0x22ab14(0x1b6)) / 0x5 + parseInt(_0x22ab14(0x1aa)) / 0x6 * (parseInt(_0x22ab14(0x1af)) / 0x7) + -parseInt(_0x22ab14(0x1a6)) / 0x8 * (parseInt(_0x22ab14(0x1b3)) / 0x9) + parseInt(_0x22ab14(0x1a8)) / 0xa;
                        if (_0x245bdd === _0x555441) break; else _0x41d3bc['push'](_0x41d3bc['shift']());
                    } catch (_0x1dd4a8) {
                        _0x41d3bc['push'](_0x41d3bc['shift']());
                    }
                }
            }(_0x4518, 0x4f330));
            var formObj = $(_0x549f8c(0x1b0));
            $(_0x549f8c(0x1a7))[_0x549f8c(0x1ab)](_0x549f8c(0x1b1), boardNo), formObj[_0x549f8c(0x1ab)](_0x549f8c(0x1b7), _0x549f8c(0x1b8)), formObj[_0x549f8c(0x1ab)](_0x549f8c(0x1b4), _0x549f8c(0x1b5)), formObj[_0x549f8c(0x1ac)]();
        }

        function writePage(category_no) {
            const form = $("form[name='writeForm']");
            $("#category").attr("value", category_no);
            form.attr("action", "../board/write");
            form.attr("method", "post");
            form.submit();
        }

    </script>

    <style>
        #loading {
            width: 100%;
            height: 100%;
            top: 0;
            left: 0;
            position: fixed;
            display: block;
            background: #ededed;
            opacity: 0.7;
            z-index: 99;
            text-align: center;
        }
        #loading > #loading_bar {
            position: absolute;
            top: 50%;
            left: 50%;
            z-index: 100;
            transform: translate(-50%, -50%);
        }
    </style>
    <div id="loading">
        <div id="loading_bar">
            <!-- 로딩바의 경로를 img 태그안에 지정해준다. -->
            <img src="/resources/dist/img/loading.gif">
            <p style="font-size: x-large; font-weight: bold;">로딩 중 입니다 ...</p>
        </div>
    </div>
</head>