/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 2월 9일 송민우 All rights reserved.            │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
작성일시 : 2023-02-09
작성자 : Eden
작성시간 : 오전 8:18
용도 : 
*/

package com.eden.euphoria.board.dto;

public class CategoryVo {

    private int category_no; // 카테고리 번호
    private String category_name; // 카테고리 이름

    public CategoryVo() {
        super();
    }

    public CategoryVo(int category_no, String category_name) {
        this.category_no = category_no;
        this.category_name = category_name;
    }

    public int getCategory_no() {
        return category_no;
    }

    public void setCategory_no(int category_no) {
        this.category_no = category_no;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    @Override
    public String toString() {
        return "CategoryVo{" +
                "category_no=" + category_no +
                ", category_name='" + category_name + '\'' +
                '}';
    }
}
