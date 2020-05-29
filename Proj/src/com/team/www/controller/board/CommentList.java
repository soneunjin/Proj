/**
 * @author 이진수
 * 
 */
package com.team.www.controller.board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.www.controller.ClsController;
import com.team.www.dao.BoardDAO;
import com.team.www.util.PageUtil;
import com.team.www.vo.BoardVO;

public class CommentList implements ClsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/board/board.jsp";
		int nowPage = 1;
		String strPage = req.getParameter("nowPage");
		try {
			nowPage = Integer.parseInt(strPage);
			
		}catch(Exception e) {
		}
		BoardDAO bDAO = new BoardDAO();
		int totalCount = bDAO.getTotal();
		PageUtil page = new PageUtil(nowPage, totalCount, 5, 5);
		ArrayList<BoardVO> clist = bDAO.getAllList(page);
		
		// 데이터 뷰에 심고
		req.setAttribute("CLIST", clist);
		req.setAttribute("PAGE", page);
		
		return view;
	}

}