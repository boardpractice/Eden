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
import com.eden.euphoria.board.dto.*;
import com.eden.euphoria.comment.dao.CommentDAO;
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

    @Autowired
    CommentDAO commentDAO;

    //  게시글 목록
    @Override
    @LogException
    public ArrayList<HashMap<String, Object>> getBoardList(int category_no, String category, String keyword, int pageNum) {
        ArrayList<HashMap<String, Object>> dataList = new ArrayList<HashMap<String, Object>>();

        List<BoardVo> boardVoList;

        if (category_no == 0) {
            boardVoList = boardDAO.getBoardList(pageNum);
        } else {
            boardVoList = boardDAO.getBoardByCategoryList(category_no, pageNum);
        }
        if (category != null && keyword != null) {
            switch (category) {
                case "title":
                    boardVoList = boardDAO.selectByTitle(keyword, category_no, pageNum);
                    break;
                case "content":
                    boardVoList = boardDAO.selectByContent(keyword, category_no, pageNum);
                    break;
                case "nick":
                    boardVoList = boardDAO.selectByNickName(keyword, category_no, pageNum);
                    break;
            }
        }

        for (BoardVo boardVo : boardVoList) {
            int userNo = boardVo.getUser_no();
            int totalLikeCount = boardDAO.getTotalLikeCount(boardVo.getBoard_no());

            UserVo userVo = userDAO.getUserByNo(userNo);
            CategoryVo categoryVo = boardDAO.getCategoryByNo(boardVo.getCategory_no());

            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("boardVo", boardVo);
            map.put("userVo", userVo);
            map.put("boardTime", Timer.calculateTime(boardVo.getBoard_write_date()));
            map.put("totalLikeCount", totalLikeCount);
            map.put("totalCommentCount", commentDAO.getTotalCommentCount(boardVo.getBoard_no()));
            map.put("categoryVo", categoryVo);


            dataList.add(map);
        }
        return dataList;
    }

    //  게시글 총 갯수 ( 페이징 용도 )
    public int getBoardCount(String searchType, String searchWord, int category_no) {
        return boardDAO.selectCount(searchType, searchWord, category_no);
    }

    //  게시글 작성
    @Override
    @LogException
    public void insertBoard(BoardVo param) {
        boardDAO.insertBoard(param);
    }

    //  게시글 상세보기
    @Override
    @LogException
    public HashMap<String, Object> getBoard(int board_no) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        int totalLikeCount = boardDAO.getTotalLikeCount(board_no);
        BoardVo boardVo = boardDAO.getBoardByNo(board_no);
        UserVo userVo = userDAO.getUserByNo(boardVo.getUser_no());

        map.put("userVo", userVo);
        map.put("boardVo", boardVo);
        map.put("totalLikeCount", totalLikeCount);

        return map;
    }

    //  게시글 수정
    @Override
    @LogException
    public void updateBoard(BoardVo param) {
        boardDAO.updateBoard(param);
    }

    //  게시글 삭제
    @Override
    @LogException
    public void deleteBoard(int board_no) {
        boardDAO.deleteBoard(board_no);
    }

    //  게시글 좋아요
    @Override
    @LogException
    public void doLike(BoardLikeVo likeVo) {
        if (getMyLikeCount(likeVo) < 1) {
            boardDAO.doLike(likeVo);
        } else {
            boardDAO.deleteLike(likeVo);
        }
    }

    //  게시글 좋아요 상태
    @Override
    @LogException
    public int getMyLikeCount(BoardLikeVo likeVo) {
        return boardDAO.getMyLikeCount(likeVo);
    }

    //  게시글 좋아요 총 갯수
    @Override
    @LogException
    public int getTotalLikeCount(int board_no) {
        return boardDAO.getTotalLikeCount(board_no);
    }

    //  게시글 카테고리 목록
    @Override
    @LogException
    public List<CategoryVo> getCategoryList() {
        return boardDAO.getCategoryList();
    }

    //  게시글 카테고리 정보
    @Override
    @LogException
    public CategoryVo getCategoryByNo(int category_no) {
        return boardDAO.getCategoryByNo(category_no);
    }

    //  게시글 조회수 증가 조회
    @Override
    @LogException
    public List<ViewPageVo> getViewPageList(int boardNo) {
        return boardDAO.getViewPageList(boardNo);
    }

    @Override
    @LogException
    public void insertViewPage(ViewPageVo viewPageVo) {

        int viewNo = boardDAO.createViewPk();

        viewPageVo.setView_page_no(viewNo);

        boardDAO.insertViewPage(viewPageVo);
    }

    @Override
    @LogException
    public boolean isSelectByLockupIp(String lockup_ip) {
        return boardDAO.selectByLockupIp(lockup_ip) > 0;
    }

    @Override
    @LogException
    public boolean isSelectByViewByBoardNo(int boardNo) {
        return boardDAO.selectByViewByBoardNo(boardNo) > 0;
    }

    @Override
    @LogException
    public boolean isSelectByViewPage(ViewPageVo viewPageVo) {
        return boardDAO.selectByViewPage(viewPageVo) > 0;
    }

    @Override
    @LogException
    public void increaseReadCount(int boardNo) {
        boardDAO.increaseReadCount(boardNo);
    }

    @Override
    @LogException
    public void updateViewPage(ViewPageVo param) {
        boardDAO.updateViewPage(param);
    }

    @Override
    @LogException
    public void deleteViewPage(int boardNo) {
        boardDAO.deleteViewPage(boardNo);
    }

    //  내가 작성한 게시글
    public ArrayList<HashMap<String, Object>> getMyPostList(int user_no) {
        ArrayList<HashMap<String, Object>> dataList = new ArrayList<HashMap<String, Object>>();
        List<BoardVo> boardVoList = boardDAO.getMyPostList(user_no);
        for (BoardVo boardVo : boardVoList) {
            UserVo userVo = userDAO.getUserByNo(user_no);
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("boardVo", boardVo);
            map.put("userVo", userVo);

            dataList.add(map);
        }
        return dataList;
    }
}
