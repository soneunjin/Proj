package com.team.www.controller.member;

import javax.servlet.http.*;

import com.team.www.controller.ClsController;
import com.team.www.dao.*;

public class JoinProc implements ClsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/Project/main.cls";
		req.setAttribute("isRedirect", true);
		
		// 파라미터 가져오고
		String sid = req.getParameter("email");
		String spw = req.getParameter("pwe");
		String phone = req.getParameter("phone");
		String name = req.getParameter("idx");
		String bir = req.getParameter("birth");
		String cano = req.getParameter("opt");
		
		int carno = 0;
		try {
			carno = Integer.parseInt(cano);
		} catch(Exception e) {}
		MemberDAO mDAO = new MemberDAO();
		int cnt = mDAO.addMember(sid, spw, phone, name, bir, carno);
		
		
		return view;
	}
}


