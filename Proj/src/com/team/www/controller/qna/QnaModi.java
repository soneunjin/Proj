package com.team.www.controller.qna;

/**
 * @author 이한철
 * 
 * 		질문글 수정 요청 컨트롤러
 * 
 */
import java.util.ArrayList;

import javax.servlet.http.*;

import com.team.www.controller.*;
import com.team.www.dao.*;
import com.team.www.vo.*;

public class QnaModi implements ClsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/qna/qnaWrite.jsp";
		
		String sid = req.getParameter("sid");
		String sno = req.getParameter("qqno");
		
		int	qno = Integer.parseInt(sno);
		QnaDAO qDAO = new QnaDAO();
		ArrayList<QnaVO> list = qDAO.getDetail(qno);
		String name = qDAO.getMname(sid);
		
		
		QnaVO qVO = new QnaVO();
		QnaVO aVO = new QnaVO();
		
		for(QnaVO vo : list) {
			if(vo.getQorno() == -1) {
				qVO = vo;
			} else {
				aVO = vo;
			}
		}
		req.setAttribute("SIZE", list.size()); 
		req.setAttribute("DETAIL", qVO);
		req.setAttribute("qno", qno);
		req.setAttribute("NAME", name);
		 
		
		return view;
	}

}
