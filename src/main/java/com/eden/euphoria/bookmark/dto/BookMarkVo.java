/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 2월 17일 송민우 All rights reserved.            │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
작성일시 : 2023-02-17
작성자 : Eden
작성시간 : 오전 7:08
용도 : 
*/

package com.eden.euphoria.bookmark.dto;

import com.eden.euphoria.board.dto.BoardVo;

import java.util.Date;

public class BookMarkVo {
    private int book_mark_no;
    private int board_no;
    private int user_no;
    private Date reg_date;

    public BookMarkVo() {
        super();
    }

    public BookMarkVo(int book_mark_no, int board_no, int user_no, Date reg_date) {
        this.book_mark_no = book_mark_no;
        this.board_no = board_no;
        this.user_no = user_no;
        this.reg_date = reg_date;
    }

    public int getBook_mark_no() {
        return book_mark_no;
    }

    public void setBook_mark_no(int book_mark_no) {
        this.book_mark_no = book_mark_no;
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

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    @Override
    public String toString() {
        return "BookMarkVo{" +
                "book_mark_no=" + book_mark_no +
                ", board_no=" + board_no +
                ", user_no=" + user_no +
                ", reg_date=" + reg_date +
                '}';
    }

}
