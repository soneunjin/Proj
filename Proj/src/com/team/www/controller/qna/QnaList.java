package com.team.www.controller.qna;

import javax.servlet.http.*;
import java.util.*;

import com.team.www.controller.*;
import com.team.www.dao.*;
import com.team.www.vo.*;
import com.team.www.util.*;

public class QnaList implements ClsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/qna/qnaList.jsp";
		
		int nowPage = 1;
		String strPage = req.getParameter("nowPage");
		try {
			nowPage = Integer.parseInt(strPage);
		} catch(Exception e) {}
		
		// 할일
		QnaDAO qDAO = new QnaDAO();
		int totalCount = qDAO.getTotalCount();
		
		// PageUtil 만들고 작업
		PageUtil page = new PageUtil(nowPage, totalCount);
		// 데이터베이스 작업하고
		ArrayList<QnaVO> list = qDAO.getQlist(page.getStartCont(), page.getEndCont());
		
		
		
		
		req.setAttribute("LIST", list);
		req.setAttribute("PAGE", page);
		
		return view;
	}

}
