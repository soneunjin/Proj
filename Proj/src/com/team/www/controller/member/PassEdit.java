package com.team.www.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.www.controller.ClsController;
import com.team.www.dao.MemberDAO;

public class PassEdit implements ClsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/main.cls";
		
		String sid = (String) req.getSession().getAttribute("SID");
		MemberDAO mDAO = new MemberDAO();
		
		String pw = req.getParameter("gpw");
		//system.out.println(pw);
		int cnt = mDAO.SEL_COUNT(sid, pw);
		// 1 이면 기존비밀번호를 정상입력했으니 변경 처리
		// 1 아니면 기존비밀번호 입력 잘못한거야 - alert 
		//system.out.println(sid);
		String pwe = req.getParameter("pw");
		//system.out.println(pwe);
		req.setAttribute("CNT", cnt);
		if(cnt == 1) {
			int mao = mDAO.passEidt(pwe, sid);
		} else {
			
			view = "/main/main2.jsp";
		}
		return view;
	}

}
