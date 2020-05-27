package com.team.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.team.www.DB.WebDBCP;
import com.team.www.sql.MemberSQL;
import com.team.www.vo.InfoVO;
import com.team.www.vo.MemberVO;


public class MemberDAO {
	WebDBCP db;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	MemberSQL mSQL;
	public MemberDAO() {
		db = new WebDBCP();
		mSQL = new MemberSQL();
	}
	
	// 회원 아이디 카운트 데이터베이스작업 전담 처리 함수
		public int getIdCnt(String id) {
			// 반환값 변수 만들고
			int cnt = 0;
			// 1. 커넥션 얻어오고
			con = db.getCon();
			// 2. 질의명령 가져오고
			String sql = mSQL.getSQL(mSQL.SEL_ID_CNT);
			// 3. pstmt 가져오고
			pstmt = db.getPSTMT(con, sql);
			try {
				// 4. 질의명령 완성하고
				pstmt.setString(1, id);
				// 5. 질의명령 보내고 결과받고
				rs = pstmt.executeQuery();   // select질의명령은 rs로 받는다
				// 6. 결과에서 데이터 꺼내고
				rs.next();
				cnt = rs.getInt("cnt");
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				db.close(rs);
				db.close(pstmt);
				db.close(con);
			}
			// 7. 꺼낸 데이터 반환해주고
			return cnt;
		}
	
	// 로그인 데이터베이스 처리 전담 함수
	public int getLoginCnt(String id, String pw) {
		int cnt = 0 ;
		con = db.getCon();
		// sql
		String sql = mSQL.getSQL(mSQL.SEL_LOGIN_CNT);
		
		// pstmt 가져오고
		pstmt = db.getPSTMT(con, sql);
		
		try{
			// 질의 명령 완성
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			// 질의명령보내고 결과 받고
			rs = pstmt.executeQuery();
			// 데이터꺼내서 변수에 담고
			rs.next();
			cnt = rs.getInt("cnt");
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	// 회원가입 DB 처리 전담 함수
	public int addMember(String id, String pw,String phone, String name, String membir, int carno) {
		int cnt = 0;
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.ADD_DATA);
		pstmt = db.getPSTMT(con, sql);
		
		try {
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, phone);
			pstmt.setString(4, name);
			pstmt.setString(5, membir);
			pstmt.setInt(6, carno);
			
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		
		return cnt;
	}
	
	// 아이디 찾기 처리 전담 함수
	public String id_find(String name, String phone) {
		String user_id = null;
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.SEL_ID_FIND);
		pstmt = db.getPSTMT(con, sql);
		
		try {
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			
			rs = pstmt.executeQuery();
			rs.next();
			user_id = rs.getString("memid");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return user_id;
	}
	// 비밀번호 찾기 처리 전담 함수
	public String pasFind(String name, String memid) {
		String pass = null;
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.SEL_PW_FIND);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, name);
			pstmt.setString(2, memid);
			
			rs = pstmt.executeQuery();
			rs.next();
			pass = rs.getString("mempw");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return pass;
	}
	
	// 임시 비밀번호 변경 처리 전담 함수
	public int passFind(String mempw,String memid, String name) {
		int cnt = 0;
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.EIDT_PW_DATA);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, mempw);
			pstmt.setString(2, memid);
			pstmt.setString(3, name);
			
			cnt = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		
		return cnt;
	}
	// 비밀번호 변경 처리 전담 함수
	public int passEidt(String mempw,String memid) {
		int cnt = 0;
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.EIDT_PWE_DATA);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, mempw);
			pstmt.setString(2, memid);
			
			cnt = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		
		return cnt;
	}
	
	// 사원아이디로 사원 정보를 가져오는 전담 처리 함수
	public MemberVO info(String memid) {
		MemberVO mVO = new MemberVO();
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.SEL_INFO);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, memid);
			System.out.println(memid);
			rs = pstmt.executeQuery();
			rs.next();
			mVO.setMemid(rs.getString("memid"));
			mVO.setPhone(rs.getString("phone"));
			mVO.setName(rs.getString("name"));
			mVO.setMembir(rs.getString("membir"));
			mVO.setCarno(rs.getInt("carno"));
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return mVO;
	}
	
	// 회원 정보 수정 처리 전담 함수
	public int EIDT_INFO(String memid, String phone, int carno) {
		int cnt = 0;
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.EIDT_INFO_DATA);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(3, memid);
			System.out.println(memid);
			pstmt.setString(1, phone);
			System.out.println(phone);
			pstmt.setInt(2, carno);
			System.out.println(carno);
			
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	// 비밀번호 카운트 처리 전담 함수
	public int SEL_COUNT(String memid, String mempw) {
		int cnt = 0;
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.SEL_COUNT);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, memid);
			pstmt.setString(2, mempw);
			
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt("cnt");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	// 탑 10 통계 전담 처리 함수
	public ArrayList<MemberVO> getTen() {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.SEL_TEN);
		stmt = db.getSTMT(con);
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				MemberVO mVO = new MemberVO();
				mVO.setBname(rs.getString("bname"));
				mVO.setRd(rs.getDouble("rd"));
				mVO.setBloc(rs.getString("bloc"));
				list.add(mVO);
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
	
	// 메인 데이터베이스 정보 조회함수
	public ArrayList<InfoVO> getDate() {
		ArrayList<InfoVO> list = new ArrayList<InfoVO>();
		
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.SEL_MAIN);
		stmt = db.getSTMT(con);
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				InfoVO iVO = new InfoVO();
				iVO.setIfname(rs.getString("ifname"));
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
	
}
