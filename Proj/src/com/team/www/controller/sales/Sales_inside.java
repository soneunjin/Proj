package com.team.www.controller.sales;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.www.controller.ClsController;
import com.team.www.dao.SalesDAO;
import com.team.www.vo.FileVO;
import com.team.www.vo.SalesVO;

public class Sales_inside implements ClsController {
 
	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/sales/sales_inside.jsp";
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		SalesDAO sDAO = new SalesDAO();
		String pno = req.getParameter("pno");
		SalesVO sVO = new SalesVO();
		String memid = req.getParameter("memid");
		String savename = req.getParameter("img");
		//system.out.println("************** sname : " + savename);
		String car = req.getParameter("car");
		sVO.setMemid(req.getParameter("memid"));
		//system.out.println("inside.memid : " + memid);
		sVO.setPno(Integer.parseInt(req.getParameter("pno")));
		sVO.setBcnt(Integer.parseInt(req.getParameter("bcnt")));
		sVO.setPtt(req.getParameter("ptt"));
		sVO.setPbd(req.getParameter("pbd"));
		sVO.setBceo(req.getParameter("bceo"));
		sVO.setBloc(req.getParameter("bloc"));
		sVO.setPbd(req.getParameter("pbd"));
//		sVO.setImgno(Integer.parseInt(req.getParameter("imgno")));
		sVO.setCate(req.getParameter("cate"));
		sVO.setToday(req.getParameter("today"));
		ArrayList<FileVO> list = new ArrayList<FileVO>();
		String[] simgno = req.getParameterValues("imgno");
		int len = 0;
		try {
			len = simgno.length;
		} catch(Exception e) {}
		String[] oriname;
//		String[] savename;
		if(len != 0) {
			oriname = req.getParameterValues("oriname");
//			savename = req.getParameterValues("savename");
			for(int i = 0; i < len; i++) {
				FileVO fVO = new FileVO();
				fVO.setImgno(Integer.parseInt(simgno[i]));
				fVO.setOriname(oriname[i]);
//				fVO.setSavename(savename[i]);
				list.add(fVO);
			}
			sVO.setFile(list);
		}
		req.setAttribute("LIST", list);
		req.setAttribute("nowPage", req.getParameter("nowPage"));
		req.setAttribute("DATA", sVO);
		req.setAttribute("PNO", pno);
		req.setAttribute("IMG", savename);
		req.setAttribute("CAR", car);
		req.setAttribute("ID", memid);
		
		return view;
	}

}
