package com.team.www.controller.sales;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.www.controller.ClsController;
import com.team.www.dao.SalesDAO;

public class Sales_modifyProc implements ClsController {
 
	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/Project/sales/sales.cls";
		
		// 경로??
		req.setAttribute("isRedirect", true);
		String spno = req.getParameter("pno");
		//system.out.println("proc.pno : " + spno);
		String sptt = req.getParameter("ptt");
		String spbd = req.getParameter("pbd");
		String scate = req.getParameter("cate");
		//system.out.println("modiProc.pno : " + spno);
		//system.out.println("modiProc.sptt : " + sptt);
		//system.out.println("modiProc.spbd : " + spbd);
		//system.out.println("modiProc.scate : " + scate);
		int pno = Integer.parseInt(spno);
		
		SalesDAO sDAO = new SalesDAO();
		int cnt = sDAO.modifyData(sptt, spbd, scate, pno);
		return view;
	}

}
