package com.team.www.controller.member;

import javax.servlet.http.*;

import com.team.www.controller.ClsController;

public class JoinForm implements ClsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/member/login.jsp";
		return view;
	}

}
