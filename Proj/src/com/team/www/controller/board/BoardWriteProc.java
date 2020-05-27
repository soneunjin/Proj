package com.team.www.controller.board;

import java.util.HashMap;

import javax.servlet.http.*;

import com.team.www.controller.ClsController;
import com.team.www.dao.BoardDAO;


public class BoardWriteProc implements ClsController {

	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/board/board.cls";
//		req.setAttribute("isRedirect", true);
		String cate = req.getParameter("cate");
		System.out.println(cate);
		String title = req.getParameter("title");
		System.out.println(title);
		String body = req.getParameter("body");
		System.out.println(body);
		String sid = (String) req.getSession().getAttribute("SID");
		System.out.println(sid);
		BoardDAO bDAO = new BoardDAO();
		int cnt = bDAO.addData(cate, title, body, sid);
		return view;
		
	}

}
