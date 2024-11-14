package com.pojo;

public class TeacherPojo {
	
	private int id;
	private String name;
	private String city;
	private String dept;
	private String mob;
	private String sub1;
	private String sub2;
	private int rno;
	private String userid;
	private String pass;
	public TeacherPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TeacherPojo(int id, String name, String city, String dept, String mob, String sub1, String sub2, int rno,
			String userid, String pass) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.dept = dept;
		this.mob = mob;
		this.sub1 = sub1;
		this.sub2 = sub2;
		this.rno = rno;
		this.userid = userid;
		this.pass = pass;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public String getSub1() {
		return sub1;
	}
	public void setSub1(String sub1) {
		this.sub1 = sub1;
	}
	public String getSub2() {
		return sub2;
	}
	public void setSub2(String sub2) {
		this.sub2 = sub2;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "TeacherPojo [id=" + id + ", name=" + name + ", city=" + city + ", dept=" + dept + ", mob=" + mob
				+ ", sub1=" + sub1 + ", sub2=" + sub2 + ", rno=" + rno + ", userid=" + userid + ", pass=" + pass + "]";
	}

}
