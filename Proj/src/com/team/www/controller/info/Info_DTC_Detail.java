package com.team.www.controller.info;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.www.dao.InfoDAO;
import com.team.www.vo.InfoVO;



@WebServlet("*.dtc")
public class Info_DTC_Detail extends HttpServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) {
		resp.setCharacterEncoding("UTF-8");
		String sname = req.getParameter("name");
		
		InfoVO iVO = new InfoVO();
		
		InfoDAO iDAO = new InfoDAO();
		
		iVO = iDAO.selCTTInfo(sname);
		
		PrintWriter pw = null;
		
		try {
			pw = resp.getWriter();
			
			pw.println("{");
			pw.println("	\"name\": \""+ iVO.getIfname()+"\",");
			pw.println("	\"tel\": \""+ iVO.getIftel()+"\",");
			pw.println("	\"addr\": \""+ iVO.getIfaddr()+"\",");
			pw.println("	\"link\": \""+ iVO.getIflink()+"\"");
			pw.println("}");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
