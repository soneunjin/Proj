package com.team.www.vo;

import java.sql.*;
import java.text.*;

public class InsertVO {
	private int memno;
	private String bno, bname, btel, bloc, bceo;
	public int getMemno() {
		return memno;
	}
	public void setMemno(int memno) {
		this.memno = memno;
	}
	public String getBno() {
		return bno;
	}
	public void setBno(String bno) {
		this.bno = bno;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBtel() {
		return btel;
	}
	public void setBtel(String btel) {
		this.btel = btel;
	}
	public String getBloc() {
		return bloc;
	}
	public void setBloc(String bloc) {
		this.bloc = bloc;
	}
	public String getBceo() {
		return bceo;
	}
	public void setBceo(String bceo) {
		this.bceo = bceo;
	}
	
}
