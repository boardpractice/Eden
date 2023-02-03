/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 2월 3일 Eden All rights reserved.             │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
작성일시 : 2023-02-03
작성자 : Eden
작성시간 : 오후 8:30
용도 : Board Table Data Value Object
*/

package com.eden.euphoria.board.dto;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class BoardVo {

    private int board_no; // 게시글 번호
    private int user_no; //  유저 넘버

    @NotNull
    @Length(min = 1, max = 2000)
    private String board_title; //  게시글 제목

    @NotNull
    @Length(min = 1, max = 4000)
    private String board_content; //  게시글 내용

    private int board_readcount; //  게시글 조회수

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date board_write_date;

    public BoardVo() {
        super();
    }

    public BoardVo(int board_no, int user_no, String board_title, String board_content, int board_readcount, Date board_write_date) {
        this.board_no = board_no;
        this.user_no = user_no;
        this.board_title = board_title;
        this.board_content = board_content;
        this.board_readcount = board_readcount;
        this.board_write_date = board_write_date;
    }

    public int getBoard_no() {
        return board_no;
    }

    public void setBoard_no(int board_no) {
        this.board_no = board_no;
    }

    public int getUser_no() {
        return user_no;
    }

    public void setUser_no(int user_no) {
        this.user_no = user_no;
    }

    public String getBoard_title() {
        return board_title;
    }

    public void setBoard_title(String board_title) {
        this.board_title = board_title;
    }

    public String getBoard_content() {
        return board_content;
    }

    public void setBoard_content(String board_content) {
        this.board_content = board_content;
    }

    public int getBoard_readcount() {
        return board_readcount;
    }

    public void setBoard_readcount(int board_readcount) {
        this.board_readcount = board_readcount;
    }

    public Date getBoard_write_date() {
        return board_write_date;
    }

    public void setBoard_write_date(Date board_write_date) {
        this.board_write_date = board_write_date;
    }

    @Override
    public String toString() {
        return "BoardVo{" +
                "board_no=" + board_no +
                ", user_no=" + user_no +
                ", board_title='" + board_title + '\'' +
                ", board_content='" + board_content + '\'' +
                ", board_readcount=" + board_readcount +
                ", board_write_date=" + board_write_date +
                '}';
    }
}
