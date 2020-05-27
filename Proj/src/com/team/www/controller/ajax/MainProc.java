package com.team.www.controller.ajax;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.www.dao.MemberDAO;
import com.team.www.vo.InfoVO;

@WebServlet("*.main")
public class MainProc extends HttpServlet {
	
		public void service(HttpServletRequest req, HttpServletResponse resp) {
			
			MemberDAO mDAO = new MemberDAO();
			ArrayList<InfoVO> list = mDAO.getDate();
			
			try {
				PrintWriter pw = resp.getWriter();
				pw.print("{");
				pw.print(" \"list\": " + "\"" + list + "\"");
				pw.print("}");
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
}