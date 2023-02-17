/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 2월 17일 송민우 All rights reserved.            │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
작성일시 : 2023-02-17
작성자 : Eden
작성시간 : 오전 7:05
용도 : 
*/

package com.eden.euphoria.bookmark.service;

import com.eden.euphoria.bookmark.dto.BookMarkVo;

public interface BookMarkService {

    //  게시글 북마크 등록
    public void doBookMark(BookMarkVo param);

    //  게시글 북마크 상태
    public int getMyBookMarkStatus(BookMarkVo param);
}
