/**
 * @author 이진수
 * 
 */
package com.team.www.controller.board;

import javax.servlet.http.*;

import com.team.www.controller.ClsController;
import com.team.www.dao.BoardDAO;
import com.team.www.vo.BoardVO;

public class CommentEdit implements ClsController {

	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "";

//		req.setAttribute("isRedirect", true);
		String eno = req.getParameter("bdno");
		String bdbd = req.getParameter("comment");
		int bno = 0;
		try {
			bno = Integer.parseInt(eno);
		} catch (Exception e) {
		}

		//system.out.println("com : " + bno);
		//system.out.println("bdbd : " + bdbd);
		BoardDAO bDAO = new BoardDAO();
		int cnt = bDAO.comEdit(bno, bdbd);
		//system.out.println("보냈냐");
		return view;

	}

}
