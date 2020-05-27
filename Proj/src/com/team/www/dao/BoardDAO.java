package com.team.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.team.www.DB.WebDBCP;
import com.team.www.sql.BoardSQL;
import com.team.www.util.PageUtil;
import com.team.www.vo.BoardVO;
import com.team.www.vo.MemberVO;

public class BoardDAO {
	WebDBCP db;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	BoardSQL bSQL;

	public BoardDAO() {
		// 할일
		// 1. 데이터베이스 준비
		db = new WebDBCP();
		// 2. 질의명령 사용할 준비
		bSQL = new BoardSQL();
	}

	public int getTotal() {
		int cnt = 0;
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.SEL_TOTAL_CNT);
		stmt = db.getSTMT(con);
		try {
			rs = stmt.executeQuery(sql);
			rs.next();
			cnt = rs.getInt("cnt");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		return cnt;
	}

	public int getCTotal(String cate) {
		int cnt = 0;
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.SEL_CTOTAL_CNT);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, cate);

			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt("cnt");
			System.out.println("여기 " + cnt);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		return cnt;
	}
	public int getSTotal( String condition, String input) {
		int cnt = 0;
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.SEL_STOTAL_CNT);
		if (condition.equals("bdtt")) {
			sql = sql.replaceAll("#", "bdtt");
			
		} else if (condition.equals("bdbd")){
			sql = sql.replaceAll("#", "bdbd");
			
		} else if (condition.equals("name")){
			sql = sql.replaceAll("#", "name");
		}
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, input);
			
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt("cnt");
			System.out.println("여기 " + cnt);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		return cnt;
	}

	public int addData(String cate, String title, String body, String id) {
		int cnt = 0;
		con = db.getCon();

		String sql = bSQL.getSQL(bSQL.ADD_DATA);

		pstmt = db.getPSTMT(con, sql);
		try {

			pstmt.setString(1, cate);
			pstmt.setString(2, title);
			pstmt.setString(3, body);
			pstmt.setString(4, id);

			cnt = pstmt.executeUpdate();
			System.out.println(cnt);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}

		return cnt;

	}

	public int addCom(String body, String id, int orino) {
		int cnt = 0;
		con = db.getCon();

		String sql = bSQL.getSQL(bSQL.ADD_COM);

		pstmt = db.getPSTMT(con, sql);
		try {

			pstmt.setString(1, body);
			pstmt.setString(2, id);
			pstmt.setInt(3, orino);

			cnt = pstmt.executeUpdate();
			System.out.println(cnt);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}

		return cnt;

	}

	public ArrayList<BoardVO> getCateList(String cat, PageUtil page) {
		ArrayList<BoardVO> clist = new ArrayList<BoardVO>();
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.SEL_CATE_LIST);
		pstmt = db.getPSTMT(con, sql);
		try {
			
			pstmt.setString(1, cat);
			pstmt.setInt(2, page.getStartCont());
			pstmt.setInt(3, page.getEndCont());
			System.out.println(cat);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardVO bVO = new BoardVO();
				// 데이터 뽑고 VO에 담기
				bVO.setRno(rs.getInt("rno"));
				bVO.setBdno(rs.getInt("bdno"));
				bVO.setBdct(rs.getString("bdct"));
				bVO.setBdtt(rs.getString("bdtt"));
				bVO.setName(rs.getString("name"));
				bVO.setbDate(rs.getDate("today"));
				bVO.setbTime(rs.getTime("today"));
				bVO.setSdate();
				bVO.setVcnt(rs.getInt("vcnt"));

				clist.add(bVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		return clist;
	}

	public ArrayList<BoardVO> getAllList(PageUtil page) {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		// con
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.SEL_ALL_LIST);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, page.getStartCont());
			pstmt.setInt(2, page.getEndCont());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardVO bVO = new BoardVO();
				// 데이터 뽑고 VO에 담기
				bVO.setRno(rs.getInt("rno"));
				bVO.setBdno(rs.getInt("bdno"));
				bVO.setBdct(rs.getString("bdct"));
				bVO.setBdtt(rs.getString("bdtt"));
				bVO.setName(rs.getString("name"));
				bVO.setbDate(rs.getDate("today"));
				bVO.setbTime(rs.getTime("today"));
				bVO.setSdate();
//	            bVO.setClick(rs.getInt("click"));
				bVO.setVcnt(rs.getInt("vcnt"));

				list.add(bVO);
				System.out.println("요기2리스트사이즈" + list.size());

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		return list;
	}
	public ArrayList<BoardVO> searching(String condition, String input, PageUtil page ) {
		ArrayList<BoardVO> slist = new ArrayList<BoardVO>();
		
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.SEARCH);
		
		if (condition.equals("bdtt")) {
			sql = sql.replaceAll("#", "bdtt");
			
		} else if (condition.equals("bdbd")){
			sql = sql.replaceAll("#", "bdbd");
			
		} else if (condition.equals("name")){
			sql = sql.replaceAll("#", "name");
		}
		pstmt = db.getPSTMT(con, sql);
		try {
			

			pstmt.setString(1, input);
//			System.out.println(condition +",");
			pstmt.setInt(2, page.getStartCont());
			pstmt.setInt(3, page.getEndCont());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardVO bVO = new BoardVO();
				// 데이터 뽑고 VO에 담기
				bVO.setBdno(rs.getInt("bdno"));
				bVO.setBdct(rs.getString("bdct"));
				bVO.setBdtt(rs.getString("bdtt"));
				bVO.setName(rs.getString("name"));
				bVO.setbDate(rs.getDate("today"));
				bVO.setbTime(rs.getTime("today"));
				bVO.setSdate();
				bVO.setVcnt(rs.getInt("vcnt"));
				
				slist.add(bVO);
				System.out.println("요기리스트사이즈" + slist.size());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		return slist;
	}

	public BoardVO getDetail(int bdno) {
		BoardVO bVO = new BoardVO();

		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.SEL_DETAIL);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, bdno);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				// 데이터 뽑고 VO에 담기
				bVO.setBdtt(rs.getString("bdtt"));
				bVO.setName(rs.getString("name"));
				bVO.setBdbd(rs.getString("bdbd"));
				bVO.setbDate(rs.getDate("today"));
				bVO.setbTime(rs.getTime("today"));
				bVO.setSdate();
				bVO.setVcnt(rs.getInt("vcnt"));
				bVO.setMemid(rs.getString("memid"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);

		}
		return bVO;
	}

	public BoardVO Click(int bdno) {
		BoardVO bVO1 = new BoardVO();
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.EDIT_CLICK_BRD);
		System.out.println("DAO :" + bdno);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, bdno);
			rs = pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);

		}
		return bVO1;
	}

	public int delete(int bdno) {
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.DELETE);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, bdno);
			rs = pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return bdno;

	}

	public int edit(String title, String body, int bno, String cat) {
		int cnt = 0;
		con = db.getCon();

		String sql = bSQL.getSQL(bSQL.EDIT);

		pstmt = db.getPSTMT(con, sql);
		try {

			pstmt.setString(1, cat);
			pstmt.setString(2, title);
			pstmt.setString(3, body);
			pstmt.setInt(4, bno);

			cnt = pstmt.executeUpdate();
			System.out.println(cnt);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}

		return cnt;

	}

	public int comEdit(int bno, String bdbd) {
		int cnt = 0;
		con = db.getCon();

		String sql = bSQL.getSQL(bSQL.COM_EDIT);

		pstmt = db.getPSTMT(con, sql);
		try {

			pstmt.setString(1, bdbd);
			pstmt.setInt(2, bno);

			cnt = pstmt.executeUpdate();
			System.out.println(cnt);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}

		return cnt;

	}

	public ArrayList<BoardVO> getComList(int bno) {
		ArrayList<BoardVO> clist = new ArrayList<BoardVO>();
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.SEL_COM);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, bno);
			System.out.println("DAO BNO" + bno);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardVO bVO = new BoardVO();
				// 데이터 뽑고 VO에 담기
				bVO.setBdno(rs.getInt("bdno"));
				bVO.setName(rs.getString("name"));
				bVO.setBdbd(rs.getString("bdbd"));
				bVO.setbDate(rs.getDate("today"));
				bVO.setbTime(rs.getTime("today"));
				bVO.setSdate();
//	            bVO.setClick(rs.getInt("click"));
				clist.add(bVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		return clist;
	}
}
