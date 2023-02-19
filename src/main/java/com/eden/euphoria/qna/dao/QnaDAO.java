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

package com.eden.euphoria.qna.dao;

import com.eden.euphoria.qna.dto.QnaVo;

import java.util.List;

public interface QnaDAO {

    public List<QnaVo> getQnaList();

}
