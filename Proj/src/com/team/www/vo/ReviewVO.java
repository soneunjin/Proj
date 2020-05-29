package com.team.www.vo;

import java.sql.*;
import java.text.*;

public class ReviewVO {
	private int rno, pno, memno, rst;
	private String rtt, rbd, today, memid, ptt, name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private Date reDate;
	private Time reTime;
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno; 
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public int getMemno() {
		return memno;
	}
	public void setMemno(int memno) {
		this.memno = memno;
	}
	public int getRst() {
		return rst;
	}
	public void setRst(int rst) {
		this.rst = rst;
	}
	public String getRtt() {
		return rtt;
	}
	public void setRtt(String rtt) {
		this.rtt = rtt;
	}
	public String getRbd() {
		return rbd;
	}
	public void setRbd(String rbd) {
		this.rbd = rbd;
	}
	public String getToday() {
		return today;
	}
	public Date getReDate() {
		return reDate;
	}
	public void setReDate(Date reDate) {
		this.reDate = reDate;
	}
	public Time getReTime() {
		return reTime;
	}
	public void setReTime(Time reTime) {
		this.reTime = reTime;
	}
	public void setToday(String today) {
		this.today = today;
	}
	public void setToday() {
		SimpleDateFormat form1 = new SimpleDateFormat("yyyy년 MM월 dd일");
		SimpleDateFormat form2 = new SimpleDateFormat("HH:mm");
		this.today = form1.format(reDate) + " " + form2.format(reTime);
	}
	public String getMemid() {
		return memid;
	}
	public void setMemid(String memid) {
		this.memid = memid;
	}
	public String getPtt() {
		return ptt;
	}
	public void setPtt(String ptt) {
		this.ptt = ptt;
	}
	
	
}
