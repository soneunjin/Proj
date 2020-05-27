package com.team.www.sql;

public class SalesSQL {
	public final int SAL_LIST = 1001;			// 리스트 뽑기
	public final int SAL_CONT = 1002;			// 상세보기 뽑기
	public final int SAL_TOTAL_CNT = 1003;		// 보여지는 게시글 수 뽑기(페이징)
	
	public final int SAL_ADD = 2001;			// 글 쓰기
	public final int SAL_MODI = 2002;			// 글 수정
	public final int SAL_DEL = 2003;			// 글 삭제
	public final int SAL_MEMID = 2004;			// 아이디 값 얻기
	
	public final int IMG_ADD = 3001;			// 이미지 추가
	public final int IMG_SEL = 3002;			// 이미지 조회
	
	public final int SAL_CLICK = 4001;			// 조회수
	public final int SEL_CAR = 5001;			// 차량빈도수
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case SAL_LIST:
			buff.append("SELECT ");
			buff.append("    ee.rno, ee.pno, ee.ptt, ee.bceo, ee.today, ee.bcnt ");
			buff.append("FROM ");
			buff.append("(SELECT  ");
			buff.append("    rownum rno, e.pno, e.ptt, e.bceo, e.today, e.bcnt ");
			buff.append("FROM ");
			buff.append("(SELECT ");
			buff.append("	pno, ptt, bceo, today, bcnt ");
			buff.append("FROM ");
			buff.append("	promotion p, boss b ");
			buff.append("WHERE ");
			buff.append("	p.bno = b.bno AND p.pshow = 'Y' ");
			buff.append("ORDER BY ");
			buff.append("	today desc) e) ee ");
			buff.append("WHERE ");
			buff.append("	rno BETWEEN ? AND ? ");
			break;
		case SAL_CONT:
			buff.append("SELECT ");
			buff.append("p.pno pno , ptt, pbd, bceo, b.bno, p.today, bcnt, bloc, cate, m.memid, ");
			buff.append("NVL(imgno, 0) imgno, NVL(oriname, 'none') oriname, NVL(savename, 'none') savename "); 
			buff.append("FROM "); 
			buff.append("promotion p, image i, boss b, member m "); 
			buff.append("WHERE ");
			buff.append("p.pno = i.pno(+) ");
			buff.append("AND b.bno = p.bno ");
			buff.append("AND b.memno = m.memno(+) AND p.pshow = 'Y' ");
			buff.append("AND p.pno = ? ");
			break;
		case SAL_TOTAL_CNT:
			buff.append("SELECT ");
			buff.append("	count(*) cnt ");
			buff.append("FROM ");
			buff.append("	promotion ");
			buff.append("WHERE ");
			buff.append("	pshow = 'Y' ");
			break;
		case SAL_ADD:
			buff.append("INSERT INTO " );
			buff.append("    promotion(pno, ptt, bno, pbd, cate) "); 
			buff.append("VALUES( ");
			buff.append("    (SELECT NVL(MAX(pno)+1, 1000) FROM promotion), "); 
			buff.append("    ?, ");
			buff.append(" 	(SELECT bno FROM boss b, member m WHERE b.memno = m.memno AND memid = ?), ");
			buff.append("	?, ? ");
			buff.append(") ");
			break;
		case SAL_MODI:
			buff.append("UPDATE ");
			buff.append("	promotion ");
			buff.append("SET ");
			buff.append("	ptt = ? , ");
			buff.append("	pbd = ? , ");
			buff.append("	cate = ? ");
			buff.append("WHERE ");
			buff.append("	pno = ? ");
			break;
		case SAL_DEL:
			buff.append("UPDATE "); 
			buff.append("    promotion "); 
			buff.append("SET "); 
			buff.append("    pshow = 'N' "); 
			buff.append("WHERE "); 
			buff.append("    pno = ? "); 
			break;
		case SAL_MEMID:
			buff.append("SELECT "); 
			buff.append("    memid, name, p.pno pno "); 
			buff.append("FROM "); 
			buff.append("    member m, boss b, promotion p "); 
			buff.append("WHERE "); 
			buff.append("    m.memno = b.memno "); 
			buff.append("    and p.bno = b.bno "); 
			buff.append("    and p.pno = ? "); 
			break;
		case IMG_ADD:
			buff.append("INSERT INTO "); 
			buff.append("    image(imgno, oriname, savename, pno) "); 
			buff.append("VALUES( "); 
			buff.append("    (SELECT NVL(MAX(imgno) + 1, 10000000) FROM image), "); 
			buff.append("    ?, ?, ");
			buff.append("    (SELECT NVL(MAX(pno), 10000000) FROM promotion) ");
			buff.append(") ");
			break;
		case IMG_SEL:
			buff.append("SELECT "); 
			buff.append("    imgno, oriname, savename, pno "); 
			buff.append("FROM "); 
			buff.append("    image "); 
			buff.append("WHERE ");
			buff.append("    pno = ? ");
			break;
		case SAL_CLICK:
			buff.append("UPDATE ");
			buff.append("	promotion ");
			buff.append("SET "); 
			buff.append("	bcnt = bcnt + 1 "); 
			buff.append("WHERE ");
			buff.append("	pno = ? ");
			break;
		case SEL_CAR:
			buff.append("SELECT ");
			buff.append("    TCOUNT, CARCT "); 
			buff.append("FROM ");
			buff.append("(SELECT "); 
			buff.append("    COUNT(*) TCOUNT, CARCT "); 
			buff.append("FROM ");
			buff.append("(SELECT "); 
			buff.append("    r.pno, p.ptt, r.memno, c.carct "); 
			buff.append("FROM ");
			buff.append("    car c, member m, promotion p, review r "); 
			buff.append("WHERE ");
			buff.append("    m.carno = c.carno "); 
			buff.append("    AND r.pno = p.pno "); 
			buff.append("    AND M.MEMNO = R.MEMNO "); 
			buff.append("    AND r.pno = ?) ");
			buff.append("GROUP BY  ");
			buff.append("    CARCT "); 
			buff.append(") ");
			buff.append("WHERE "); 
			buff.append("    TCOUNT = ( "); 
			buff.append("SELECT ");
			buff.append("    MAX(TCOUNT) ");
			buff.append("FROM ");
			buff.append("(SELECT "); 
			buff.append("    COUNT(*) TCOUNT, CARCT "); 
			buff.append("FROM ");
			buff.append("(SELECT "); 
			buff.append("    r.pno, p.ptt, r.memno, c.carct "); 
			buff.append("FROM ");
			buff.append("    car c, member m, promotion p, review r "); 
			buff.append("WHERE ");
			buff.append("    m.carno = c.carno "); 
			buff.append("    AND r.pno = p.pno ");
			buff.append("    AND M.MEMNO = R.MEMNO "); 
			buff.append("    AND r.pno = ?) ");
			buff.append("GROUP BY  ");
			buff.append("    CARCT "); 
			buff.append(") ");
			buff.append("    )");
			break;
		}
		return buff.toString();
	}
}
