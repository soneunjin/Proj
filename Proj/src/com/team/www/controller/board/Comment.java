/**
 */

package com.team.www.controller.board;

import javax.servlet.http.*;

import com.team.www.controller.ClsController;
import com.team.www.dao.BoardDAO;


public class Comment implements ClsController {

	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/board/board.cls";
		String bno = req.getParameter("bdno");
		//system.out.println("여기뭔데" + bno);
		 int orino = 0;
	      try {
	         orino = Integer.parseInt(bno);
	      } catch(Exception e) {}
	    //system.out.println("com1 : " + orino);
		String sid = (String) req.getSession().getAttribute("SID");
		//system.out.println("com1 : " + sid);
		String cbody = req.getParameter("comment");
		//system.out.println("com1 : " + cbody);
		BoardDAO bDAO = new BoardDAO();
		int cnt = bDAO.addCom(cbody, sid, orino);
		return view;
		
	}

}
