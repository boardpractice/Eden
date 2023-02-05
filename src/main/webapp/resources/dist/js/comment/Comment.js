/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 2월 5일 송민우 All rights reserved.            │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
작성일시 : 2023-02-05
작성자 : Eden
작성시간 : 오후 3:42
용도 : Comment related JavaScript
*/

window.addEventListener("DOMContentLoaded", function () {

    var printReplyCount = function (totalCount) {
        var commentCount = $(".commentCount");
        var collapsedBox = $(".collapsed-box");

        if (totalCount <= 0) {
            commentCount.html(" 댓글이 없습니다. 의견을 남겨주세요");
            collapsedBox.find(".btn-box-tool").remove();
            return;
        }
        commentCount.html(" 댓글목록 (" + totalCount + ")");
        collapsedBox.find(".box-tools").html(
            "<button type='button' class='btn btn-box-tool' data-widget='collapse'>"
            + "<i class='fa fa-plus'></i>"
            + "</button>"
        );
    };


    var commentList = function () {
        $.ajax({
            type: "post",
            url: "../comment/getCommentList",
            data: {
                board_no: $("#boardNo").val()
            },
            dataType: "json",
            success: function (data) {
                printReplyCount(data.totalCommentCount);
                for (commentData of data.commentInfo) {
                    $("#comment_write").text(commentData.userVo.user_nickname);
                    $("#writeTime").css({
                        "color": "#c0c0c0",
                        "font-size": "10px"
                    });
                    $("#writeTime").text(commentData.write_time);
                    $(".oldReplytext").text(commentData.commentVo.comment_content);
                }
            }
        });
    }

    commentList();


    var showCommentList = function () {
        $(".commentDiv").html("");
        $(".commentDiv").append(
            '<div class="user-block">' +
            '<img src="../dist/img/default-user-image.jpg" class="img-circle" alt="User Image">' +
            '<span class="username">' +
            '<a href="#" id="comment_write"></a>' +
            '<a href="#" class="pull-right btn-box-tool replyDelBtn" data-toggle="modal" data-target="#delModal">\n' +
            '                    <i class="fa fa-times"> 삭제</i>\n' +
            '                </a>' +
            '<a href="#" class="pull-right btn-box-tool replyModBtn" data-toggle="modal" data-target="#modModal">\n' +
            '                    <i class="fa fa-edit"> 수정</i>\n' +
            '                </a>' +
            '</span>' +
            '<span class="description" id="writeTime"></span>' +
            '</div>' +
            '<div class="oldReplytext"></div>' +
            '<br/>' +
            '<ul class="list-inline">' +
            '<li>' +
            '<a href="#" class="link-black text-sm replyLike">\n' +
            '                    <i class="fa fa-thumbs-o-up"></i> 추천<span></span>\n' +
            '                </a>' +
            '</li>' +
            '</ul>' +
            '</div>'
        );
    };
    showCommentList();
});