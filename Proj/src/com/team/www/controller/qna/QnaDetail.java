package com.team.www.controller.qna;
/**
 * @author 이한철
 * 	
 * 		작성글 상세보기 페이지 보기 컨트롤러
 */
import java.util.ArrayList;

import javax.servlet.http.*;

import com.team.www.controller.*;
import com.team.www.dao.*;
import com.team.www.vo.*;

public class QnaDetail implements ClsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/qna/qnaDetail.jsp";
		String mid = req.getParameter("sid");
		String sno = req.getParameter("qqno");
		int qno = Integer.parseInt(sno);
		
		QnaVO qVO = null;
		QnaVO aVO = null;
		
		QnaDAO qDAO = new QnaDAO();
		String sid = qDAO.getMname(mid);
		ArrayList<QnaVO> list = qDAO.getDetail(qno);
		for(QnaVO vo : list) {
			if(vo.getQorno() == -1) {
				qVO = vo;
			} else {
				aVO = vo;
			}
		}

		req.setAttribute("SID", mid);
		req.setAttribute("NAME", sid);
		req.setAttribute("QUEST", qVO);
		req.setAttribute("ANSWER", aVO);
		
		req.setAttribute("qno", qno);
		 
		return view;
	}

}
