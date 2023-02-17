/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 2월 17일 송민우 All rights reserved.            │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
작성일시 : 2023-02-17
작성자 : Eden
작성시간 : 오전 7:24
용도 : 
*/

window.addEventListener("DOMContentLoaded", function () {

    let getMyBookMarkStatus = function () {
        $.ajax({
            type: "post",
            url: "../bookmark/getMyBookMarkStatus",
            data: {
                board_no: $("#boardNo").val()
            },
            dataType: "json",
            success: function (data) {
                if (data.status == 'bookMark') {
                    $(".boardBookmark").text("북마크 취소");
                    $(".boardBookmark").find("i").attr("class", "fa fa-bookmark-o");
                } else if (data.status == 'unBookMark') {
                    $(".boardBookmark").text("북마크");
                    $(".boardBookmark").find("i").attr("class", "fa fa-bookmark");
                }
            }
        });
    }

    const url = location.pathname;

    if (url.includes('read')) {
        getMyBookMarkStatus();
    }

    $(".boardBookmark").click(function () {
        $.ajax({
            type: "post",
            url: "../bookmark/doBookMark",
            data: {
                board_no: $("#boardNo").val()
            },
            dataType: "json",
            success: function (data) {
                if (data.status == 'unBookMark') {
                    alert("게시글 북마크에 성공 하였습니다.");
                    location.reload();
                } else if (data.status == 'bookMark') {
                    alert("게시글 북마크를 취소 하였습니다.");
                    location.reload();
                }
            }
        });
    });
});