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

public class Searching implements ClsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/board/sboard.jsp";
		int nowPage = 1;
		String strPage = req.getParameter("nowPage");
		String condition = req.getParameter("condition");
		String input = req.getParameter("input");
		//system.out.println(condition +  ", " + input);
		
		try {
			nowPage = Integer.parseInt(strPage);
			
		}catch(Exception e) {
		}
//		//system.out.println("np" + nowPage);
		BoardDAO bDAO = new BoardDAO();
		int totalCount = bDAO.getSTotal(condition, input);
		//system.out.println("STC" + totalCount);
		PageUtil page = new PageUtil(nowPage, totalCount, 10, 3);
		ArrayList<BoardVO> slist = bDAO.searching(condition, input, page);
		//system.out.println("검색 " + slist.size());
		// 데이터 뷰에 심고
		req.setAttribute("LIST", slist);
		req.setAttribute("PAGE", page);
		req.setAttribute("COND", condition);
		req.setAttribute("INPU", input);
		
		return view;
	}

}