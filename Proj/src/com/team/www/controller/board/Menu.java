package com.team.www.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.www.controller.ClsController;
import com.team.www.dao.BoardDAO;
import com.team.www.vo.BoardVO;

public class Menu implements ClsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/board/menu.jsp";
		String sno = req.getParameter("bno");
		String cbd = req.getParameter("bd");
		int bno = 0;
		try {
			bno = Integer.parseInt(sno);
		} catch (Exception e) {
		}

		req.setAttribute("bdno", bno);
		req.setAttribute("cobd", cbd);
		//system.out.println("요기" + sno);
		return view;

	}

}
