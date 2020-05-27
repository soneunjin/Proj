package com.team.www.sql;

public class BoardSQL {
	public final int ADD_DATA = 1001;
	public final int ADD_COM = 1008;
	public final int SEL_ALL_LIST = 1002;
	public final int SEL_CATE_LIST = 1003;
	public final int SEL_DETAIL = 1004;
	public final int DELETE = 1005;
	public final int SEL_TOTAL_CNT = 1006;
	public final int EDIT = 1007;
	public final int COM_EDIT = 1010;
	public final int SEL_COM = 1009;
	public final int EDIT_CLICK_BRD = 1011;
	public final int SEL_CTOTAL_CNT = 1012;
	public final int SEL_STOTAL_CNT = 1016;
	public final int SEARCH = 1013;
	public final int SEARCHB = 1014;
	public final int SEARCHN = 1015;

	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch (code) {
		case SEL_TOTAL_CNT:
			buff.append("SELECT ");
			buff.append("   count(*) cnt ");
			buff.append("FROM ");
			buff.append("   board ");
			buff.append("WHERE ");
			buff.append("   bdshow = 'Y' ");
			buff.append("   AND bdct != '댓글' ");
			break;
		case SEL_CTOTAL_CNT:
			buff.append("SELECT ");
			buff.append("   count(*) cnt ");
			buff.append("FROM ");
			buff.append("   board ");
			buff.append("WHERE ");
			buff.append("   bdshow = 'Y' ");
			buff.append("   AND bdct  = ?  ");
			break;
		case SEL_STOTAL_CNT:
			buff.append("SELECT ");
			buff.append("   count(*) cnt ");
			buff.append("FROM ");
			buff.append("   board ");
			buff.append("WHERE ");
			buff.append("    bdshow = 'Y' AND ");
			buff.append("    bdct != '댓글' ");
			buff.append("    AND # Like '%'||?||'%' ");
			break;
		case ADD_DATA:
			buff.append(" insert into  ");
			buff.append("    board(bdno, bdct, bdtt, bdbd, memno)  ");
			buff.append("VALUES(  ");
			buff.append(
					"   (SELECT NVL(MAX(bdno) + 1, 1000) FROM board),?, ?,?, (SELECT  memno FROM  MEMBER WHERE memid = ?) ");
			buff.append(" ) ");
			break;
		case ADD_COM:
			buff.append(" insert into ");
			buff.append("    board(bdno, bdct, bdtt, bdbd, memno, borino) ");
			buff.append("VALUES(   ");
			buff.append(
					"	(SELECT NVL(MAX(bdno) + 1, 1000) FROM board),'댓글', 'comment',?, (SELECT  memno FROM  MEMBER WHERE memid = ?), ?) ");
			break;
			
		case SEL_ALL_LIST:
			buff.append("SELECT ");
			buff.append("   rno, bdno, bdct, bdtt, name, today, vcnt ");
			buff.append("FROM ");
			buff.append("   ( ");
			buff.append("   SELECT ");
			buff.append("      ROWNUM rno, bdno, bdct, bdtt, name, today, vcnt ");
			buff.append("   FROM ");
			buff.append("      ( ");
			buff.append("      SELECT ");
			buff.append("        bdno, bdct, bdtt, name, today, vcnt ");
			buff.append("      FROM ");
			buff.append("         board b, member m ");
			buff.append("      WHERE ");
			buff.append("    b.memno = m.memno AND ");
			buff.append("    b.bdshow = 'Y' AND ");
			buff.append("    bdct != '댓글' ");
			buff.append("      ORDER BY ");
			buff.append("         bdno DESC ");
			buff.append("   ) ");
			buff.append(") ");
			buff.append("WHERE ");
			buff.append("	rno BETWEEN ? AND ?");
			break;
			
		case SEARCH:
			System.out.println("여기옴?");
			buff.append("SELECT ");
			buff.append("   rno, bdno, bdct, bdtt, name, today, vcnt ");
			buff.append("FROM ");
			buff.append("   ( ");
			buff.append("   SELECT ");
			buff.append("      ROWNUM rno, bdno, bdct, bdtt, name, today, vcnt ");
			buff.append("   FROM ");
			buff.append("      ( ");
			buff.append(" SELECT ");
			buff.append("  bdno, bdct, bdtt, name, today, vcnt ");
			buff.append(" FROM ");
			buff.append(" 	member m, board b ");
			buff.append(" WHERE ");
			buff.append("    b.memno = m.memno AND ");
			buff.append("    b.bdshow = 'Y' AND ");
			buff.append("    bdct != '댓글' ");
			buff.append("    AND # Like '%'||?||'%' ");
			buff.append("      ORDER BY ");
			buff.append("         bdno DESC ");
			buff.append("   ) ");
			buff.append(") ");
			buff.append("WHERE ");
			buff.append("	rno BETWEEN ? AND ?");
			break;
			

		case SEL_COM:
			buff.append(" SELECT ");
			buff.append("    bdno, name, bdbd, today, m.memid ");
			buff.append(" FROM ");
			buff.append("    board b, member m ");
			buff.append(" WHERE ");
			buff.append("    b.memno = m.memno AND ");
			buff.append("    b.bdshow = 'Y' AND ");
			buff.append("    bdct =  '댓글' AND ");
			buff.append("    borino = ? ");
			buff.append(" ORDER BY ");
			buff.append("   bdno DESC ");
			break;
			
		case SEL_CATE_LIST:
			buff.append(" SELECT  ");
			buff.append("   rno, bdno, bdct, bdtt, name, today, vcnt  ");
			buff.append("FROM  ");
			buff.append("   (  ");
			buff.append("   SELECT  ");
			buff.append("      ROWNUM rno, bdno, bdct, bdtt, name, today, vcnt   ");
			buff.append("   FROM  ");
			buff.append("      (  ");
			buff.append("      SELECT  ");
			buff.append("        bdno, bdct, bdtt, name, today, vcnt   ");
			buff.append("      FROM  ");
			buff.append("         board b, member m  ");
			buff.append("      WHERE  ");
			buff.append("    bdct = ? AND b.memno = m.memno AND  ");
			buff.append("    b.bdshow = 'Y' AND  ");
			buff.append("    bdct != '댓글'  ");
			buff.append("      ORDER BY  ");
			buff.append("         bdno DESC  ");
			buff.append("   )  ");
			buff.append(")  ");
			buff.append("WHERE  ");
			buff.append(" rno BETWEEN ? AND ? ");
			break;
		case SEL_DETAIL:
			buff.append(" SELECT ");
			buff.append("    today, name, bdtt, bdbd, vcnt, m.memid ");
			buff.append("FROM ");
			buff.append("    board b, member m ");
			buff.append("where ");
			buff.append("    b.memno = m.memno AND ");
			buff.append("    bdno = ? ");
			break;
		case DELETE:
			buff.append("UPDATE ");
			buff.append("    board ");
			buff.append("SET ");
			buff.append(" bdshow = 'N' ");
			buff.append("WHERE ");
			buff.append("bdno = ? ");
			break;
		case EDIT:
			buff.append("UPDATE ");
			buff.append("    board ");
			buff.append("SET ");
			buff.append("bdct = ?, bdtt = ?, bdbd = ? ");
			buff.append("WHERE ");
			buff.append("bdno = ?");
			break;
		case COM_EDIT:
			buff.append("UPDATE ");
			buff.append("    board ");
			buff.append("SET ");
			buff.append(" bdbd = ? ");
			buff.append("WHERE ");
			buff.append("bdno = ?");
			break;
		case EDIT_CLICK_BRD:
			buff.append("UPDATE ");
			buff.append("   board ");
			buff.append("SET ");
			buff.append("   vcnt = vcnt + 1 ");
			buff.append("WHERE ");
			buff.append("   bdno = ? ");
			break;
	

		}
		return buff.toString();
	}
}
