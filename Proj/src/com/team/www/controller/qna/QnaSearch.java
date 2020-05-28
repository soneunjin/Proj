package com.team.www.controller.qna;
/**
 * @author 이한철
 * 
 * 		Q&A 글 검색 컨트롤러
 */
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.www.controller.*;
import com.team.www.dao.*;
import com.team.www.util.*;
import com.team.www.vo.*;

public class QnaSearch implements ClsController {

	@Override
public String exec(HttpServletRequest req, HttpServletResponse resp) {
	String view = "/qna/SearchResult.jsp";
	int nowPage = 1;
	String strPage = req.getParameter("nowPage");
	String type = req.getParameter("type");
	String input = req.getParameter("input");
		
	
	try {
		nowPage = Integer.parseInt(strPage);
	} catch(Exception e) {}
		
	QnaDAO qDAO = new QnaDAO();
	int totalCount = qDAO.getResultCount(type ,input);
	// PageUtil 만들고
	if(totalCount == 0) {
		totalCount = 1;
	}
	PageUtil page = new PageUtil(nowPage, totalCount);
		
	// 데이터베이스 작업을 한다.
	ArrayList<QnaVO> list = qDAO.searchQna(page.getStartCont(), page.getEndCont(), type, input);
		
		
		req.setAttribute("LIST", list);
		req.setAttribute("PAGE", page);
		req.setAttribute("TYPE", type);
		req.setAttribute("INPUT", input);
		
		
		return view;
	}

}
