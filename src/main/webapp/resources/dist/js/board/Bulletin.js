/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 2월 4일 Eden All rights reserved.             │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
작성일시 : 2023-02-04
작성자 : Eden
작성시간 : 오후 10:39
용도 : Bulletin related JavaScript
*/

window.addEventListener("DOMContentLoaded", function () {

    var formObj = $("form[role='form']");

    $(".listBtn").click(function () {
        self.location = "../board/list"
    });

    $(".modBtn").click(function () {
        formObj.attr("action", "../board/modify");
        formObj.attr("method", "post");
        formObj.submit();
    });

    $(".crystalBtn").click(function () {
        $("#modifyForm").submit();
    });

    $(".cancelBtn").click(function () {
        formObj.attr("action", "../board/read");
        formObj.attr("method", "post");
        formObj.submit();
    });

    $(".delBtn").click(function () {
        if (confirm("해당 게시글을 정말로 삭제 하시겠습니까??")) {
            formObj.attr("action", "../board/delete");
            formObj.attr("method", "post");
            formObj.submit();
        }
    })
});