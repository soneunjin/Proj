package com.team.www.controller.member;
import javax.servlet.http.*;

import javax.servlet.http.*;
import com.team.www.controller.ClsController;
import com.team.www.dao.*;
import com.team.www.vo.InsertVO;


public class InsertCoProc implements ClsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/Project/main.cls";
		req.setAttribute("isRedirect", true);
		HttpSession session = req.getSession();
		String sid = (String)session.getAttribute("SID");
		
		String bno = req.getParameter("bno");
		String bname = req.getParameter("bname");
		String btel = req.getParameter("btel");
		String bloc = req.getParameter("bloc");
		String bceo = req.getParameter("bceo");
//		int sbtel = Integer.parseInt(btel);
		
		System.out.println("Proc.bno : " + bno);
		System.out.println("Proc.bname : " + bname);
		System.out.println("Proc.btel : " + btel);
		System.out.println("Proc.bloc : " + bloc);
		System.out.println("Proc.bceo : " + bceo);
		InsertDAO iDAO = new InsertDAO();
		int cnt = iDAO.INSERT_CO(sid, bno, bname, btel, bloc, bceo);
		
		
//		String smemno = req.getParameter("memno");
		
//		int memno =0;
//		
//		try {
//			memno = Integer.parseInt("smemno");
//		}catch(Exception e) {}
//		InsertDAO iDAO = new InsertDAO();
//		InsertVO iVO = iDAO.INSERT_CO(memno);
//		req.setAttribute("DATA", iVO);
//		if(sid == null) {
//			
//		}
		return view;
	}

}
