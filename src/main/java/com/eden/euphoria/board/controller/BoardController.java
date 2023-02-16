/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 2월 3일 Eden All rights reserved.             │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
작성일시 : 2023-02-03
작성자 : Eden
작성시간 : 오후 8:20
용도 : Web Board Page Request Client Handling
*/

package com.eden.euphoria.board.controller;

import com.eden.euphoria.board.dto.BoardVo;
import com.eden.euphoria.board.dto.ViewPageVo;
import com.eden.euphoria.board.service.BoardService;
import com.eden.euphoria.comment.service.CommentService;
import com.eden.euphoria.commons.annotation.LogException;
import com.eden.euphoria.user.dto.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping(value = "/board/*")
public class BoardController {

    @Autowired
    BoardService boardService;

    @Autowired
    CommentService commentService;

    //  게시글 목록
    @RequestMapping(value = "list")
    @LogException
    public String list(Model model,
                       @RequestParam(value = "category_no", defaultValue = "0") int category_no,
                       String searchType,
                       String searchWord,
                       @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                       HttpServletRequest request) {

        ArrayList<HashMap<String, Object>> dataList = boardService.getBoardList(category_no, searchType, searchWord, pageNum);

        Map<String, ?> map = RequestContextUtils.getInputFlashMap(request);

        if (map != null) {
            category_no = (int) map.get("category_no");
        }
        model.addAttribute("dataList", dataList);
        model.addAttribute("category_no", category_no);

        int boardCount = boardService.getBoardCount(searchType, searchWord, category_no);
        int totalPageCount = (int) Math.ceil(boardCount / 5.0);
        //1 2 3 4 5	, 6 7 8 9 10 ....16 17 18 19 20
        int startPage = ((pageNum - 1) / 5) * 5 + 1;
        int endPage = ((pageNum - 1) / 5 + 1) * 5;
        if (endPage > totalPageCount) {
            endPage = totalPageCount;
        }

        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("currentPageNum", pageNum);
        model.addAttribute("totalPageCount", totalPageCount);

        //링크 유지...
        String additionalParam = "";
        if (searchType != null && searchWord != null) {
            additionalParam += "&searchType=" + searchType;
            additionalParam += "&searchWord=" + searchWord;
        }

        model.addAttribute("additionalParam", additionalParam);
        return "board/list";
    }

    //  게시글 작성 페이지
    @PostMapping("write")
    @LogException
    public String write(@RequestParam(value = "category_no", defaultValue = "0") int category_no, @ModelAttribute("boardVo") BoardVo vo, Model model) {

        if (category_no != 0) {
            model.addAttribute("data", boardService.getCategoryByNo(category_no));
        } else {
            model.addAttribute("list", boardService.getCategoryList());
        }

        return "board/write";
    }

    //  게시글 작성 프로시저
    @PostMapping(value = "writeProcess")
    @LogException
    public String writeProcess(@Valid BoardVo param, BindingResult result, HttpSession session, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "board/write";
        }

        UserVo sessionUser = (UserVo) session.getAttribute("sessionUser");
        param.setUser_no(sessionUser.getUser_no());

        redirectAttributes.addFlashAttribute("category_no", param.getCategory_no());
        boardService.insertBoard(param);

        return "redirect:../board/list";
    }

    //  게시글 보기 페이지
    @PostMapping(value = "read")
    @LogException
    public String read(int board_no, Model model, HttpServletRequest request) {

        List<ViewPageVo> viewPageVo = boardService.getViewPageList(board_no);
        if (boardService.isSelectByViewByBoardNo(board_no)) {
            if (!boardService.isSelectByLockupIp(request.getRemoteAddr())) {
                ViewPageVo param = new ViewPageVo();
                param.setBoard_no(board_no);
                param.setLockup_ip(request.getRemoteAddr());

                boardService.insertViewPage(param);
                boardService.increaseReadCount(board_no);
            }
        } else {
            ViewPageVo param = new ViewPageVo();
            param.setBoard_no(board_no);
            param.setLockup_ip(request.getRemoteAddr());

            boardService.insertViewPage(param);
            boardService.increaseReadCount(board_no);
        }

        for (ViewPageVo param : viewPageVo) {
            if (param != null) {
                if (boardService.isSelectByLockupIp(request.getRemoteAddr())) {
                    if (param.getLockup_ip().equals(request.getRemoteAddr())) {
                        Date writeDate = new Date(System.currentTimeMillis()); // 현재 서버 시간
                        Date tagetDate = new Date(param.getView_inquiry_time().getTime() + 1000 * 60 * 60 * 24); // 조회한 조회 일자

                        if (writeDate.after(tagetDate)) {
                            boardService.increaseReadCount(board_no);
                            boardService.updateViewPage(param);
                        }
                    }
                }
            }
        }


        model.addAttribute("data", boardService.getBoard(board_no));
        model.addAttribute("dataList", commentService.getCommentList(board_no));
        return "board/read";
    }

    //  게시글 수정
    @PostMapping(value = "modify")
    @LogException
    public String modify(Model model, @RequestParam(value = "board_no", defaultValue = "0") int boardNo) {

        model.addAttribute("data", boardService.getBoard(boardNo));

        return "board/modify";
    }

    //  게시글 수정 프로시져
    @PostMapping(value = "modifyProcess")
    @LogException
    public String modifyProcess(BoardVo boardVo, RedirectAttributes redirectAttributes) {

        boardService.updateBoard(boardVo);

        redirectAttributes.addFlashAttribute("category_no", boardVo.getCategory_no());

        return "redirect:../board/list";
    }

    //  게시글 삭제 프로시져
    @PostMapping(value = "delete")
    @LogException
    public String delete(int board_no) {

        boardService.deleteBoard(board_no);

        return "redirect:../board/list";
    }
}
