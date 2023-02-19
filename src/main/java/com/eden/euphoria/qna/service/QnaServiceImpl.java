/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 2월 19일 송민우 All rights reserved.            │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
작성일시 : 2023-02-19
작성자 : Eden
작성시간 : 오전 11:18
용도 : 
*/

package com.eden.euphoria.qna.service;

import com.eden.euphoria.commons.annotation.LogException;
import com.eden.euphoria.qna.dao.QnaDAO;
import com.eden.euphoria.qna.dto.QnaVo;
import com.eden.euphoria.user.dao.UserDAO;
import com.eden.euphoria.user.dto.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class QnaServiceImpl implements QnaService {

    @Autowired
    QnaDAO qnaDAO;

    @Autowired
    UserDAO userDAO;

    //  qna 리스트
    @Override
    @LogException
    public ArrayList<HashMap<String, Object>> getQnaList() {

        ArrayList<HashMap<String, Object>> dataList = new ArrayList<HashMap<String, Object>>();
        List<QnaVo> qnaVoList = qnaDAO.getQnaList();
        for (QnaVo qnaVo : qnaVoList) {
            UserVo userVo = userDAO.getUserByNo(qnaVo.getUser_no());
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("userVo", userVo);
            map.put("qnaVo", qnaVo);

            dataList.add(map);
        }
        return dataList;
    }
}
