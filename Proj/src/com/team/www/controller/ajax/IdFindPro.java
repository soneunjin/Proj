package com.team.www.controller.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.www.dao.MemberDAO;

@WebServlet("*.abc")
public class IdFindPro extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) {
		
		String sid = req.getParameter("name");
		System.out.println(sid);
		String phone = req.getParameter("phone");
		System.out.println(phone);
		
		MemberDAO mDAO = new MemberDAO();
		String user_id = mDAO.id_find(sid, phone);
		System.out.println(user_id);
		
		try {
			PrintWriter pw = resp.getWriter();
			pw.println("{");
			pw.println("	\"memid\": " + "\"" + user_id + "\"");
			pw.println("}");
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	
	
}
