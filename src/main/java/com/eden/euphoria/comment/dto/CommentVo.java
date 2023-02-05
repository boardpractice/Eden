/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 2월 5일 송민우 All rights reserved.            │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
작성일시 : 2023-02-05
작성자 : Eden
작성시간 : 오후 3:29
용도 : Comment Table Date Value Object
*/

package com.eden.euphoria.comment.dto;

import java.util.Date;

public class CommentVo {

    private int comment_no; // 댓글 번호
    private int user_no; // 유저 번호
    private int board_no; // 게시글 번호
    private String comment_content; // 댓글 내용
    private Date comment_write_date; //  댓글 작성시간\

    public CommentVo() {
        super();
    }

    public CommentVo(int comment_no, int user_no, int board_no, String comment_content, Date comment_write_date) {
        this.comment_no = comment_no;
        this.user_no = user_no;
        this.board_no = board_no;
        this.comment_content = comment_content;
        this.comment_write_date = comment_write_date;
    }

    public int getComment_no() {
        return comment_no;
    }

    public void setComment_no(int comment_no) {
        this.comment_no = comment_no;
    }

    public int getUser_no() {
        return user_no;
    }

    public void setUser_no(int user_no) {
        this.user_no = user_no;
    }

    public int getBoard_no() {
        return board_no;
    }

    public void setBoard_no(int board_no) {
        this.board_no = board_no;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public Date getComment_write_date() {
        return comment_write_date;
    }

    public void setComment_write_date(Date comment_write_date) {
        this.comment_write_date = comment_write_date;
    }

    @Override
    public String toString() {
        return "CommentVo{" +
                "comment_no=" + comment_no +
                ", user_no=" + user_no +
                ", board_no=" + board_no +
                ", comment_content='" + comment_content + '\'' +
                ", comment_write_date=" + comment_write_date +
                '}';
    }
}
