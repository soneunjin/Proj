package com.team.www.sql;

public class InsertSQL {
	public final int SEL_INSERT_CO = 1007;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case SEL_INSERT_CO:
			buff.append(" INSERT INTO  "); 
			buff.append(	"boss(memno, bno, bname, btel, bloc, bceo) "); 
			buff.append(	"VALUES( "); 
			buff.append("    (SELECT "); 
			buff.append(	"        memno "); 
			buff.append("    FROM "); 
			buff.append(	"     member "); 
			buff.append("    WHERE "); 
			buff.append("        memid= ? ),  "); 
			buff.append("    ?, ?, ?, ?, ? ");
			buff.append(" ) ");
				
				break;
		}
		return buff.toString();
	}
}
