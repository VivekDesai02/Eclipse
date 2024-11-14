package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import com.pojo.StudentPojo;




public class StudentDao {
	public List<StudentPojo> viweData(){
		List<StudentPojo> stud1 = new ArrayList<>();
		
		try {
			Connection conn = com.conn.dbConnection.connection();
			String q = "SELECT * FROM `stud`";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(q);
			
			while(rs.next()) {
				StudentPojo sp = new StudentPojo();
				sp.setId(rs.getInt("id"));
				sp.setName(rs.getString("name"));
				sp.setDept(rs.getString("dept"));
				sp.setYear(rs.getString("year"));
				sp.setCity(rs.getString("city"));
				sp.setRollno(rs.getInt("rollno"));
				sp.setMobile(rs.getString("Mobile"));
				sp.setMail(rs.getString("mail"));
				stud1.add(sp);
			}
			
		} catch (Exception e) {
			System.out.println("Error To View Data");
			e.printStackTrace();
		}
		
		return stud1;
	}
	
	
	public StudentPojo viewId(int id) {
		StudentPojo sp = null;
		try {
			Connection conn = com.conn.dbConnection.connection();
			String q = "SELECT * FROM `stud` WHERE `id`=?";
			PreparedStatement pst = conn.prepareStatement(q);
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				sp = new StudentPojo();
				sp.setId(rs.getInt("id"));
				sp.setName(rs.getString("name"));
				sp.setDept(rs.getString("dept"));
				sp.setYear(rs.getString("year"));
				sp.setCity(rs.getString("city"));
				sp.setRollno(rs.getInt("rollno"));
				sp.setMobile(rs.getString("Mobile"));
				sp.setMail(rs.getString("mail"));
				sp.setPass(rs.getString("pass"));
				
			}
			
		}catch(Exception e) {
			System.out.println("Error to View ID");
			e.printStackTrace();
		}
		return sp;
	}
	
	public int update(StudentPojo sp) {
		try {
			Connection conn = com.conn.dbConnection.connection();
			String q = "UPDATE `stud` SET `name`=?,`dept`=?,`year`=?,`city`=?,`rollno`=?,`Mobile`=?,`mail`=?,`pass`=? WHERE `id`=?";
			PreparedStatement pst = conn.prepareStatement(q);
			pst.setString(1, sp.getName());
			pst.setString(2, sp.getDept());
			pst.setString(3, sp.getYear());
			pst.setString(4, sp.getCity());
			pst.setInt(5, sp.getRollno());
			pst.setString(6, sp.getMobile());
			pst.setString(7, sp.getMail());
			pst.setString(8, sp.getPass());
			pst.setInt(9, sp.getId());
			
			int status = pst.executeUpdate();
			
			if(status == 1) {
				return 1;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error to Update");
		}
		return 0;
	}
	
	
	
	
	public int delete(StudentPojo ep) {
		try {
			
			Connection conn = com.conn.dbConnection.connection();
			String q ="DELETE FROM `stud` WHERE `id`=?";
			PreparedStatement pst = conn.prepareStatement(q);
			
			pst.setInt(1, ep.getId());
			
			int Status = pst.executeUpdate();
			if(Status == 1) {
				return 1;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	public int add(StudentPojo sp) {
		try {
			Connection conn = com.conn.dbConnection.connection();
			String q = "INSERT INTO `stud`(`name`, `dept`, `year`, `city`, `rollno`, `Mobile`, `mail`, `pass`) VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(q);
			
			pst.setString(1, sp.getName());
			pst.setString(2, sp.getDept());
			pst.setString(3, sp.getYear());
			pst.setString(4, sp.getCity());
			pst.setInt(5, sp.getRollno());
			pst.setString(6, sp.getMobile());
			pst.setString(7, sp.getMail());
			pst.setString(8, sp.getPass());
			
			
			int Status = pst.executeUpdate();
			
			if(Status == 1) {
				return 1;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Add Data Error");
		}
		
		return 0;
	}
}
