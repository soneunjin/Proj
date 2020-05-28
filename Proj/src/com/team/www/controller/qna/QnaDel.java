package com.team.www.controller.qna;
/**
 * @author 이한철
 * 
 * 		Q&A 글 삭제기능 컨트롤러
 */
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
