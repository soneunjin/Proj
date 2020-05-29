/**
 * @author 이진수
 * 
 */
package com.team.www.controller.board;

import javax.servlet.http.*;

import com.team.www.controller.ClsController;
import com.team.www.dao.BoardDAO;
import com.team.www.vo.BoardVO;

public class CommentEditProc implements ClsController {

	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/board/commentEdit.jsp";

//		req.setAttribute("isRedirect", true);
		String eno = req.getParameter("no");
		String bdbd = req.getParameter("bd");
		int bno = 0;
		try {
			bno = Integer.parseInt(eno);
		} catch (Exception e) {
		}
		//system.out.println(eno + " , " + bdbd);
		// 3. DB에서 데이터 가져오고
		// 4. 데이터 받고
		BoardDAO bDAO = new BoardDAO();
		req.setAttribute("no", bno);
		req.setAttribute("bd", bdbd);
		//system.out.println("위치확인");
		// 5. 화면에 심고

		return view;

	}

}
