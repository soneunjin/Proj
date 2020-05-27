package com.team.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import com.team.www.DB.WebDBCP;
import com.team.www.sql.InsertSQL;
import com.team.www.vo.InsertVO;
public class InsertDAO {
	WebDBCP db;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	InsertSQL iSQL;
	public InsertDAO() {
		
		db = new WebDBCP();
		iSQL = new InsertSQL();
	}
		
		// 사업자 등록 처리
	public int INSERT_CO (String sid, String bno, String bname, String btel, String bloc, String bceo ) {
		int cnt =0;
		con = db.getCon();
		String sql = iSQL.getSQL(iSQL.SEL_INSERT_CO);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, sid);
			pstmt.setString(2, bno);
			pstmt.setString(3, bname);
			pstmt.setString(4,	btel);
			pstmt.setString(5, bloc);
			pstmt.setString(6, bceo);
			cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
}
