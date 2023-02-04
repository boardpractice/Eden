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

    var getTotalLikeCount = function () {
        $.ajax({
            type: "post",
            url: "../board/getTotalLikeCount",
            data: {
                board_no: $("#boardNo").val()
            },
            dataType: "json",
            success: function (data) {
                $("#likeCount").text("좋아요 수(" + data.totalLikeCount + ")");
            }
        });
    }

    var getMyLikeStatus = function () {
        $.ajax({
            type: "post",
            url: "../board/getMyLikeStatus",
            data: {
                user_no: $("#userNo").val(),
                board_no: $("#boardNo").val()
            },
            dataType: "json",
            // contentType : "application/x-www-form-urlencoded", // post
            success: function (data) {
                if (data.result == 'error') {
                    console.log(data.reason);
                } else if (data.status == 'like') {
                    $(".boardLike").text("좋아요 취소");
                    $("#like").attr("class", "fa-solid fa-thumbs-up");
                } else if (data.status == 'unlike') {
                    $(".boardLike").text("좋아요");
                    $("#like").attr("class", "fa-regular fa-thumbs-up");
                }
            }
        });
    }

    const url = location.pathname;
    getTotalLikeCount();

    if (url.includes('read')) {
        getMyLikeStatus();
    }


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
    });

    $(".boardLike").click(function () {
        $.ajax({
            type: "post",
            url: "../board/doLike",
            data: {
                board_no: $("#boardNo").val(),
                user_no: $("userNo").val()
            },
            dataType: "json",
            success: function (data) {
                if (data.status == 'unlike') {
                    alert("게시글 좋아요를 완료 하였습니다.");
                    location.reload();
                } else {
                    alert("게시글 좋아요를 취소 하였습니다.");
                    location.reload();
                }
            }
        });
    });
});