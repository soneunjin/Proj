package com.team.www.controller.sales;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.www.controller.ClsController;

public class Sales_write implements ClsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/sales/sales_write.jsp";
		if((String)req.getSession().getAttribute("SID") == null){
			req.setAttribute("isRedirect", true);
			view = "/Project/member/login.cls";
		}
		return view;
	}

}
