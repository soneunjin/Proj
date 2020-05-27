package com.team.www.controller.member;

import javax.servlet.http.*;

import com.team.www.controller.ClsController;

public class Check implements ClsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/member/login.jsp";
		return view;
	}

}
