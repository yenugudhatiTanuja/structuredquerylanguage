package com.mysql;

public class Student {
	public  int sid;
    public String sname;
    public  String sdegree;
	public  String scity;
    
    public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int sid, String sname, String sdegree, String scity) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sdegree = sdegree;
		this.scity = scity;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSdegree() {
		return sdegree;
	}
	public void setSdegree(String sdegree) {
		this.sdegree = sdegree;
	}
	public String getScity() {
		return scity;
	}
	public void setScity(String scity) {
		this.scity = scity;
	}

	
	

}
