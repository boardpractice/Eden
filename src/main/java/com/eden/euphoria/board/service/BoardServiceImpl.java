/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 2월 3일 Eden All rights reserved.             │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
작성일시 : 2023-02-03
작성자 : Eden
작성시간 : 오후 8:28
용도 :
*/

package com.eden.euphoria.board.service;

import com.eden.euphoria.board.dao.BoardDAO;
import com.eden.euphoria.board.dto.BoardVo;
import com.eden.euphoria.board.dto.Timer;
import com.eden.euphoria.commons.annotation.LogException;
import com.eden.euphoria.user.dao.UserDAO;
import com.eden.euphoria.user.dto.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardDAO boardDAO;

    @Autowired
    UserDAO userDAO;

    //  게시글 목록
    @Override
    @LogException
    public ArrayList<HashMap<String, Object>> getBoardList() {
        ArrayList<HashMap<String, Object>> dataList = new ArrayList<HashMap<String, Object>>();

        List<BoardVo> boardVoList = boardDAO.getBoardList();

        for (BoardVo boardVo : boardVoList) {
            int userNo = boardVo.getUser_no();
            UserVo userVo = userDAO.getUserByNo(userNo);
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("boardVo", boardVo);
            map.put("userVo", userVo);
            map.put("boardTime", Timer.calculateTime(boardVo.getBoard_write_date()));

            System.out.println("board_time : " + map.get("boardTime"));

            dataList.add(map);
        }
        return dataList;
    }

    //  게시글 작성
    @Override
    @LogException
    public void insertBoard(BoardVo param) {
        boardDAO.insertBoard(param);
    }
}