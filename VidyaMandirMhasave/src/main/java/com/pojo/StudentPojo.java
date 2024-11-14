package com.pojo;

public class StudentPojo {
	private int id;
	private String name;
	private String dept;
	private String year;
	private String city;
	private int rollno;
	private String mobile;
	private String mail;
	private String pass;
	public StudentPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public StudentPojo(int id, String name, String dept, String year, String city, int rollno, String mobile, String mail,
			String pass) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.year = year;
		this.city = city;
		this.rollno = rollno;
		this.mobile = mobile;
		this.mail = mail;
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
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "StudentPojo [id=" + id + ", name=" + name + ", dept=" + dept + ", year=" + year + ", city=" + city
				+ ", rollno=" + rollno + ", mobile=" + mobile + ", mail=" + mail + ", pass=" + pass + "]";
	}

	
	
	
	
}
