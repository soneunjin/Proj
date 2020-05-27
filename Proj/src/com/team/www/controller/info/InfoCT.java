package com.team.www.controller.info;

import java.util.*;
import javax.servlet.http.*;

import com.team.www.controller.*;
import com.team.www.dao.*;
import com.team.www.vo.*;

public class InfoCT implements ClsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/info/infoCT.jsp";
		
		System.out.println("왔습니다");
		
		  InfoDAO iDAO = new InfoDAO();
		 
		  ArrayList<InfoVO> list = iDAO.selCTTlist();
		  
		  req.setAttribute("INFO", list);
		 
		
		return view;
	}

}
