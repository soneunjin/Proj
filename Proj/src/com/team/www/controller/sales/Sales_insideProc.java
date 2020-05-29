package com.team.www.controller.sales;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.www.controller.ClsController;
import com.team.www.dao.SalesDAO;
import com.team.www.vo.FileVO;
import com.team.www.vo.SalesVO;

public class Sales_insideProc implements ClsController {
 
	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/sales/salesRelay.jsp";
		if((String)req.getSession().getAttribute("SID") == null) {
			req.setAttribute("isRedirect", true);
			view = "/Project/member/login.cls";
		}
		String sno = req.getParameter("pno");
		String memid = req.getParameter("memid");
//		//system.out.println("insideProc.memid : " + memid);
		String strPage = req.getParameter("nowPage");
		int pno = 0;
		try{
			pno = Integer.parseInt(sno);
		} catch(Exception e) {}
		SalesDAO sDAO = new SalesDAO();
		SalesVO iVO = sDAO.selMemid(pno);
		//system.out.println("inside.Proc : " + iVO.getMemid());
		SalesVO sVO = sDAO.getContent(pno);
		FileVO imgVO = sDAO.selImg(pno);
		SalesVO carVO = sDAO.selCar(pno);
		req.setAttribute("nowPage", strPage);
		req.setAttribute("DATA", sVO);
		req.setAttribute("IMG", imgVO.getSavename());
		req.setAttribute("PNO", pno);
		req.setAttribute("ID", iVO.getMemid());
		req.setAttribute("CAR", carVO.getCarct());
		
		return view;
	}

}
