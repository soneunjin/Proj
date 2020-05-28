package com.team.www.controller.qna;
/**
 * @author 이한철
 * 
 * 	 이 클래스는 Q&A 글쓰기 컨트롤러
 */
import javax.servlet.http.*;

import com.team.www.controller.*;
import com.team.www.dao.*;
import com.team.www.vo.*;

public class QnaWrite implements ClsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/qna/qnaWrite.jsp";
		String mid = req.getParameter("sid");
      //System.out.println(mid);
		QnaDAO qDAO = new QnaDAO();
		
		String sid = qDAO.getMname(mid);
		req.setAttribute("NAME", sid);
		return view;
	}

}
