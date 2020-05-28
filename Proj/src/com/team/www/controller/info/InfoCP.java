package com.team.www.controller.info;

import java.util.*;
import javax.servlet.http.*;

import com.team.www.controller.*;
import com.team.www.dao.*;
import com.team.www.vo.*;

public class InfoCP implements ClsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/info/infoCP.jsp";
		
		
		  InfoDAO iDAO = new InfoDAO();
		 
		  ArrayList<InfoVO> list = iDAO.selACPlist();
		  
		  req.setAttribute("INFO", list);
		 
		
		return view;
	}

}
