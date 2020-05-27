package com.team.www.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team.www.controller.ClsController;

public class LoginForm1 implements ClsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/member/login.jsp";
		HttpSession session = req.getSession();
		String tid = (String) session.getAttribute("SID");
		if(tid != null) {
			req.setAttribute("isRedirect", true);
			view = "/Project/main.cls";
		}
		
		return view;
	}

}
