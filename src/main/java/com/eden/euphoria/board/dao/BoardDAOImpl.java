/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 2월 3일 Eden All rights reserved.             │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
작성일시 : 2023-02-03
작성자 : Eden
작성시간 : 오후 8:23
용도 :
*/

package com.eden.euphoria.board.dao;

import com.eden.euphoria.board.dto.BoardLikeVo;
import com.eden.euphoria.board.dto.BoardVo;
import com.eden.euphoria.board.dto.CategoryVo;
import com.eden.euphoria.board.dto.ViewPageVo;
import com.eden.euphoria.commons.annotation.LogException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BoardDAOImpl implements BoardDAO {

    private static final String NAMESPACE = "mappers.board.BoardSQLMapper";

    @Autowired
    SqlSession sqlSession;

    //  게시글 목록
    @Override
    @LogException
    public List<BoardVo> getBoardList(int pageNum) {
        return sqlSession.selectList(NAMESPACE + ".getBoardList", pageNum);
    }

    //  게시글 작성
    @Override
    @LogException
    public void insertBoard(BoardVo param) {
        sqlSession.insert(NAMESPACE + ".write", param);
    }

    //  게시글 상세보기
    @Override
    @LogException
    public BoardVo getBoardByNo(int board_no) {
        return sqlSession.selectOne(NAMESPACE + ".getBoardByNo", board_no);
    }

    //  게시글 수정
    @Override
    @LogException
    public void updateBoard(BoardVo param) {
        sqlSession.update(NAMESPACE + ".updateBoard", param);
    }

    //  게시글 삭제
    @Override
    @LogException
    public void deleteBoard(int board_no) {
        sqlSession.delete(NAMESPACE + ".deleteBoard", board_no);
    }

    //  게시글 좋아요
    @Override
    @LogException
    public void doLike(BoardLikeVo likeVo) {
        sqlSession.insert(NAMESPACE + ".doLike", likeVo);
    }

    //  게시글 좋아요 상태
    @Override
    @LogException
    public int getMyLikeCount(BoardLikeVo likeVo) {
        return sqlSession.selectOne(NAMESPACE + ".getMyLikeCount", likeVo);
    }

    //  게시글 좋아요 취소
    @Override
    @LogException
    public void deleteLike(BoardLikeVo likeVo) {
        sqlSession.delete(NAMESPACE + ".deleteLike", likeVo);
    }

    //  게시글 좋아요 총 갯수
    @Override
    @LogException
    public int getTotalLikeCount(int board_no) {
        return sqlSession.selectOne(NAMESPACE + ".getTotalLikeCount", board_no);
    }

    //  게시글 카테고리별 정렬
    @Override
    @LogException
    public List<BoardVo> getBoardByCategoryList(int category_no, int pageNum) {
        Map<String, Object> map = new HashMap<>();
        map.put("category_no", category_no);
        map.put("pageNum", pageNum);
        return sqlSession.selectList(NAMESPACE + ".getBoardByCategoryList", map);
    }

    //  게시글 카테고리 정보
    @Override
    @LogException
    public CategoryVo getCategoryByNo(int category_no) {
        return sqlSession.selectOne(NAMESPACE + ".getCategoryByNo", category_no);
    }

    //  게시글 카테고리 목록

    @Override
    @LogException
    public List<CategoryVo> getCategoryList() {
        return sqlSession.selectList(NAMESPACE + ".getCategoryList");
    }

    //  게시글 제목 검색
    @Override
    @LogException
    public List<BoardVo> selectByTitle(String title, int category_no, int pageNum) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("title", title);
        paramMap.put("category_no", category_no);
        paramMap.put("pageNum", pageNum);
        return sqlSession.selectList(NAMESPACE + ".selectByTitle", paramMap);
    }

    //  게시글 내용 검색
    @Override
    @LogException
    public List<BoardVo> selectByContent(String content, int category_no, int pageNum) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("content", content);
        paramMap.put("category_no", category_no);
        paramMap.put("pageNum", pageNum);
        return sqlSession.selectList(NAMESPACE + ".selectByTitle", paramMap);
    }

    //  게시글 작성자 검색
    @Override
    @LogException
    public List<BoardVo> selectByNickName(String nickname, int category_no, int pageNum) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("nickname", nickname);
        paramMap.put("category_no", category_no);
        paramMap.put("pageNum", pageNum);
        return sqlSession.selectList(NAMESPACE + ".selectByNickName", paramMap);
    }

    //  게시글 총 갯수 ( 페이징 용도 )
    @Override
    @LogException
    public int selectCount(String searchType, String searchWord, int category_no) {
        Map<String, Object> map = new HashMap<>();
        map.put("searchType", searchType);
        map.put("searchWord", searchWord);
        map.put("category_no", category_no);
        System.out.println("searchType : " + searchType + " searchWord : " + searchWord);
        if (searchType != null && searchWord != null) {
            return sqlSession.selectOne(NAMESPACE + ".selectCount", map);
        }
        return sqlSession.selectOne(NAMESPACE + ".boardCount", map);
    }

    //  게시글 조회수 증가 조회
    @Override
    @LogException
    public List<ViewPageVo> getViewPageList(int boardNo) {
        return sqlSession.selectList(NAMESPACE + ".getViewPageList", boardNo);
    }

    @Override
    @LogException
    public void insertViewPage(ViewPageVo viewPageVo) {
        sqlSession.insert(NAMESPACE + ".insertViewPage", viewPageVo);
    }

    @Override
    @LogException
    public int selectByLockupIp(String lockup_ip) {
        return sqlSession.selectOne(NAMESPACE + ".selectByLockupIp", lockup_ip);
    }

    @Override
    @LogException
    public int selectByViewByBoardNo(int boardNo) {
        return sqlSession.selectOne(NAMESPACE + ".selectByViewByBoardNo", boardNo);
    }

    @Override
    @LogException
    public int selectByViewPage(ViewPageVo viewPageVo) {
        return sqlSession.selectOne(NAMESPACE + ".selectByViewPage", viewPageVo);
    }

    @Override
    @LogException
    public void increaseReadCount(int boardNo) {
        sqlSession.update(NAMESPACE + ".increaseReadCount", boardNo);
    }

    @Override
    @LogException
    public void updateViewPage(ViewPageVo param) {
        sqlSession.update(NAMESPACE + ".updateViewPage", param);
    }

    @Override
    @LogException
    public void deleteViewPage(int boardNo) {
        sqlSession.delete(NAMESPACE + ".deleteViewPage", boardNo);
    }

    @Override
    @LogException
    public int createViewPk() {
        return sqlSession.selectOne(NAMESPACE + ".createViewPk");
    }
}
