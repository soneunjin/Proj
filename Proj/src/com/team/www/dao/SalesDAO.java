package com.team.www.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

import com.oreilly.servlet.MultipartRequest;
import com.team.www.DB.WebDBCP;
import com.team.www.sql.SalesSQL;
import com.team.www.util.PageUtil;
import com.team.www.vo.FileVO;
import com.team.www.vo.SalesVO;

public class SalesDAO {
	WebDBCP db;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	SalesSQL sSQL;
	
	public SalesDAO() {
		db = new WebDBCP();
		sSQL = new SalesSQL();
	}
	 
	public int getTotal() {
		int cnt = 0;
		con = db.getCon();
		String sql = sSQL.getSQL(sSQL.SAL_TOTAL_CNT);
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
	// 페이징처리
	public ArrayList<SalesVO> getAllList(PageUtil page){ 
		ArrayList<SalesVO> list = new ArrayList<SalesVO>();
		con = db.getCon();
		String sql = sSQL.getSQL(sSQL.SAL_LIST);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, page.getStartCont());
			pstmt.setInt(2, page.getEndCont());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SalesVO sVO = new SalesVO();
				sVO.setRno(rs.getInt("rno"));
				sVO.setPno(rs.getInt("pno"));
				sVO.setPtt(rs.getString("ptt"));
				sVO.setBceo(rs.getString("bceo"));
				sVO.setToday(rs.getString("today"));
				sVO.setBcnt(rs.getInt("bcnt"));
				list.add(sVO);
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
	// SALES 게시판 리스트 조회함수
	public ArrayList<SalesVO> getAllList(){
		ArrayList<SalesVO> list = new ArrayList<SalesVO>();
		con = db.getCon();
		String sql = sSQL.getSQL(sSQL.SAL_LIST);
		stmt = db.getSTMT(con);
		try {
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				SalesVO sVO = new SalesVO();
				sVO.setPno(rs.getInt("pno"));
//				sVO.setImgno(rs.getInt("imgno")); 썸네일 이미지 넣기
				sVO.setPtt(rs.getString("ptt"));
				sVO.setBceo(rs.getString("bceo"));
				sVO.setToday(rs.getString("today"));
				sVO.setBcnt(rs.getInt("bcnt"));
				list.add(sVO);
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
	
	// SALES 게시판 테이블 글 등록 데이터베이스 작업 전담 처리 함수
	public int addSales(HashMap<String, String> map) {
		int cnt = 0;
		con = db.getCon();
		String sql = sSQL.getSQL(sSQL.SAL_ADD);
		pstmt = db.getPSTMT(con, sql);
		try {
			//pno 글번호, ptt 글제목, bno 사업자번호, pbd 글내용 ,imgno 이미지 ,cate 카테고리
			pstmt.setString(1, map.get("ptt"));
			pstmt.setString(2, map.get("id"));
			pstmt.setString(3, map.get("pbd"));
			pstmt.setString(4, map.get("cate"));
			
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	// sales 게시판 파일 정보 등록
	public boolean addImgInfo(FileVO fVO) {
		boolean bool = false;
		int cnt = 0;
		int result = 0;
		con = db.getCon();
		String sql = sSQL.getSQL(sSQL.IMG_ADD);
		MultipartRequest multi = fVO.getMulti();
		
		Enumeration en = multi.getFileNames();
		while(en.hasMoreElements()) {
			pstmt = db.getPSTMT(con, sql);
			String key = (String) en.nextElement();
			String oriname = multi.getOriginalFileName(key);
			if(oriname == null || oriname.length() == 0) {
				continue;
			}
			++cnt;
			String savename = multi.getFilesystemName(key);
			File file = multi.getFile(key);
//			int pno = fVO.getPno();
			
			try {
				pstmt.setString(1, oriname);
				pstmt.setString(2,  savename);
//				pstmt.setString(3, fVO.getId());
//				pstmt.setString(3, imgrut);
				result += pstmt.executeUpdate();
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				db.close(pstmt);
			}
		}
		db.close(con);
		if(cnt == result) {
			bool = true;
		}
		return bool;
	}
	// 게시글 상세보기 
	public SalesVO getContent(int pno) {
		SalesVO sVO = new SalesVO();
		con = db.getCon();
		String sql = sSQL.getSQL(sSQL.SAL_CLICK);
		pstmt = db.getPSTMT(con, sql);
		int cnt = 0;
		try {
			pstmt.setInt(1, pno);
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
		} 
		if(cnt != 1) {
			System.out.println("## 클릭 수 증가 실패 ##");
		}
		sql = sSQL.getSQL(sSQL.SAL_CONT);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, pno);
			rs = pstmt.executeQuery();
			ArrayList<FileVO> list = new ArrayList<FileVO>();
			for(int i = 0; rs.next(); i++) {
				FileVO fVO = new FileVO();
				if(rs.getInt("imgno") != 0) {
					fVO.setImgno(rs.getInt("imgno"));
					fVO.setPno(rs.getInt("pno"));
					fVO.setOriname(rs.getString("oriname"));
					fVO.setSavename(rs.getString("savename"));
				}
				list.add(fVO);
				
				if(i != 0) continue;
				
				sVO.setPno(rs.getInt("pno"));
				sVO.setId(rs.getString("memid"));
				sVO.setPtt(rs.getString("ptt"));
				sVO.setPbd(rs.getString("pbd"));
				sVO.setBceo(rs.getString("bceo"));
				sVO.setBloc(rs.getString("bloc"));
				sVO.setCate(rs.getString("cate"));
//				sVO.setpDate(rs.getDate("pdate"));
//				sVO.setpTime(rs.getTime("ptime"));
//				sVO.setToday();
				sVO.setBcnt(rs.getInt("bcnt"));
			}
			sVO.setFile(list);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return sVO;
	}
	// 글 삭제
	public int deleteData(int pno) {
		int cnt = 0;
		con = db.getCon();
		String sql = sSQL.getSQL(sSQL.SAL_DEL);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, pno);
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	// 글 수정
	public int modifyData(String ptt, String pbd, String cate, int pno) {
		int cnt = 0;
		con = db.getCon();
		String sql = sSQL.getSQL(sSQL.SAL_MODI);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, ptt);
			pstmt.setString(2, pbd);
			pstmt.setString(3, cate);
			pstmt.setInt(4, pno);
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	public FileVO selImg(int pno) {
		FileVO fVO = new FileVO();
		int cnt = 0;
		con = db.getCon();
		String sql = sSQL.getSQL(sSQL.IMG_SEL);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, pno);
			rs = pstmt.executeQuery();
			rs.next();
			fVO.setSavename(rs.getString("savename"));
		} catch(Exception e) {}
		finally { 
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return fVO;
	}
	// 차량 빈도수
	public SalesVO selCar(int pno) {
		SalesVO sVO = new SalesVO();
		con = db.getCon();
		String sql = sSQL.getSQL(sSQL.SEL_CAR);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, pno);
			pstmt.setInt(2, pno);
			rs = pstmt.executeQuery();
			rs.next();
			sVO.setCarct(rs.getString("carct"));
		} catch(Exception e) {}
		finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return sVO;
	}
	
	public SalesVO selMemid(int pno) {
		SalesVO sVO = new SalesVO();
		con = db.getCon();
		String sql = sSQL.getSQL(sSQL.SAL_MEMID);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, pno);
			rs = pstmt.executeQuery();
			rs.next();
			sVO.setMemid(rs.getString("memid"));
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		return sVO;
	}
	
}
