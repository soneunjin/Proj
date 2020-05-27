package com.team.www.controller.qna;

import javax.servlet.http.*;

import com.team.www.controller.*;
import com.team.www.dao.*;

public class QnaModiProc implements ClsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/Project/qna/qnaList.cls";
		req.setAttribute("isRedirect", true);
		String sqno = req.getParameter("qqno");
		String sqtt = req.getParameter("qqtt");
		String sqbd = req.getParameter("qqbd");
		
		int qno = Integer.parseInt(sqno);
		
		System.out.println(qno);
		System.out.println(sqtt);
		System.out.println(sqbd);
		
		QnaDAO qDAO = new QnaDAO();
		int modi = qDAO.modiData(sqtt, sqbd, qno);
		
		return view;
	}

}
