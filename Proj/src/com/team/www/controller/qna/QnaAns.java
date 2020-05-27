package com.team.www.controller.qna;

import javax.servlet.http.*;

import com.team.www.controller.*;
import com.team.www.dao.*;
import com.team.www.vo.*;

public class QnaAns implements ClsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		resp.setCharacterEncoding("UTF-8");
		
		req.setAttribute("isRedirect", null);
		
		System.out.println("비동기 도착");
		String sid = req.getParameter("sid");
		String astt = req.getParameter("astt");
		String asbd = req.getParameter("asbd");
		String sqno = req.getParameter("qqno");
		int qno = 0;
		try {
			qno = Integer.parseInt(sqno);   // 기본값 0  주고 try로 감싸고
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(sid);
		System.out.println(astt);
		System.out.println(asbd);
		System.out.println(qno);
		
		QnaDAO qDAO = new QnaDAO();
		int result = qDAO.addQnaAns(astt, asbd, qno, sid);
		
		int cnt = qDAO.UPDok(qno);
		
		QnaVO qVO = qDAO.selQnaAns(qno, sid);
		
		StringBuffer buff = new StringBuffer();
			buff.append("{");
			buff.append("	\"anstt\": \"" + qVO.getQtt() + "\",");
			buff.append("	\"ansbd\": \"" + qVO.getQip() + "\",");
			buff.append("	\"name\": \"" + qVO.getName() + "\",");
			buff.append("	\"adate\": \"" + qVO.getqDate() + "\"");
			buff.append("}");
		return buff.toString();
	}

}
