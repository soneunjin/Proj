package com.team.www.sql;

public class InfoSQL {
	public final int SEL_CTTLIST = 1001;
	public final int SEL_CTT_INFO = 1002;
	public final int SEL_ACPLIST = 1003;
	public final int SEL_DTCLIST = 1004;
	
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case SEL_DTCLIST:
			buff.append("SELECT "); 
			buff.append("	ifno, ifname, iftel, ifaddr "); 
			buff.append("FROM "); 
			buff.append("	info "); 
			buff.append("WHERE "); 
			buff.append("	ifct = 'dtc' "); 
			buff.append("	AND ifshow = 'Y' ");
			break;
		case SEL_ACPLIST:
			buff.append("SELECT "); 
			buff.append("	ifno, ifname, iftel, ifpri, ifaddr, iflink "); 
			buff.append("FROM "); 
			buff.append("	info "); 
			buff.append("WHERE "); 
			buff.append("	ifct = 'acp' "); 
			buff.append("	AND ifshow = 'Y' ");
			break;
		case SEL_CTTLIST:
			buff.append("SELECT "); 
			buff.append("	ifno, ifname, iftel, ifpri, ifaddr, iflink "); 
			buff.append("FROM "); 
			buff.append("	info "); 
			buff.append("WHERE "); 
			buff.append("	ifct = 'ctt' "); 
			buff.append("	AND ifshow = 'Y' ");
			break;
		case SEL_CTT_INFO:
			buff.append("SELECT "); 
			buff.append("    ifname, iftel, ifpri, ifaddr, iflink "); 
			buff.append("FROM "); 
			buff.append("    info "); 
			buff.append("WHERE "); 
			buff.append("    ifname = ? ");
			break;
		}
		return buff.toString();
	}
}
