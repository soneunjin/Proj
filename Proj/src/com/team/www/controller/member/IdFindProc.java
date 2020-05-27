package com.team.www.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team.www.controller.ClsController;
import com.team.www.dao.MemberDAO;

public class IdFindProc implements ClsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/member/id_find.jsp";
		// 파라미터 가져오고
		String sid = req.getParameter("name");
		String phone3 = req.getParameter("phone");
		String phone1 = req.getParameter("phone1");
		String phone2 = req.getParameter("phone2");
		String phone = phone3 + phone1 + phone2;
		MemberDAO mDAO = new MemberDAO();
		String user_id = mDAO.id_find(sid, phone);
		
		req.setAttribute("LIST",user_id);
		return view;
	}

}
