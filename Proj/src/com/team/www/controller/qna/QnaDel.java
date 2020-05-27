package com.team.www.controller.qna;

import javax.servlet.http.*;

import com.team.www.controller.*;
import com.team.www.dao.*;

public class QnaDel implements ClsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/Project/qna/qnaList.cls";
		req.setAttribute("isRedirect", true); 
		String sno = req.getParameter("qqno");
		
		int qno = Integer.parseInt(sno);
		QnaDAO qDAO = new QnaDAO();
		int tt = qDAO.delQna(qno);
		
		
		return view;
	}

}
