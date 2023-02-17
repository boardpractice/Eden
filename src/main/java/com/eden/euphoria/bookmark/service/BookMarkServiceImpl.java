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

import com.eden.euphoria.board.dao.BoardDAO;
import com.eden.euphoria.board.dto.BoardVo;
import com.eden.euphoria.bookmark.dao.BookMarkDAO;
import com.eden.euphoria.bookmark.dto.BookMarkVo;
import com.eden.euphoria.commons.annotation.LogException;
import com.eden.euphoria.user.dao.UserDAO;
import com.eden.euphoria.user.dto.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookMarkServiceImpl implements BookMarkService {

    @Autowired
    BookMarkDAO bookMarkDAO;

    @Autowired
    UserDAO userDAO;

    @Autowired
    BoardDAO boardDAO;

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

    //  게시글 북마크 상태 조회
    @Override
    @LogException
    public int getMyBookMarkStatus(BookMarkVo param) {
        return bookMarkDAO.getMyBookMarkStatus(param);
    }

    //  내가 북마크한 글 리스트 불러오기
    public ArrayList<HashMap<String, Object>> getBookMarkList(int user_no) {
        ArrayList<HashMap<String, Object>> dataList = new ArrayList<HashMap<String, Object>>();
        List<BookMarkVo> bookMarkVoList = bookMarkDAO.getBookMarkList(user_no);
        for (BookMarkVo bookMarkVo : bookMarkVoList) {
            int boardNo = bookMarkVo.getBoard_no();
            BoardVo boardVo = boardDAO.getBoardByNo(boardNo);
            UserVo userVo = userDAO.getUserByNo(user_no);
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("boardVo", boardVo);
            map.put("userVo", userVo);
            map.put("bookMarkVo", bookMarkVo);

            dataList.add(map);
        }
        return dataList;
    }
}
