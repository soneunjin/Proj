package com.team.www.controller.qna;

import javax.servlet.http.*;

import com.team.www.controller.*;
import com.team.www.dao.*;

public class QnaProc implements ClsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/Project/qna/qnaList.cls";
		req.setAttribute("isRedirect", true);
		String qtt = req.getParameter("qtt");
		String qip = req.getParameter("qbd");
		String id = (String) req.getSession().getAttribute("SID");
		
		System.out.println(qtt +" | "+ qip + " | " + id);
		QnaDAO qDAO = new QnaDAO();
		int cnt = qDAO.addData(qtt, qip, id);
		return view;
	}

}
