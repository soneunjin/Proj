package com.team.www.vo;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

public class BoardVO {
	private int bdno, memno, borino, vcnt, imgno, rno;
	private String bdct, bdtt, bdbd, bdshow, sdate, name, memid;
	public String getMemid() {
		return memid;
	}
	public void setMemid(String memid) {
		this.memid = memid;
	}
	private Date bDate;
	private Time bTime;
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBdno() {
		return bdno;
	}
	public void setBdno(int bdno) {
		this.bdno = bdno;
	}
	public int getMemno() {
		return memno;
	}
	public void setMemno(int memno) {
		this.memno = memno;
	}
	public int getBorino() {
		return borino;
	}
	public void setBorino(int borino) {
		this.borino = borino;
	}
	public int getVcnt() {
		return vcnt;
	}
	public void setVcnt(int vcnt) {
		this.vcnt = vcnt;
	}
	public int getImgno() {
		return imgno;
	}
	public void setImgno(int imgno) {
		this.imgno = imgno;
	}
	public String getBdct() {
		return bdct;
	}
	
	public void setBdct(String bdct) {
		this.bdct = bdct;
	}
	public String getBdtt() {
		return bdtt;
	}
	public void setBdtt(String bdtt) {
		this.bdtt = bdtt;
	}
	public String getBdbd() {
		return bdbd;
	}
	public void setBdbd(String bdbd) {
		this.bdbd = bdbd;
	}
	public String getBdshow() {
		return bdshow;
	}
	public void setBdshow(String bdshow) {
		this.bdshow = bdshow;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate() {
		SimpleDateFormat form1 = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat form2 = new SimpleDateFormat("HH:mm");
		this.sdate = form1.format(bDate) + " " + form2.format(bTime);
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public Date getbDate() {
		return bDate;
	}
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	public Time getbTime() {
		return bTime;
	}
	public void setbTime(Time bTime) {
		this.bTime = bTime;
	}
	

}
