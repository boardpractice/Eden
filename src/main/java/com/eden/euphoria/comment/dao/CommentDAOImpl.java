/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 2월 5일 송민우 All rights reserved.               │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
작성일시 : 2023-02-05
작성자 : Eden
작성시간 : 오후 3:23
용도 : Performing comment data access object interface logic
*/

package com.eden.euphoria.comment.dao;

import com.eden.euphoria.comment.dto.CommentLikeVo;
import com.eden.euphoria.comment.dto.CommentVo;
import com.eden.euphoria.commons.annotation.LogException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDAOImpl implements CommentDAO {

    private final String NAMESPACE = "mappers.comment.CommentSQLMapper";

    @Autowired
    SqlSession sqlSession;

    //  댓글 목록
    @Override
    @LogException
    public List<CommentVo> getCommentList(int board_no) {
        return sqlSession.selectList(NAMESPACE + ".getCommentList", board_no);
    }

    //  댓글 총 갯수
    @Override
    @LogException
    public int getTotalCommentCount(int board_no) {
        return sqlSession.selectOne(NAMESPACE + ".getTotalCommentCount", board_no);
    }

    //  댓글 작성
    @Override
    @LogException
    public void writeComment(CommentVo commentVo) {
        sqlSession.insert(NAMESPACE + ".writeComment", commentVo);
    }

    //  댓글 수정
    @Override
    @LogException
    public void updateComment(CommentVo commentVo) {
        sqlSession.update(NAMESPACE + ".updateComment", commentVo);
    }

    //  댓글 삭제
    @Override
    @LogException
    public void deleteComment(int comment_no) {
        sqlSession.delete(NAMESPACE + ".deleteComment", comment_no);
    }

    //  댓글 좋아요
    @Override
    @LogException
    public void doCommentLike(CommentLikeVo like) {
        sqlSession.insert(NAMESPACE + ".doCommentLike", like);
    }

    //  댓글 좋아요 상태
    @Override
    @LogException
    public int getMyCommentLikeCount(CommentLikeVo like) {
        return sqlSession.selectOne(NAMESPACE + ".getMyCommentLikeCount", like);
    }

    //  댓글 좋아요 삭제
    @Override
    @LogException
    public void deleteCommentLike(CommentLikeVo like) {
        sqlSession.delete(NAMESPACE + ".deleteCommentLike", like);
    }

    //  댓글 좋아요 총 갯수
    @Override
    @LogException
    public int getTotalCommentLikeCount(int comment_no) {
        return sqlSession.selectOne(NAMESPACE + ".getTotalCommentLikeCount", comment_no);
    }

    //  내가 작성한 댓글
    @Override
    @LogException
    public List<CommentVo> getMyCommentList(int user_no) {
        return sqlSession.selectList(NAMESPACE + ".getMyCommentList", user_no);
    }
}
