package com.team.www.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.www.controller.ClsController;

public class MainForm implements ClsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/main/main2.jsp";
		return view;
	}

}
