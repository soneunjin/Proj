package com.team.www.controller.member;

import javax.servlet.http.*;

import com.team.www.controller.*;

public class LogoutProc implements ClsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/Project/main.cls";
		req.setAttribute("isRedirect", true);
		HttpSession session = req.getSession();
		session.removeAttribute("SID");
		return view;
	}

}
