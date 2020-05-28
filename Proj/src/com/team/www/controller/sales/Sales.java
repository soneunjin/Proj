package com.team.www.controller.sales;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.www.controller.ClsController;
import com.team.www.dao.SalesDAO;
import com.team.www.util.PageUtil;
import com.team.www.vo.SalesVO;

public class Sales implements ClsController {
 
	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/sales/sales.jsp";
		int nowPage = 1;
		String strPage = req.getParameter("nowPage");
		try {
			nowPage = Integer.parseInt(strPage);
		} catch(Exception e) {}
		SalesDAO sDAO= new SalesDAO();
		int totalCount = sDAO.getTotal();
//		
		PageUtil page = new PageUtil(nowPage, totalCount, 5, 5);
		ArrayList<SalesVO> list = sDAO.getAllList(page);
//		ArrayList<SalesVO> list = sDAO.getAllList();
		
		req.setAttribute("LIST", list);
		req.setAttribute("PAGE", page);
		return view;
	}

}
