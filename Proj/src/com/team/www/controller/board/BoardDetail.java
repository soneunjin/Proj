package com.team.www.controller.board;

import java.util.*;

import javax.servlet.http.*;

import com.team.www.controller.ClsController;
import com.team.www.dao.BoardDAO;
import com.team.www.vo.BoardVO;

public class BoardDetail implements ClsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/board/boardDetail.jsp";
		String sno = req.getParameter("bno");
		System.out.println(sno);
		int bno = 0;
		try {
			bno = Integer.parseInt(sno);
		} catch (Exception e) {
		}

		// 3. DB에서 데이터 가져오고
		// 4. 데이터 받고
		BoardDAO bDAO = new BoardDAO();
		BoardVO bVO = bDAO.getDetail(bno);
		BoardVO bVO1 = bDAO.Click(bno);
		ArrayList<BoardVO> clist = bDAO.getComList(bno);
		

		// 5. 화면에 심고
		req.setAttribute("DATA", bVO);
		req.setAttribute("CLICK", bVO1);
		req.setAttribute("LIST", clist);
		req.setAttribute("bdno", bno);
		System.out.println("여기");
		// 6. view를 부르고
		return view;

	}
}