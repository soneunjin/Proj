package com.team.www.dao;
import java.util.*;
import java.sql.*;

import com.team.www.DB.*;
import com.team.www.sql.*;
import com.team.www.vo.*;

public class InfoDAO {
	WebDBCP db;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	InfoVO iVO;
	InfoSQL iSQL;
	public InfoDAO() {
		db = new WebDBCP();
		iSQL = new InfoSQL();
	}
	
	
	// 자동차극장 정보 전부 가져오는 기능 전담 처리 함수
	public ArrayList<InfoVO> selCTTlist(){
		 ArrayList<InfoVO> list	= new ArrayList<InfoVO>();
		 con = db.getCon();
		 String sql = iSQL.getSQL(iSQL.SEL_CTTLIST);
		 stmt = db.getSTMT(con);
		 try {
			 rs = stmt.executeQuery(sql);
			 while(rs.next()) {
				 InfoVO iVO = new InfoVO();
				 iVO.setIfno(rs.getInt("ifno"));
				 iVO.setIfname(rs.getString("ifname"));
				 iVO.setIftel(rs.getString("iftel"));
				 iVO.setIfpri(rs.getString("ifpri"));
				 iVO.setIfaddr(rs.getString("ifaddr"));
				 iVO.setIflink(rs.getString("iflink"));
				 list.add(iVO);
			 }
		 } catch(Exception e) {
			 e.printStackTrace();
		 } finally {
			 db.close(rs);
			 db.close(stmt);
			 db.close(con);
		 }
		 return list;
	}
	// 오토캠핑장 정보 전부 가져오는 기능 전담 처리 함수
	public ArrayList<InfoVO> selACPlist(){
		ArrayList<InfoVO> list	= new ArrayList<InfoVO>();
		con = db.getCon();
		String sql = iSQL.getSQL(iSQL.SEL_ACPLIST);
		stmt = db.getSTMT(con);
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				InfoVO iVO = new InfoVO();
				iVO.setIfno(rs.getInt("ifno"));
				iVO.setIfname(rs.getString("ifname"));
				iVO.setIftel(rs.getString("iftel"));
				iVO.setIfpri(rs.getString("ifpri"));
				iVO.setIfaddr(rs.getString("ifaddr"));
				iVO.setIflink(rs.getString("iflink"));
				list.add(iVO);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		return list;
	}
	
	// 승차검진소 정보 전부 가져오는 기능 전담 처리 함수
	public ArrayList<InfoVO> selDTClist(){
		ArrayList<InfoVO> list	= new ArrayList<InfoVO>();
		con = db.getCon();
		String sql = iSQL.getSQL(iSQL.SEL_DTCLIST);
		stmt = db.getSTMT(con);
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				InfoVO iVO = new InfoVO();
				iVO.setIfno(rs.getInt("ifno"));
				iVO.setIfname(rs.getString("ifname"));
				iVO.setIftel(rs.getString("iftel"));
				iVO.setIfaddr(rs.getString("ifaddr"));
				list.add(iVO);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		return list;
	}
	
	
	// 비동기통신 처리 선택된 데이터 가져오기
	public InfoVO selCTTInfo(String name) {
		InfoVO iVO = new InfoVO();
		con = db.getCon();
		String sql = iSQL.getSQL(iSQL.SEL_CTT_INFO);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			rs.next();
			iVO.setIfname(rs.getString("ifname"));
			iVO.setIfaddr(rs.getString("ifaddr"));
			iVO.setIfpri(rs.getString("ifpri"));
			iVO.setIftel(rs.getString("iftel"));
			iVO.setIflink(rs.getString("iflink"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return iVO;
	}
	
	
}
