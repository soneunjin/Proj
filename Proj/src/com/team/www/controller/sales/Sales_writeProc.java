package com.team.www.controller.sales;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.team.www.controller.ClsController;
import com.team.www.dao.SalesDAO;
import com.team.www.vo.FileVO;
import com.team.www.vo.SalesVO;

public class Sales_writeProc implements ClsController {
 
	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/Project/sales/sales.cls";
		req.setAttribute("isRedirect", true);
		String sid = (String)req.getSession().getAttribute("SID");
		System.out.println("session : " + sid);
//		int pno = (int)req.getSession().getAttribute("pno");
		String path = req.getSession().getServletContext().getRealPath("images");
		MultipartRequest multi = null;
		try {
			multi = new MultipartRequest(req, path, 1024 * 1024 *10, "UTF-8", new DefaultFileRenamePolicy());
		} catch(Exception e) {
			
		}
		
		String id = multi.getParameter("sid");
		System.out.println("Proc.id : " + id);
		String ptt = multi.getParameter("ptt");
		System.out.println("Proc.ptt : " + ptt);
		String bno = multi.getParameter("bno");
		System.out.println("Proc.bno : " + bno);
		String pbd = multi.getParameter("pbd");
		System.out.println("Proc.pbd : " + pbd);
		String cate = multi.getParameter("cate");
		System.out.println("Proc.cate : " + cate);
//		String imgno = multi.getParameter("imgno");
//		int simgno = Integer.parseInt(imgno);
		SalesVO sVO = new SalesVO();
		sVO.setId(sid);
		sVO.setBno(bno);
		sVO.setPtt(ptt);
		sVO.setPbd(pbd);
		sVO.setCate(cate);
		
		System.out.println("************* sVO.id : " + sVO.getId());
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", sid);
		map.put("ptt", ptt);
		map.put("bno", bno);
		map.put("pbd", pbd);
		map.put("cate", cate);
		
		SalesDAO sDAO = new SalesDAO();
		int cnt = sDAO.addSales(map);
		if(cnt != 1) {
			view = "/Project/sales/sales.cls";
			req.setAttribute("isRedirect", true);
			return view;
		}
		FileVO fVO = new FileVO();
		fVO.setId(sid);
//		fVO.setImgno(simgno);
		System.out.println("memid : " + sid);
		fVO.setMulti(multi);
		boolean bool = sDAO.addImgInfo(fVO);
		return view;
	}
		
}
