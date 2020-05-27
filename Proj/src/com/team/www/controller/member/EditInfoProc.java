package com.team.www.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.www.controller.ClsController;
import com.team.www.dao.MemberDAO;

public class EditInfoProc implements ClsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/main/main.jsp";
		
		String memid = req.getParameter("memid");
		String phone = req.getParameter("phone");
		System.out.println(phone);
		String cano = req.getParameter("opt");
		System.out.println(cano);
		
		int carno = 0;
		try {
			carno = Integer.parseInt(cano);
		} catch(Exception e) {}
		MemberDAO mDAO = new MemberDAO();
		int cnt = mDAO.EIDT_INFO(memid, phone, carno);
		
		
		return view;
	}

}
