package com.team.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.team.www.DB.WebDBCP;
import com.team.www.sql.ReviewSQL;
import com.team.www.util.PageUtil;
import com.team.www.vo.ReviewVO;

public class ReviewDAO {
	WebDBCP db;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	ReviewSQL rSQL;
	public ReviewDAO() {
		db = new WebDBCP();
		rSQL = new ReviewSQL();
	}
	
	// 리뷰 리스트 조회
	public ArrayList<ReviewVO> getReList(PageUtil page){
		ArrayList<ReviewVO> list = new ArrayList<ReviewVO>();
		con = db.getCon();
		String sql = rSQL.getSQL(rSQL.RE_LIST);
		pstmt = db.getPSTMT(con,sql);
		try {
			pstmt.setInt(1, page.getStartCont());
			pstmt.setInt(2, page.getEndCont());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReviewVO rVO = new ReviewVO();
				rVO.setMemid(rs.getString("memid"));
				rVO.setRno(rs.getInt("rno"));
				rVO.setPtt(rs.getString("ptt"));
				rVO.setRtt(rs.getString("rtt"));
				rVO.setRbd(rs.getString("rbd"));
				rVO.setMemno(rs.getInt("memno"));
				rVO.setRst(rs.getInt("rst"));
//				rVO.setReDate(rs.getDate("today"));
//				rVO.setReTime(rs.getTime("today"));
//				rVO.setToday();
				
				list.add(rVO);
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
	
	public int getTotal() {
		int cnt = 0;
		con = db.getCon();
		String sql = rSQL.getSQL(rSQL.RE_TOTAL_CNT);
		stmt = db.getSTMT(con);
		try {
			rs = stmt.executeQuery(sql);
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
	// 리뷰 등록
	public int insertReview(int pno, String rtt, String rbd, String sid, int rst) {
		int cnt = 0;
		con = db.getCon();
		String sql = rSQL.getSQL(rSQL.ADD_DATA);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, pno);
			pstmt.setString(2, rtt);
			pstmt.setString(3, rbd);
			pstmt.setString(4, sid);
			pstmt.setInt(5, rst);
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	// 리뷰 삭제
	public int deleteData(int rno) {
		int cnt = 0;
		con = db.getCon();
		String sql = rSQL.getSQL(rSQL.DEL_DATA);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, rno);
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}

}
