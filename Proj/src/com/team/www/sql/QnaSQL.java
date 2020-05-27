package com.team.www.sql;

public class QnaSQL {
	public final int SEL_ALL_QLIST = 1001;
	public final int SEL_QLIST = 1002;
	public final int SEL_AQCNT = 1003;
	public final int SEL_QNO_QNA = 1004;
	public final int SEL_QNA_MNAME = 1005;
	public final int SEL_QNA_ANS= 1006;
	public final int SEARCH_RESULT_LIST= 1007;
	public final int SEL_RESULT_CNT = 1008;
	
	public final int ADD_QNA = 2001;
	public final int ADD_QNA_ANS = 2002;
	
	public final int DEL_QNA = 3001;
	
	public final int MODI_QNA = 4001;
	
	public final int UPD_OK = 5001;
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case UPD_OK:
			buff.append("UPDATE ");
			buff.append("	qna ");
			buff.append("SET ");
			buff.append("	ok = 'ok' ");
			buff.append("WHERE ");
			buff.append("	qno = ? ");
			break;
		case SEL_QNA_MNAME:
			buff.append("SELECT "); 
			buff.append("	name "); 
			buff.append("FROM "); 
			buff.append("	member "); 
			buff.append("WHERE "); 
			buff.append("	memid = ? ");
			break;
		case SEARCH_RESULT_LIST:
			buff.append("SELECT "); 
			buff.append("	rno, qno, qtt, qip, name, today, ok "); 
			buff.append("FROM "); 
			buff.append("	(SELECT "); 
			buff.append("		ROWNUM rno, R.* "); 
			buff.append("	FROM "); 
			buff.append("		(SELECT  "); 
			buff.append("			qno, qtt, qip, name, today, ok  "); 
			buff.append("		FROM  "); 
			buff.append("			member m, qna q  "); 
			buff.append("		WHERE  "); 
			buff.append("			m.memno = q.memno "); 
			buff.append("			AND qshow = 'Y' "); 
			buff.append("			AND qorno IS NULL "); 
			buff.append("			AND # Like '%'||?||'%' "); 
			buff.append("		ORDER BY "); 
			buff.append("			qno DESC) R  "); 
			buff.append(") "); 
			buff.append("WHERE "); 
			buff.append("	rno between ? AND ? ");
			break;
		case SEL_QLIST:
			buff.append("SELECT "); 
			buff.append("	qno, qtt, name, today "); 
			buff.append("FROM "); 
			buff.append("	qna q, member m "); 
			buff.append("WHERE "); 
			buff.append("	q.memno = m.memno ");
			buff.append("	AND qorno IS NULL ");
			buff.append("ORDER BY "); 
			buff.append("	qno DESC ");
			break;
		case SEL_ALL_QLIST:
			buff.append("SELECT "); 
			buff.append("	rno, qno, qtt, qip, name, today, ok ");   // 답변유무 판단 ok 
			buff.append("FROM "); 
			buff.append("	(SELECT "); 
			buff.append("		ROWNUM rno, R.* "); 
			buff.append("	FROM "); 
			buff.append("		(SELECT "); 
			buff.append("			qno, qtt, qip, today, name, ok "); 
			buff.append("		FROM "); 
			buff.append("			qna q, member m "); 
			buff.append("		WHERE "); 
			buff.append("			q.qshow = 'Y' "); 
			buff.append("			AND qorno IS NULL ");
			buff.append("			AND q.memno = m.memno "); 
			buff.append("		ORDER BY "); 
			buff.append("			qno DESC "); 
			buff.append("		) R "); 
			buff.append("	) "); 
			buff.append("WHERE "); 
			buff.append("	rno BETWEEN ? AND ? ");
			break;
		case SEL_AQCNT:
			buff.append("SELECT "); 
			buff.append("	count(*) cnt "); 
			buff.append("FROM "); 
			buff.append("	qna "); 
			buff.append("WHERE "); 
			buff.append("	qorno IS NULL ");
			buff.append("	AND qshow = 'Y' ");
			break;
		case SEL_RESULT_CNT:
			buff.append("SELECT "); 
			buff.append("	count(*) cnt "); 
			buff.append("FROM "); 
			buff.append("	qna q, member m "); 
			buff.append("WHERE "); 
			buff.append("	m.memno = q.memno "); 
			buff.append("	AND qshow = 'Y' "); 
			buff.append("	AND qorno IS NULL "); 
			buff.append("	AND # Like '%'||?||'%' "); 
			break;
		case SEL_QNO_QNA:	// 질의명령 다시한번 더 생각해 볼 것
			/*
			buff.append("SELECT "); 
			buff.append("	q.qno qno, q.qtt qtt, q.qip qip, q.today today, NVL(v.qorno,0) qorno, "); 
			buff.append("	NVL(v.qtt,'없음') anstt, NVL(v.qip,'없음') ansip, NVL(v.today, sysdate) ansdate, name "); 
			buff.append("FROM "); 
			buff.append("	qna q,  "); 
			buff.append("	( "); 
			buff.append("	SELECT  "); 
			buff.append("		qno, qtt, qip, today, qorno "); 
			buff.append("	FROM "); 
			buff.append("		qna  "); 
			buff.append("	WHERE "); 
			buff.append("		qorno IS NOT NULL "); 
			buff.append(") v "); 
			buff.append(", member m "); 
			buff.append("WHERE "); 
			buff.append(	"q.qno = ? "); 
			buff.append("	AND q.qno = v.qorno(+) "); 
			buff.append("	AND q.memno = m.memno ");
			*/
			buff.append("SELECT "); 
			buff.append("    qno, qtt, qip, today, NVL(qorno, -1) qorno, today ansdate, name, memid "); 
			buff.append("FROM "); 
			buff.append("    qna q, member m "); 
			buff.append("WHERE "); 
			buff.append("	q.memno = m.memno "); 
			buff.append("	AND (qno = ? OR qorno = ?) ");
			buff.append("	AND qshow = 'Y' ");
			break;
		case SEL_QNA_ANS:
			buff.append("SELECT "); 
			buff.append("	qtt, qip, name, today "); 
			buff.append("FROM "); 
			buff.append("	qna q, member b "); 
			buff.append("WHERE "); 
			buff.append("	qorno = ? ");
			buff.append("	AND memid = ? ");
			buff.append("	AND qshow = 'Y' ");
			break;
		case ADD_QNA:
			buff.append("INSERT INTO "); 
			buff.append("	qna(qno, qtt, qip, memno) "); 
			buff.append("VALUES( "); 
			buff.append("	(SELECT NVL(MAX(qno + 1),1000) FROM qna), "); 
			buff.append("	?, ?, "); 
			buff.append("	(SELECT memno FROM member WHERE memid = ?) ");
			buff.append(")");
			break;
		case MODI_QNA:
			buff.append("UPDATE ");
			buff.append("	qna ");
			buff.append("SET ");
			buff.append("	qtt = ?, ");
			buff.append("	qip = ? ");
			buff.append("WHERE ");
			buff.append("	qno = ? ");
			break;
		case ADD_QNA_ANS:
			buff.append("INSERT INTO "); 
			buff.append("	qna(qno, qtt, qip, qorno, memno) "); 
			buff.append("VALUES ( "); 
			buff.append("	(SELECT NVL(MAX(qno) +1 , 1000) FROM qna), ?, ?, ?, "); 
			buff.append("	(SELECT memno FROM member WHERE memid = ? )) ");
			break;
		case DEL_QNA:
			buff.append("UPDATE "); 
			buff.append("	qna "); 
			buff.append("SET "); 
			buff.append("	qshow = 'N', "); 
			buff.append("	ok = 'N' "); 
			buff.append("WHERE "); 
			buff.append("	qno = ? ");
			break;
		}
		return buff.toString();
	}
}
