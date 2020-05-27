package com.team.www.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.www.dao.MemberDAO;
import com.team.www.vo.InfoVO;
import com.team.www.vo.MemberVO;


public class MainController implements ClsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/main/main.jsp";
		
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		MemberDAO mDAO = new MemberDAO();
		list = mDAO.getTen();
		
		ArrayList<InfoVO> list1 = new ArrayList<InfoVO>();
		list1 = mDAO.getDate();
		
		
		req.setAttribute("LIST", list);
		req.setAttribute("LIST1", list1);
		return view;
	}
	
}
	


