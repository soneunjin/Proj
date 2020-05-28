package com.team.www.dao;

import java.util.*;
import java.sql.*;

import com.team.www.DB.*;
import com.team.www.sql.*;
import com.team.www.vo.*;

public class QnaDAO {
	WebDBCP db;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	QnaVO qVO;
	QnaSQL qSQL;
	public QnaDAO() {
		db = new WebDBCP();
		qSQL = new QnaSQL();
	}
	
	// 작성된 글 검색 결과 전담 처리 함수
	public ArrayList<QnaVO> searchQna(int startCont, int endCont, String type, String input){
		ArrayList<QnaVO> list = new ArrayList<QnaVO>();
		
		con = db.getCon();
		String sql = qSQL.getSQL(qSQL.SEARCH_RESULT_LIST);
		
		// 카테고리 입력을 equals 함수로 비교하여 임의의(#) 값을 입력값으로 바꾼다
		if(type.equals("qtt")) {
			sql = sql.replaceAll("#", "qtt");
		} else if(type.equals("qip")) {
			sql = sql.replaceAll("#", "qip");
		} else if(type.equals("name")) {
			sql = sql.replaceAll("#", "name");
		}
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, input);
			pstmt.setInt(2, startCont);
			pstmt.setInt(3, endCont);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				QnaVO qVO = new QnaVO();
				qVO.setQtt(rs.getString("qtt"));
				qVO.setQip(rs.getString("qip"));
				qVO.setQno(rs.getInt("qno"));
				qVO.setName(rs.getString("name"));
				qVO.setQqDate(rs.getDate("today"));
				qVO.setQqTime(rs.getTime("today"));
				qVO.setqDate();
				qVO.setOk(rs.getString("ok"));
				list.add(qVO);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		return list;
	}
	
	// 질문글 검색한 총 게시물 수 조회 전담 처리 함수
		public int getResultCount(String type ,String input) {
			int cnt = 0;
			
			// 커넥션 얻어오고
			con = db.getCon();
			// 질의명령 가져오고
			String sql = qSQL.getSQL(qSQL.SEL_RESULT_CNT);
			// pstmt 얻어오고
			if(type.equals("qtt")) {
				sql = sql.replaceAll("#", "qtt");
			} else if(type.equals("qip")) {
				sql = sql.replaceAll("#", "qip");
			} else if(type.equals("name")) {
				sql = sql.replaceAll("#", "name");
			}
			pstmt = db.getPSTMT(con, sql);
			try {
				pstmt.setString(1, input);
				// 질의명령 보내고 결과 받고
				rs = pstmt.executeQuery();
				// 데이터 꺼내고
				rs.next();
				cnt = rs.getInt("cnt");
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				db.close(rs);
				db.close(stmt);
				db.close(con);
			}
			return cnt;
			
		}
	
	// 작성된 qna 글 전부 가져오는 기능 전담 처리 함수
	public ArrayList<QnaVO> getQlist(){
		ArrayList<QnaVO> allQlist = new ArrayList<QnaVO>();
		// 할일
		// 1. 커넥션 가져오고
		con = db.getCon();
		
		// 2. 질의명령 가져오고
		String sql = qSQL.getSQL(qSQL.SEL_QLIST);
		
		stmt = db.getSTMT(con);
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				QnaVO qVO = new QnaVO();
				qVO.setQno(rs.getInt("qno"));
				qVO.setQtt(rs.getString("qtt"));
				qVO.setName(rs.getString("name"));
				qVO.setQqDate(rs.getDate("today"));
				qVO.setQqTime(rs.getTime("today"));
				qVO.setqDate();
				allQlist.add(qVO);
			}
		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		return allQlist;
	}
	
	public ArrayList<QnaVO> getQlist(int startCont, int endCont){
		ArrayList<QnaVO> allQlist = new ArrayList<QnaVO>();
		// 할일
		// 1. 커넥션 가져오고
		con = db.getCon();
		
		// 2. 질의명령 가져오고
		String sql = qSQL.getSQL(qSQL.SEL_ALL_QLIST);
		
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, startCont);
			pstmt.setInt(2, endCont);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				QnaVO qVO = new QnaVO();
				qVO.setQno(rs.getInt("qno"));
				qVO.setQtt(rs.getString("qtt"));
				qVO.setName(rs.getString("name"));
				qVO.setQqDate(rs.getDate("today"));
				qVO.setQqTime(rs.getTime("today"));
				qVO.setqDate();
				qVO.setOk(rs.getString("ok"));
				allQlist.add(qVO);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return allQlist;
	}
	
	// Q&A 데이터베이스 입력 전담 처리 함수
	public int addData(String qtt, String qip, String id) {
		int cnt = 0;
		
		con = db.getCon();
		
		String sql = qSQL.getSQL(qSQL.ADD_QNA);
		
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, qtt);
			pstmt.setString(2, qip);
			pstmt.setString(3, id);
			
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		
		return cnt;
	}
	
	// qna 총 게시물 수 조회 전담 처리 함수
	public int getTotalCount() {
		int cnt = 0;
		
		// 커넥션 얻어오고
		con = db.getCon();
		// 질의명령 가져오고
		String sql = qSQL.getSQL(qSQL.SEL_AQCNT);
		// stmt 얻어오고
		stmt = db.getSTMT(con);
		try {
			// 질의명령 보내고 결과 받고
			rs = stmt.executeQuery(sql);
			// 데이터 꺼내고
			rs.next();
			cnt = rs.getInt("cnt");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		
		return cnt;
	}
	
	public ArrayList<QnaVO> getDetail(int qno) {
		ArrayList<QnaVO> list = new ArrayList<QnaVO>();
		
		con = db.getCon();
		
		String sql = qSQL.getSQL(qSQL.SEL_QNO_QNA);
		
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, qno);
			pstmt.setInt(2, qno);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				QnaVO qVO = new QnaVO();
				qVO.setQno(rs.getInt("qno"));
				qVO.setQtt(rs.getString("qtt"));
				qVO.setQip(rs.getString("qip"));
				qVO.setQqDate(rs.getDate("today"));
				qVO.setQqTime(rs.getTime("today"));
				qVO.setqDate();
				qVO.setQorno(rs.getInt("qorno"));
				qVO.setName(rs.getString("name"));
				qVO.setMemid(rs.getString("memid"));
				list.add(qVO);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return list;
	}
	
	
	// qna 상세보기페이지에서 글 삭제 요청 전담 처리 함수
	public int delQna(int qno) {
		int cnt = 0;
		con = db.getCon();
		
		String sql = qSQL.getSQL(qSQL.DEL_QNA);
		
		pstmt = db.getPSTMT(con, sql);
		
		try {
			pstmt.setInt(1, qno);
			
			cnt = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	// 글 작성 form 에서 회원이름 요청 전담 처리 함수
	public String getMname(String mid) {
		String str = "";
		con = db.getCon();
		String sql = qSQL.getSQL(qSQL.SEL_QNA_MNAME);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			rs.next();
			
			str = rs.getString("name");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return str;
	}
	
	// QNA 작성글 수정 요청 전담 처리 함수
	public int modiData(String qtt, String qbd, int qno) {
		int cnt = 0;
		con = db.getCon();
		String sql = qSQL.getSQL(qSQL.MODI_QNA);
		pstmt = db.getPSTMT(con, sql);
		
		try {
			pstmt.setString(1, qtt);
			pstmt.setString(2, qbd);
			pstmt.setInt(3, qno);
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	// QNA 답변 입력 요청 전담 처리 함수
	public int addQnaAns(String aqtt, String aqbd, int upno, String mid) {
		int cnt = 0;
		con = db.getCon();
		String sql = qSQL.getSQL(qSQL.ADD_QNA_ANS);
		pstmt = db.getPSTMT(con, sql);
		
		try {
			pstmt.setString(1, aqtt);
			pstmt.setString(2, aqbd);
			pstmt.setInt(3, upno);
			pstmt.setString(4, mid);
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	// QNA 답변 출력 요청 전담 처리 함수
	public QnaVO selQnaAns(int qorno, String mid) {
		QnaVO qVO = new QnaVO();
		con = db.getCon();
		String sql = qSQL.getSQL(qSQL.SEL_QNA_ANS);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, qorno);
			pstmt.setString(2, mid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				qVO.setQtt(rs.getString("qtt"));
				qVO.setQip(rs.getString("qip"));
				qVO.setQqDate(rs.getDate("today"));
				qVO.setQqTime(rs.getTime("today"));
				qVO.setqDate();
				qVO.setName(rs.getString("name"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return qVO;
	}
	
	// 답변이 달린 글 번호 전체 조회하는 처리 전담 함수
	public int UPDok(int qno){
		int cnt = 0;
		con = db.getCon();
		String sql = qSQL.getSQL(qSQL.UPD_OK);
		pstmt = db.getPSTMT(con, sql);
		
		try {
			pstmt.setInt(1, qno);
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		
		return cnt;
	}
	

	
}
