package com.team.www.controller.review;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.www.controller.ClsController;
import com.team.www.dao.ReviewDAO;
import com.team.www.util.PageUtil;
import com.team.www.vo.ReviewVO;

public class Review implements ClsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/review/review.jsp";
		String sid = (String) req.getSession().getAttribute("SID");
		int nowPage = 1;
		String strPage = req.getParameter("nowPage");
		try {
			nowPage = Integer.parseInt(strPage);
		} catch(Exception e) {}
		
		ReviewDAO rDAO = new ReviewDAO();
		int totalCount = rDAO.getTotal();
		PageUtil page = new PageUtil(nowPage, totalCount, 5, 5);
		ArrayList<ReviewVO> list = rDAO.getReList(page);
		req.setAttribute("LIST", list);
		req.setAttribute("PAGE", page);
		return view;
	}

}
