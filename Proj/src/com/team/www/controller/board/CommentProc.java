/**
 * @author 이진수
 * 
 */
package com.team.www.controller.board;

import javax.servlet.http.*;

import com.team.www.controller.ClsController;
import com.team.www.dao.BoardDAO;
import com.team.www.vo.BoardVO;

public class CommentProc implements ClsController {

	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/board/comment.jsp";

//		req.setAttribute("isRedirect", true);
		String eno = req.getParameter("no");
		int bno = 0;
		try {
			bno = Integer.parseInt(eno);
		} catch (Exception e) {
		}

		//system.out.println("com : " + bno);
		BoardDAO bDAO = new BoardDAO();
		BoardVO bVO = bDAO.getDetail(bno);

		req.setAttribute("bdno", bno);
		//system.out.println("보냈냐");
		return view;

	}

}
