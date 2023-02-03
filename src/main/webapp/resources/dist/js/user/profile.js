/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 2월 2일 Eden All rights reserved.            │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
작성일시 : 2023-02-02
작성자 : Eden
작성시간 : 오전 5:21
용도 : User Info Date Modify json Handling data transfer requests
*/

window.addEventListener("DOMContentLoaded", function () {

    $("#userFindAnswer").keyup(function () {
        $("#updateInfo").attr("disabled", false);
    });

    $("#updateInfo").click(function () {

        if ($("#alertNickName").text() == "!  이미 사용중인 닉네임 입니다.") {
            alert("닉네임을 확인해주세요");
        } else if ($("#alertPhone").text() == "!  이미 사용중인 휴대폰번호 입니다.") {
            alert("휴대폰번호을 확인해주세요");
        } else if ($("#alertEmail").text() == "!  이메일이 이미 사용중입니다.") {
            alert("이메일주소를 확인해주세요");
        } else if ($("#alertCertified") == "! 인증번호가 일치하지 않습니다. 다시 확인해주시기 바랍니다.") {
            alert("인증번호를 확인해주세요");
        } else {
            $.ajax({
                type: "post",
                url: "../user/updateUserInfo",
                data: {
                    question_no: $("#userQuestion").val(),
                    user_id: $("#inputUserId").val(),
                    user_nickname: $("#userNickName").val(),
                    user_phone: $("#userPhone").val(),
                    user_email: $("#userEmail").val(),
                    user_findAnswer: $("#userFindAnswer").val()
                },
                dataType: "json",
                success: function (data) {
                    if (data.result == 'fail') {
                        alert("유저 정보 확인에 실패 하였습니다 다시 확인해주세요");
                    } else if (data.result == 'success') {
                        alert("유저 정보 업데이트에 성공 하였습니다");
                        location.reload();
                    }
                }
            });
        }
    });

    $("#checkPassword").click(function () {
        $.ajax({
            type: "post",
            url: "../user/checkPw",
            data: {
                user_id: $("#uid").val(),
                current_password: $("#currentPassword").val()
            },
            dataType: "json",
            success: function (data) {
                if (data.result == 'fail') {
                    $("#alertCurrentPassword").css({
                        "color": "red",
                        "font-size": "12px"
                    });
                    $("#alertCurrentPassword").text("!  현재 비밀번호와 일치 하지 않습니다. 다시 확인해주세요");
                } else {
                    $("#alertCurrentPassword").css({
                        "color": "green",
                        "font-size": "12px"
                    });
                    $("#alertCurrentPassword").text("✔  현재 비밀번호와 일치 합니다.");
                    $("#currentPassword").attr("disabled", true);
                    $("#newPassword").attr("disabled", false);
                }
            }
        });
    });

    $("#newPassword").keyup(function () {
        var value = $(event.target).val();

        var num = value.search(/[0-9]/g);
        var eng = value.search(/[a-z]/ig);
        var spe = value.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

        if (value.length < 8 || value.length > 30) {
            $("#alertNewPassword").css({
                "color": "red",
                "font-size": "12px"
            });
            $("#alterPassword").text("!  비밀번호는 8자리이상 30자리 이하여야 합니다.")
        } else if (value.replace(/\s|　/gi, "").length == 0) {
            $("#alertNewPassword").css({
                "color": "red",
                "font-size": "12px"
            });
            $("#alertNewPassword").text("!  비밀번호에 공백은 사용할 수 없습니다.")
        } else if (num < 0 || eng < 0 || spe < 0) {
            $("#alertNewPassword").css({
                "color": "red",
                "font-size": "12px"
            });
            $("#alertNewPassword").text("!  비밀번호는 영어+숫자+특수문자로 이루어져야 합니다.")
        } else {
            $("#alertNewPassword").css({
                "color": "green",
                "font-size": "10px"
            });
            $("#alertNewPassword").text("✔  사용가능한 비밀번호입니다.");
            $("#checkingNewPassword").attr("disabled", false);
        }
    });

    $("#checkingNewPassword").keyup(function () {
        var value = $("#newPassword").val();
        if (value != $("#checkingNewPassword").val()) {
            $("#alertCheckingPassword").css({
                "color": "red",
                "font-size": "12px"
            });
            $("#alertCheckingPassword").text("!  비밀번호가 일치하지 않습니다.")
            return;
        }
        ;
        $("#alertCheckingPassword").css({
            "color": "green",
            "font-size": "10px"
        });
        $("#alertCheckingPassword").text("✔  비밀번호가 일치합니다.");
        $("#newPassword").attr("disabled", true);
        $("#modifyPw").attr("disabled", false);
    });

    $("#modifyPw").click(function () {
        $.ajax({
            type: "post",
            url: "../user/modifyPassword",
            data: {
                user_id: $("#uid").val(),
                user_pw: $("#checkingNewPassword").val()
            },
            dataType: "json",
            success: function (data) {
                if (data.result == 'fail') {
                    alert("비밀번호 변경에 실패 하였습니다. 다시 확인해주세요");
                } else {
                    alert("비밀번호 변경에 성공하였습니다");
                    location.reload();
                }
            }
        });
    });

    $("#checkPassword2").click(function () {
        $.ajax({
            type: "post",
            url: "../user/checkPw",
            data: {
                user_id: $("#uid").val(),
                current_password: $("#currentPassword2").val()
            },
            dataType: "json",
            success: function (data) {
                if (data.result == 'fail') {
                    $("#alertCurrentPassword2").css({
                        "color": "red",
                        "font-size": "12px"
                    });
                    $("#alertCurrentPassword2").text("!  현재 비밀번호와 일치 하지 않습니다. 다시 확인해주세요");
                } else {
                    $("#alertCurrentPassword2").css({
                        "color": "green",
                        "font-size": "12px"
                    });
                    $("#alertCurrentPassword2").text("✔  현재 비밀번호와 일치 합니다.");
                    $("#deleteUser").attr("disabled", false);
                }
            }
        });
    });

    $("#deleteUser").click(function () {
        $.ajax({
            type: "post",
            url: "../user/deleteUserInfoByUserNo",
            data: {
                user_id: $("#uid").val(),
                user_pw: $("#currentPassword2").val()
            },
            dataType: "json",
            success: function (data) {
                if (data.result == 'fail') {
                    alert("비밀번호을 확인해주세요");
                } else {
                    alert("회원탈퇴에 성공 하였습니다.");
                    location.reload();
                }
            }
        });
    });
});