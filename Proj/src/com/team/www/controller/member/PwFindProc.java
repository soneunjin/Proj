package com.team.www.controller.member;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team.www.controller.ClsController;
import com.team.www.dao.MemberDAO;
import com.team.www.vo.MemberVO;

public class PwFindProc implements ClsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/Project/member/login.cls";
		req.setAttribute("isRedirect", true);
		// 파라미터 가져오고
		String name = req.getParameter("name");
		//system.out.println(name);
		String memid = req.getParameter("email");
		//system.out.println(memid);
		
		String host = "smtp.naver.com";
		String user = "sej0267@naver.com";
		String password = "156478as!!";
		
		
		
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", 465);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		
		//인증 번호 생성기
        StringBuffer temp =new StringBuffer();
        Random rnd = new Random();
        for(int i=0;i<10;i++)
        {
            int rIndex = rnd.nextInt(3);
            switch (rIndex) {
            case 0:
                // a-z
                temp.append((char) ((int) (rnd.nextInt(26)) + 97));
                break;
            case 1:
                // A-Z
                temp.append((char) ((int) (rnd.nextInt(26)) + 65));
                break;
            case 2:
                // 0-9
                temp.append((rnd.nextInt(10)));
                break;
            }
        }
        String AuthenticationKey = temp.toString();
        //system.out.println(AuthenticationKey);
        

        
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user,password);
            }
        });
        
        //email 전송
        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(user, "관리자"));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(memid));
            //system.out.println(memid);
            
            //메일 제목
            msg.setSubject("안녕하세요 드루와 인증 메일입니다.");
            //메일 내용
            msg.setText("고객님의 임시비밀번호 :"+ temp + "입니다. \n 비밀번호를 변경해주세요.");
            
            Transport.send(msg);
            //system.out.println("이메일 전송");
            MemberDAO mDAO = new MemberDAO();
            
    		int pw = mDAO.passFind(AuthenticationKey, memid, name);
    		//system.out.println(AuthenticationKey + memid + name);
            
        }catch (Exception e) {
            e.printStackTrace();// TODO: handle exception
        }
        
        /*
        HttpSession saveKey = req.getSession();
        saveKey.setAttribute("AuthenticationKey", AuthenticationKey);
        //패스워드 바꿀때 뭘 바꿀지 조건에 들어가는 id
        req.setAttribute("mempw", pw);
        try {
			req.getRequestDispatcher("/member/login.jsp");
		} catch (Exception e) {}
		// MemberDAO mDAO = new MemberDAO();
		// String ab = mDAO.passFind(name, email);
		 
		 */
        
		return view;
		
		
	
	}

}
