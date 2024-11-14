package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojo.StudentPojo;
import com.pojo.TeacherPojo;

public class TeacherDao {
	
	public List<TeacherPojo> viweData(){
		List<TeacherPojo> teach = new ArrayList<>();
		
		try {
			Connection conn = com.conn.dbConnection.connection();
			String q = "SELECT * FROM `teacherinfo`";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(q);
			
			while(rs.next()) {
				TeacherPojo tp = new TeacherPojo();
				tp.setId(rs.getInt("id"));
				tp.setName(rs.getString("name"));
				tp.setCity(rs.getString("city"));
				tp.setDept(rs.getString("dept"));
				tp.setMob(rs.getString("mobile"));
				tp.setSub1(rs.getString("sub1"));
				tp.setSub2(rs.getString("sub2"));
				tp.setRno(rs.getInt("rNo"));
				tp.setUserid(rs.getString("username"));
				tp.setPass(rs.getString("pass"));
				teach.add(tp);
			}
			
		} catch (Exception e) {
			System.out.println("Error To View Data");
			e.printStackTrace();
		}
		
		return teach;
	}
	
	
	public TeacherPojo viewId(int id) {
		TeacherPojo tp = null;
		try {
			Connection conn = com.conn.dbConnection.connection();
			String q = "SELECT * FROM `teacherinfo` WHERE `id`=?";
			PreparedStatement pst = conn.prepareStatement(q);
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				tp = new TeacherPojo();
				tp.setId(rs.getInt("id"));
				tp.setName(rs.getString("name"));
				tp.setCity(rs.getString("city"));
				tp.setDept(rs.getString("dept"));
				tp.setMob(rs.getString("mobile"));
				tp.setSub1(rs.getString("sub1"));
				tp.setSub2(rs.getString("sub2"));
				tp.setRno(rs.getInt("rNo"));
				tp.setUserid(rs.getString("username"));
				tp.setPass(rs.getString("pass"));
				
			}
			
		}catch(Exception e) {
			System.out.println("Error to View ID");
			e.printStackTrace();
		}
		return tp;
	}
	
	
	
	public int update(TeacherPojo tp) {
		try {
			Connection conn = com.conn.dbConnection.connection();
			String q = "UPDATE `teacherinfo` SET `name`=?,`city`=?,`dept`=?,`mobile`=?,`sub1`=?,`sub2`=?,`rNo`=?,`username`=?,`pass`=? WHERE `id`=?";
			PreparedStatement pst = conn.prepareStatement(q);
			pst.setString(1, tp.getName());
			pst.setString(2, tp.getCity());
			pst.setString(3, tp.getDept());
			pst.setString(4, tp.getMob());
			pst.setString(5, tp.getSub1());
			pst.setString(6, tp.getSub2());
			pst.setInt(7, tp.getRno());
			pst.setString(8, tp.getUserid());
			pst.setString(9, tp.getPass());
			pst.setInt(10, tp.getId());
			
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
	
}


	
