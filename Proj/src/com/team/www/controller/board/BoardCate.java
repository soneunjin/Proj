package com.team.www.controller.board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.www.controller.ClsController;
import com.team.www.dao.BoardDAO;
import com.team.www.util.PageUtil;
import com.team.www.vo.BoardVO;

public class BoardCate implements ClsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/board/cboard.jsp";
//		req.setAttribute("isRedirect", true);

		int nowPage = 1;
		String strPage = req.getParameter("nowPage");
		try {
			nowPage = Integer.parseInt(strPage);

		} catch (Exception e) {
		}
		BoardDAO bDAO = new BoardDAO();
		String cate = req.getParameter("tab");
		//system.out.println("아무거나 " + cate);
		// 3. DB에서 데이터 가져오고
		// 4. 데이터 받고
		int totalCount = bDAO.getCTotal(cate);
		//system.out.println("TcC" + totalCount);
		
		PageUtil page = new PageUtil(nowPage, totalCount, 10, 3);
		ArrayList<BoardVO> clist = bDAO.getCateList(cate, page);
		//system.out.println("lsit" + clist.size());

		// 5. 화면에 심고
		req.setAttribute("LIST", clist);
		req.setAttribute("PAGE", page);
		req.setAttribute("CAT", cate);

		// 6. view를 부르고
		return view;
	}

}
