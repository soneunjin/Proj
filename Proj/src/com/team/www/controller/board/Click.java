package com.team.www.controller.board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.www.controller.ClsController;
import com.team.www.dao.BoardDAO;
import com.team.www.util.PageUtil;
import com.team.www.vo.BoardVO;

public class Click implements ClsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/board/board.jsp";
		int nowPage = 1;
		String strPage = req.getParameter("nowPage");
		try {
			nowPage = Integer.parseInt(strPage);
			
		}catch(Exception e) {
		}
		System.out.println("np" + nowPage);
		BoardDAO bDAO = new BoardDAO();
		int totalCount = bDAO.getTotal();
		System.out.println("TC" + totalCount);
		PageUtil page = new PageUtil(nowPage, totalCount, 10, 3);
		ArrayList<BoardVO> list = bDAO.getAllList(page);
		System.out.println("메인 " + list.size());
		// 데이터 뷰에 심고
		req.setAttribute("LIST", list);
		req.setAttribute("PAGE", page);
		
		return view;
	}

}