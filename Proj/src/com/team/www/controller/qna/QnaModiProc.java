package com.team.www.controller.qna;
/**
 * @author 이한철
 * 
 * 		글 수정 처리과정 컨트롤러
 * 
 */
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
		
		
		QnaDAO qDAO = new QnaDAO();
		int modi = qDAO.modiData(sqtt, sqbd, qno);
		
		return view;
	}

}
