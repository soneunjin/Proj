package com.team.www.controller.board;

import java.util.*;

import javax.servlet.http.*;

import com.team.www.controller.ClsController;
import com.team.www.dao.BoardDAO;
import com.team.www.vo.BoardVO;



public class BoardEditProc implements ClsController {

   @Override
   public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/board/board.cls";
//		req.setAttribute("isRedirect", true);
		
		String eno = req.getParameter("no");
		 int bno = 0;
	      try {
	         bno = Integer.parseInt(eno);
	      } catch(Exception e) {}
		String title = req.getParameter("title");
		System.out.println(title);
		String body = req.getParameter("body");
		String cat = req.getParameter("cate");
		String cate = req.getParameter("cate");
		BoardDAO bDAO = new BoardDAO();
		int cnt = bDAO.edit(title, body, bno, cat);
		return view;
      
   }
}