package com.team.www.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.www.controller.ClsController;
import com.team.www.dao.MemberDAO;

public class PassEdit implements ClsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/main/main.jsp";
		
		String sid = (String) req.getSession().getAttribute("SID");
		MemberDAO mDAO = new MemberDAO();
		
		String pw = req.getParameter("gpw");
		System.out.println(pw);
		int cnt = mDAO.SEL_COUNT(sid, pw);
		System.out.println(sid);
		String pwe = req.getParameter("pw");
		System.out.println(pwe);
	
		if(cnt == 1) {
			int mao = mDAO.passEidt(pwe, sid);
		} else {
			view = "/main/main2.jsp";
			
		}
		return view;
	}

}
