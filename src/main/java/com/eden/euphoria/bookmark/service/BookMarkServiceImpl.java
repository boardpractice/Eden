/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 2월 17일 송민우 All rights reserved.            │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
작성일시 : 2023-02-17
작성자 : Eden
작성시간 : 오전 7:06
용도 : 
*/

package com.eden.euphoria.bookmark.service;

import com.eden.euphoria.bookmark.dao.BookMarkDAO;
import com.eden.euphoria.bookmark.dto.BookMarkVo;
import com.eden.euphoria.commons.annotation.LogException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookMarkServiceImpl implements BookMarkService {

    @Autowired
    BookMarkDAO bookMarkDAO;

    //  게시글 북마크 등록
    @Override
    @LogException
    public void doBookMark(BookMarkVo param) {
        int bookMarkStatus = getMyBookMarkStatus(param);
        if (bookMarkStatus > 0) {
            bookMarkDAO.deleteBookMark(param.getBoard_no(), param.getUser_no());
        } else {
            bookMarkDAO.doBookMark(param);
        }
    }

    @Override
    @LogException
    public int getMyBookMarkStatus(BookMarkVo param) {
        return bookMarkDAO.getMyBookMarkStatus(param);
    }

}
