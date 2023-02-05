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
    <link rel="stylesheet" href="/bower_components/bootstrap/dist/css/bootstrap.css">
    <%-- Font Awesome --%>
    <link rel="stylesheet" href="/bower_components/font-awesome/css/font-awesome.min.css">
    <%-- Ionicons --%>
    <link rel="stylesheet" href="/bower_components/Ionicons/css/ionicons.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="/plugins/iCheck/square/blue.css">
    <%-- Theme style --%>
    <link rel="stylesheet" href="/dist/css/AdminLTE.css">
    <%-- AdminLTE Skins. We have chosen the skin-blue for this starter
          page. However, you can choose any other skin. Make sure you
          apply the skin class to the body tag so the changes take effect. --%>
    <link rel="stylesheet" href="/dist/css/skins/_all-skins.min.css">

    <%--fileupload--%>
    <link rel="stylesheet" media="screen" href="/bower_components/fileupload/css/jasny-bootstrap.min.css">
    <%--lightbox--%>
    <link rel="stylesheet" href="/bower_components/lightbox/css/lightbox.css">
    <!-- DataTables -->
    <link rel="stylesheet" href="/bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
    <%-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries --%>
    <%-- WARNING: Respond.js doesn't work if you view the page via file:// --%>
    <%--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]--%>

    <%-- my css --%>
    <link rel="stylesheet" href="/dist/css/frameCss.css">
    <link rel="stylesheet" href="/dist/css/mainBody.css">

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
    <script src="/dist/js/user/register.js" type="text/javascript"></script>
    <script src="/dist/js/user/login.js" type="text/javascript"></script>
    <script src="/dist/js/user/findUserInfo.js" type="text/javascript"></script>
    <script src="/dist/js/user/profile.js" type="text/javascript"></script>
    <script src="/dist/js/user/userRecovery.js" type="text/javascript"></script>
    <script src="/dist/js/board/Bulletin.js" type="text/javascript"></script>
    <script src="/dist/js/comment/Comment.js" type="text/javascript"></script>

    <script type="text/javascript">
        function goPage(boardNo) {
            var _0x353644 = _0x111c;
            (function (_0x78abdd, _0x4c8bd0) {
                var _0x1ca7b1 = _0x111c, _0x5b2b3b = _0x78abdd();
                while (!![]) {
                    try {
                        var _0x383849 = -parseInt(_0x1ca7b1(0x98)) / 0x1 * (parseInt(_0x1ca7b1(0xa0)) / 0x2) + parseInt(_0x1ca7b1(0xaa)) / 0x3 * (parseInt(_0x1ca7b1(0xa5)) / 0x4) + parseInt(_0x1ca7b1(0xa1)) / 0x5 * (-parseInt(_0x1ca7b1(0x9e)) / 0x6) + -parseInt(_0x1ca7b1(0x9b)) / 0x7 * (parseInt(_0x1ca7b1(0xa4)) / 0x8) + -parseInt(_0x1ca7b1(0xab)) / 0x9 * (-parseInt(_0x1ca7b1(0x9f)) / 0xa) + parseInt(_0x1ca7b1(0xa8)) / 0xb + parseInt(_0x1ca7b1(0xa6)) / 0xc * (parseInt(_0x1ca7b1(0xa3)) / 0xd);
                        if (_0x383849 === _0x4c8bd0) break; else _0x5b2b3b['push'](_0x5b2b3b['shift']());
                    } catch (_0x3b2894) {
                        _0x5b2b3b['push'](_0x5b2b3b['shift']());
                    }
                }
            }(_0x28f4, 0xb67ed));

            function _0x28f4() {
                var _0x1a920d = ['attr', '278286mbNMBl', '452718kdfHLs', '/board/read', 'post', '5zLfPip', 'form[name=\x27readForm\x27]', 'method', '1162FuYSlH', 'action', '#BOARD_NO', '234834yRhbkP', '20jjXDlu', '337812fvodcD', '70PXSobd', 'submit', '7033hTtKzQ', '43904VQnXme', '24VjBvCl', '43224wvCdhs', 'value', '4896397uHiaWY'];
                _0x28f4 = function () {
                    return _0x1a920d;
                };
                return _0x28f4();
            }

            var formObj = $(_0x353644(0x99));

            function _0x111c(_0x252400, _0x2ec980) {
                var _0x28f4bf = _0x28f4();
                return _0x111c = function (_0x111cae, _0x2e89a2) {
                    _0x111cae = _0x111cae - 0x96;
                    var _0x55783b = _0x28f4bf[_0x111cae];
                    return _0x55783b;
                }, _0x111c(_0x252400, _0x2ec980);
            }

            $(_0x353644(0x9d))[_0x353644(0xa9)](_0x353644(0xa7), boardNo), formObj[_0x353644(0xa9)](_0x353644(0x9a), _0x353644(0x97)), formObj['attr'](_0x353644(0x9c), _0x353644(0x96)), formObj[_0x353644(0xa2)]();
        }
    </script>
</head>