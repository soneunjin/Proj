package com.team.www.controller.sales;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.www.controller.ClsController;
import com.team.www.dao.SalesDAO;

public class Sales_delete implements ClsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/Project/sales/sales.cls";
		req.setAttribute("isRedirect", true);
		String pno = (String)req.getParameter("pno");
		int spno = Integer.parseInt(pno);
		System.out.println("delete.spno : " + spno);
		SalesDAO sDAO = new SalesDAO();
		sDAO.deleteData(spno);
		return view;
	}
 
}
