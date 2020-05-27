package com.team.www.controller.ajax;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.www.dao.MemberDAO;


@WebServlet("/member/id.ck")
public class IdCheck extends HttpServlet {
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) {
		// 할일
		// 1. 데이터 받고
		String sid = req.getParameter("email");
		System.out.println(sid);// getParameter(키값);
		// 2. 데이터베이스 작업해서 결과 받고
		int cnt = new MemberDAO().getIdCnt(sid);
		// 3. 결과를 제이슨 문서로 만들어서 응답해주고
		PrintWriter pw = null;
		try {
			pw = resp.getWriter();
			// 아래 내용이 ajax success: function(data) -> data 에 담긴다
			pw.println("{");
			pw.println("	\"cnt\": " + cnt);
			pw.println("}");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
