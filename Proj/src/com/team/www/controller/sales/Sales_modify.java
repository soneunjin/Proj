package com.team.www.controller.sales;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.www.controller.ClsController;
import com.team.www.dao.SalesDAO;

public class Sales_modify implements ClsController {
 
	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/sales/sales_modify.jsp";
		String pno = req.getParameter("pno");
		int spno = 0;
		try {
			spno = Integer.parseInt(pno);
		}catch(Exception e) {}
		String ptt = req.getParameter("ptt");
		String pbd = req.getParameter("pbd");
		System.out.println("modi.pno : " + spno);
		System.out.println("modi.ptt : " + ptt);
		System.out.println("modi.pbd : " + pbd);
		req.setAttribute("PNO", spno);
		req.setAttribute("PTT", ptt);
		req.setAttribute("PBD", pbd);
		return view;
	}

}
