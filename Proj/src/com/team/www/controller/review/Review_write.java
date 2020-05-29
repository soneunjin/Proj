package com.team.www.controller.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.bcel.internal.classfile.Attribute;
import com.team.www.controller.ClsController;

public class Review_write implements ClsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/review/review_write.jsp";
		HttpSession session = req.getSession();
		String sid = (String)session.getAttribute("SID");
		String pno = req.getParameter("pno");
		//system.out.println("pno : " + pno);
		if(sid == null || sid.length() == 0) {
			view = "/Project/member/login.cls";
			req.setAttribute("isRedirect", true);
		}
		req.setAttribute("PNO", pno);
		return view;
	}

}
