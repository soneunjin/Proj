/**
 * 
 */
package com.team.www.controller.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.www.controller.ClsController;
import com.team.www.dao.ReviewDAO;

/**
 * @author kimsujin
 *
 */
public class ReviewProc implements ClsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/Project/review/review.cls";
		req.setAttribute("isRedirect", true);
		String pno = req.getParameter("ppno");
		int spno = Integer.parseInt(pno);
		String rtt = req.getParameter("rtt");
		String rbd = req.getParameter("rbd");
		String rst = req.getParameter("rst");
		int srst = Integer.parseInt(rst);
		String sid =(String)req.getSession().getAttribute("SID");

		ReviewDAO rDAO = new ReviewDAO();
		int cnt = rDAO.insertReview(spno, rtt, rbd, sid, srst);
		
		return view;
	}

}
