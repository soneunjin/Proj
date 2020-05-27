package com.team.www.controller.member;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team.www.controller.*;
import com.team.www.dao.*;
import com.team.www.vo.*;

public class InFoProc implements ClsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/main/main1.jsp";
		
		MemberDAO mDAO = new MemberDAO();
		
		String sid = (String) req.getSession().getAttribute("SID");
		System.out.println(sid + "왔습니까?");
		MemberVO mVO = mDAO.info(sid);
		
		req.setAttribute("DATA", mVO);
		System.out.println(sid + "오셨습니까?");
		return view;
	}

}
