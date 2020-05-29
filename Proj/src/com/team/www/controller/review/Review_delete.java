package com.team.www.controller.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.www.controller.ClsController;
import com.team.www.dao.ReviewDAO;

public class Review_delete implements ClsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/Project/review/review.cls";
		req.setAttribute("isRedirect", true);
		String rno = (String) req.getParameter("rno");
		int srno = Integer.parseInt(rno);
		//system.out.println("delete.srno : " + srno);
		ReviewDAO rDAO = new ReviewDAO();
		rDAO.deleteData(srno);
		return view;
	}

}
