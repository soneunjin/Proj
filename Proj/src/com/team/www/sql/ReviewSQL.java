package com.team.www.sql;

public class ReviewSQL {
	public final int RE_LIST = 1001;
	public final int ADD_DATA = 2001;
	public final int EDIT_DATA = 3001;
	public final int DEL_DATA = 4001;
	public final int RE_TOTAL_CNT = 5001;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case RE_LIST:
			buff.append("SELECT "); 
			buff.append("	ee.rrno, rno, memid, ptt, rtt, rbd, memno, rst "); 
			buff.append("FROM "); 
			buff.append("	(SELECT "); 
			buff.append("		rownum rrno, rno, m.memid, ptt, rtt, rbd, m.memno, e.today, rst "); 
			buff.append("	FROM "); 
			buff.append("		(SELECT "); 
			buff.append("			p.pno, ptt, bno, pbd, p.today, bcnt, pshow, cate, rno, rtt, rbd, memno, rst, rshow "); 
			buff.append("		FROM "); 
			buff.append("			PROMOTION p, REVIEW r "); 
			buff.append("		WHERE "); 
			buff.append("			rshow = 'Y'  "); 
			buff.append("			AND "); 
			buff.append("			p.pno = r.pno "); 
			buff.append("			) e, member m  "); 
			buff.append("	WHERE "); 
			buff.append(" 		m.memno = e.memno "); 
			buff.append("	ORDER BY "); 
			buff.append(" 		today desc  "); 
			buff.append(" 	) ee "); 
			buff.append(" 	WHERE "); 
			buff.append("    rrno BETWEEN ? AND ?");
		break;
		case ADD_DATA:
			buff.append("INSERT INTO "); 
			buff.append("    review(rno, pno, rtt, rbd, memno, rst) "); 
			buff.append("VALUES( "); 
			buff.append("    (SELECT NVL(MAX(rno)+1, 100000) FROM review), "); 
			buff.append("    ?, ?, ?, "); 
			buff.append("    (SELECT memno FROM member WHERE memid = ?), "); 
			buff.append("    ? "); 
			buff.append(")");
		break;
		case EDIT_DATA:
			buff.append("");
		break;
		case DEL_DATA:
			buff.append("UPDATE "); 
			buff.append("    review "); 
			buff.append("SET "); 
			buff.append("    rshow = 'N' "); 
			buff.append("WHERE "); 
			buff.append("    rno = ? "); 
		break;
		case RE_TOTAL_CNT:
			buff.append("SELECT ");
			buff.append("	count(*) cnt ");
			buff.append("FROM ");
			buff.append("	review ");
			buff.append("WHERE ");
			buff.append("	rshow = 'Y' ");
			break;
		}
		return buff.toString();
	}
}
