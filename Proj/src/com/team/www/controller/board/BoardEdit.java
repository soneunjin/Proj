package com.team.www.controller.board;

import java.util.*;

import javax.servlet.http.*;

import com.team.www.controller.ClsController;
import com.team.www.dao.BoardDAO;
import com.team.www.vo.BoardVO;



public class BoardEdit implements ClsController {

   @Override
   public String exec(HttpServletRequest req, HttpServletResponse resp) {
	      String view = "/board/boardEdit.jsp";
	      String eno = req.getParameter("no");
	      
	      int bno = 0;
	      try {
	         bno = Integer.parseInt(eno);
	      } catch(Exception e) {}
	      
	      // 3. DB에서 데이터 가져오고
	      // 4. 데이터 받고
	      BoardDAO bDAO = new BoardDAO();
	      BoardVO bVO = bDAO.getDetail(bno);      
	      req.setAttribute("DATA", bVO);
	      req.setAttribute("bdno",bno);
	      System.out.println("위치확인");
	      // 5. 화면에 심고
	      
	      // 6. view를 부르고
	      return view;
      
   }
}