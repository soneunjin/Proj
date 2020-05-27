package com.team.www.controller.board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.www.controller.ClsController;
import com.team.www.dao.BoardDAO;
import com.team.www.vo.BoardVO;

public class BoardDelete implements ClsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/board/board.cls";
		 String bno = req.getParameter("no");
		 System.out.println("아무거나" + bno);
		 int bdno = Integer.parseInt(bno);
	      // 3. DB에서 데이터 가져오고
	      // 4. 데이터 받고
	      BoardDAO bDAO = new BoardDAO();
	      bDAO.delete(bdno);
		return view;      
	     
	}

}
