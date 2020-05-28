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
		System.out.println("proc.pno : " + spno);
		String sptt = req.getParameter("ptt");
		String spbd = req.getParameter("pbd");
		String scate = req.getParameter("cate");
		System.out.println("modiProc.pno : " + spno);
		System.out.println("modiProc.sptt : " + sptt);
		System.out.println("modiProc.spbd : " + spbd);
		System.out.println("modiProc.scate : " + scate);
		int pno = Integer.parseInt(spno);
		
		SalesDAO sDAO = new SalesDAO();
		int cnt = sDAO.modifyData(sptt, spbd, scate, pno);
		return view;
	}

}
