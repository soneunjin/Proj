package com.team.www.vo;

import java.sql.*;
import java.sql.Date;
import java.text.*;
import java.util.*;

public class SalesVO {
	private int pno, bcnt, imgno, rno, memno, rst;
	private String ptt, bno, pbd, cate, rtt, pshow, rshow, today, bceo, id, bloc, rbd, memid, carct;
	private Date pDate;
	private Time pTime;
	private ArrayList<FileVO> file;
	
	
	public String getCarct() {
		return carct; 
	}
	public void setCarct(String carct) {
		this.carct = carct;
	}
	public String getMemid() {
		return memid;
	}
	public void setMemid(String memid) {
		this.memid = memid;
	}
	public String getRbd() {
		return rbd;
	}
	public void setRbd(String rbd) {
		this.rbd = rbd;
	}
	
	public ArrayList<FileVO> getFile() {
		return file;
	}
	public void setFile(ArrayList<FileVO> file) {
		this.file = file;
	}
	public String getBloc() {
		return bloc;
	}
	public void setBloc(String bloc) {
		this.bloc = bloc;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getBceo() {
		return bceo;
	}
	public void setBceo(String bceo) {
		this.bceo = bceo;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public int getBcnt() {
		return bcnt;
	}
	public void setBcnt(int bcnt) {
		this.bcnt = bcnt;
	}
	public int getImgno() {
		return imgno;
	}
	public void setImgno(int imgno) {
		this.imgno = imgno;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
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
	public String getPtt() {
		return ptt;
	}
	public void setPtt(String ptt) {
		this.ptt = ptt;
	}
	public String getBno() {
		return bno;
	}
	public void setBno(String bno) {
		this.bno = bno;
	}
	public String getPbd() {
		return pbd;
	}
	public void setPbd(String pbd) {
		this.pbd = pbd;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public String getRtt() {
		return rtt;
	}
	public void setRtt(String rtt) {
		this.rtt = rtt;
	}
	public String getPshow() {
		return pshow;
	}
	public void setPshow(String pshow) {
		this.pshow = pshow;
	}
	public String getRshow() {
		return rshow;
	}
	public void setRshow(String rshow) {
		this.rshow = rshow;
	}
	public String getToday() {
		return today;
	}
	public void setToday() {
		SimpleDateFormat form1 = new SimpleDateFormat("yyyy년 MM월 dd일");
//		SimpleDateFormat form2 = new SimpleDateFormat("HH:mm");
		this.today = form1.format(pDate);
	}
	public void setToday(String today) {
		this.today = today;
	}
	public Date getpDate() {
		return pDate;
	}
	
	public void setpDate(Date pDate) {
		this.pDate = pDate;
	}
	public Time getpTime() {
		return pTime;
	}
	public void setpTime(Time pTime) {
		this.pTime = pTime;
	}
	
	
}
