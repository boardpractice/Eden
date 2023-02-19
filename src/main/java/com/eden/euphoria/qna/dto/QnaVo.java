/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 2월 19일 송민우 All rights reserved.            │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
작성일시 : 2023-02-19
작성자 : Eden
작성시간 : 오전 11:15
용도 : 
*/

package com.eden.euphoria.qna.dto;

import java.util.Date;

public class QnaVo {

    private int qna_no;
    private int user_no;
    private String qna_title;
    private String qna_content;
    private Date qna_write_date;
    private int qna_read_count;
    private int qna_root;
    private int qna_step;
    private int qna_indent;

    public QnaVo() {
        super();
    }

    public QnaVo(int qna_no, int user_no, String qna_title, String qna_content, Date qna_write_date, int qna_read_count, int qna_root, int qna_step, int qna_indent) {
        this.qna_no = qna_no;
        this.user_no = user_no;
        this.qna_title = qna_title;
        this.qna_content = qna_content;
        this.qna_write_date = qna_write_date;
        this.qna_read_count = qna_read_count;
        this.qna_root = qna_root;
        this.qna_step = qna_step;
        this.qna_indent = qna_indent;
    }

    public int getQna_no() {
        return qna_no;
    }

    public void setQna_no(int qna_no) {
        this.qna_no = qna_no;
    }

    public int getUser_no() {
        return user_no;
    }

    public void setUser_no(int user_no) {
        this.user_no = user_no;
    }

    public String getQna_title() {
        return qna_title;
    }

    public void setQna_title(String qna_title) {
        this.qna_title = qna_title;
    }

    public String getQna_content() {
        return qna_content;
    }

    public void setQna_content(String qna_content) {
        this.qna_content = qna_content;
    }

    public Date getQna_write_date() {
        return qna_write_date;
    }

    public void setQna_write_date(Date qna_write_date) {
        this.qna_write_date = qna_write_date;
    }

    public int getQna_read_count() {
        return qna_read_count;
    }

    public void setQna_read_count(int qna_read_count) {
        this.qna_read_count = qna_read_count;
    }

    public int getQna_root() {
        return qna_root;
    }

    public void setQna_root(int qna_root) {
        this.qna_root = qna_root;
    }

    public int getQna_step() {
        return qna_step;
    }

    public void setQna_step(int qna_step) {
        this.qna_step = qna_step;
    }

    public int getQna_indent() {
        return qna_indent;
    }

    public void setQna_indent(int qna_indent) {
        this.qna_indent = qna_indent;
    }

    @Override
    public String toString() {
        return "QnaController{" +
                "qna_no=" + qna_no +
                ", user_no=" + user_no +
                ", qna_title='" + qna_title + '\'' +
                ", qna_content='" + qna_content + '\'' +
                ", qna_write_date=" + qna_write_date +
                ", qna_read_count=" + qna_read_count +
                ", qna_root=" + qna_root +
                ", qna_step=" + qna_step +
                ", qna_indent=" + qna_indent +
                '}';
    }
}
