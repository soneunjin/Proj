package com.team.www.sql;

public class MemberSQL {
	public final int SEL_ID_CNT = 1000;
	public final int SEL_LOGIN_CNT = 1001;
	public final int SEL_ID_FIND = 1002;
	public final int SEL_PW_FIND = 1003;
	public final int SEL_INFO = 1004;
	public final int SEL_COUNT = 1005;
	public final int SEL_TEN = 1006;
	public final int SEL_MAIN = 1007;
	
	public final int EIDT_PW_DATA = 2001;
	public final int EIDT_PWE_DATA = 2002;
	public final int EIDT_INFO_DATA = 2003;
	
	public final int ADD_DATA = 3001;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case SEL_ID_CNT:
			buff.append("SELECT ");
			buff.append("	COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("	member ");
			buff.append("WHERE ");
			buff.append("	memid = ? ");
			break;
		
		case SEL_LOGIN_CNT:
			buff.append("SELECT ");
			buff.append("	COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("	member ");
			buff.append("WHERE ");
			buff.append("	memid = ? ");
			buff.append("	AND mempw = ? ");
			break;
		case SEL_ID_FIND:
			buff.append("SELECT ");
			buff.append("	CONCAT(RPAD(substr(memid,1,3),instr(memid,'@')-1,'*'),substr(memid,instr(memid,'@'))) memid ");
			buff.append("FROM ");
			buff.append("	member ");
			buff.append("WHERE ");
			buff.append("	name = ? ");
			buff.append("	AND phone = ? ");
			break;
		case SEL_PW_FIND:
			buff.append("SELECT ");
			buff.append("	mempw ");
			buff.append("FROM ");
			buff.append("	member ");
			buff.append("WHERE ");
			buff.append("	name = ? ");
			buff.append("	AND memid = ? ");
			break;
		case SEL_COUNT:
			buff.append("SELECT ");
			buff.append("	count(*) cnt ");
			buff.append("FROM ");
			buff.append("	member ");
			buff.append("WHERE ");
			buff.append("	memid = ? ");
			buff.append("	AND mempw = ? ");
			break;
		
		case SEL_INFO:
			buff.append("SELECT ");
			buff.append("	memid, phone, name, membir, c.carno carno ");
			buff.append("FROM ");
			buff.append("	member m, car c ");
			buff.append("WHERE ");
			buff.append("	m.carno = c.carno ");
			buff.append("	AND memid = ? ");
			break;
			
//		case SEL_TEN:
//			buff.append("SELECT ");
//			buff.append("	p.bno bno, rd, bname, bloc ");
//			buff.append("FROM ");
//			buff.append("	promotion p, boss b, ");
//			buff.append("	(SELECT ");
//			buff.append("		r.pno, avg(rst) rd ");
//			buff.append("	 FROM ");
//			buff.append("		promotion, review r ");
//			buff.append("	 GROUP BY ");
//			buff.append("		r.pno) e ");
//			buff.append("WHERE ");
//			buff.append("	e.pno = p.pno ");
//			buff.append("	and p.bno = b.bno ");
//			buff.append("ORDER BY ");
//			buff.append(" rd DESC ");
//			break;
//			
		case SEL_TEN:
			buff.append("SELECT "); 
			buff.append("    b.bname, p.bno, avg(r.rst) rd, bloc "); 
			buff.append("FROM "); 
			buff.append("    PROMOTION p, review r, BOSS b "); 
			buff.append("WHERE "); 
			buff.append("    p.pno = r.pno AND "); 
			buff.append("    p.bno = b.bno "); 
			buff.append("GROUP BY "); 
			buff.append("    b.bname, p.bno, bloc "); 
			buff.append("Order BY "); 
			buff.append("    rd desc ");
			break;
			
		case SEL_MAIN:
			buff.append("SELECT ");
			buff.append("	ifname,ifaddr ");
			buff.append("FROM ");
			buff.append("	info ");
			break;
			
		case EIDT_PW_DATA:
			buff.append("UPDATE ");
			buff.append(" 	member ");
			buff.append("SET ");
			buff.append(" 	mempw = ? ");
			buff.append("WHERE ");
			buff.append("	memid = ? ");
			buff.append(" 	and name = ? ");
			break;
		case EIDT_PWE_DATA:
			buff.append("UPDATE ");
			buff.append(" 	member ");
			buff.append("SET ");
			buff.append(" 	mempw = ? ");
			buff.append("WHERE ");
			buff.append("	memid = ? ");
			break;
		case EIDT_INFO_DATA:
			buff.append("UPDATE ");
			buff.append(" 	member ");
			buff.append("SET ");
			buff.append(" 	phone = ?, ");
			buff.append("	carno = ? ");
			buff.append("WHERE ");
			buff.append(" 	memid = ? ");
			break;
		case ADD_DATA:
			buff.append("INSERT INTO ");
			buff.append(" 	member(memno, memid, mempw, phone, name, membir, carno) ");
			buff.append("VALUES( ");
			buff.append(" 	(SELECT NVL(MAX(memno) +1, 1000) FROM member), ");
			buff.append(" ?, ?, ?, ?, ?, ? ");
			buff.append(") ");
			break;
		}
		return buff.toString();
	}
}
