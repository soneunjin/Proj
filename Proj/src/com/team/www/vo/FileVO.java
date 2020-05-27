package com.team.www.vo;

import java.text.*;
import java.sql.*;
import com.oreilly.servlet.MultipartRequest;

public class FileVO {
	private int pbno, pno, imgno;
	private String oriname, savename, sDate, id, imgrut ;
	private Date iDate;
	private Time iTime;
	private MultipartRequest multi;
	
	
	public String getImgrut() {
		return imgrut;
	}
	public void setImgrut(String imgrut) {
		this.imgrut = imgrut;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getImgno() {
		return imgno;
	}
	public void setImgno(int imgno) {
		this.imgno = imgno;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public int getPbno() {
		return pbno;
	}
	public void setPbno(int pbno) {
		this.pbno = pbno;
	}
	public String getOriname() {
		return oriname;
	}
	public void setOriname(String oriname) {
		this.oriname = oriname;
	}
	public String getSavename() {
		return savename;
	}
	public void setSavename(String savename) {
		this.savename = savename;
	}
	public String getsDate() {
		return sDate;
	}
	public void setsDate() {
		SimpleDateFormat form1 = new SimpleDateFormat("yyyy년 MM월 dd일");
		SimpleDateFormat form2 = new SimpleDateFormat("HH:mm");
		this.sDate = form1.format(iDate) + " " + form2.format(iTime);
	}
	public void setsDate(String sDate) {
		this.sDate = sDate;
	}
	public Date getiDate() {
		return iDate;
	}
	public void setiDate(Date iDate) {
		this.iDate = iDate;
	}
	public Time getiTime() {
		return iTime;
	}
	public void setiTime(Time iTime) {
		this.iTime = iTime;
	}
	public MultipartRequest getMulti() {
		return multi;
	}
	public void setMulti(MultipartRequest multi) {
		this.multi = multi;
	}
	
	
}
