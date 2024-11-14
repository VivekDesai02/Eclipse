<%@page import="com.dao.StudentDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.pojo.StudentPojo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
	<link rel="stylesheet" type="text/css" href="HomeStyle.css">
		<link rel="stylesheet" type="text/css" href="StudentStyle.css">
	<style type="text/css">
	.Studtable{
		border: 1px solid red;
		width: auto;
		margin: 0px 5px 5px 10px;
		font-size:  x-large;
		padding: 5px;
		
	}
	.main{
		margin: 38px 0px 0px 0px;
		display: inline-flex;
	}
	
	.deta{
		float: left;
		background-color: pink;
		width: 200px;
		top:0;
		left:0;
		
	}
	</style>
</head>
<body>

	<ul>
        <label id="NavHeader">VIDYA MANDIR MHASAVE</label>
        <li><a href="#contact"><i class="fa-solid fa-phone"></i>Contact</a></li>
        <li><a href="#contact"><i class="fa-solid fa-address-card"></i>AboutUs</a></li>
        <li><a href="#Location"><i class="fa-solid fa-location-dot"></i>Location</a></li>
    </ul>
   <div class="main">
    <div class="deta">
    	<ol>
    		<li class="List"><a href="StudentLogin.jsp">Student</a></li>
    		<li class="List"><a href="TeacherLogin.jsp">Teacher</a></li>
    		<li class="List"><a href="#student">Admin</a></li>
    		<li class="List"><a href="#student">Collage Info</a></li>
    	</ol>
    </div>

	
	
	<%
		Object Studid = request.getAttribute("id");
		int id1 =0;
		try{
			String id = Studid.toString();
			id1 = Integer.parseInt(id);
			
		}catch(NumberFormatException e){
			System.out.print("error");
		}
	
		StudentPojo sp = new StudentPojo();
		StudentDao sd = new StudentDao();
		sp = sd.viewId(id1);
	%>
	<h1></h1>

	
	
	<div   class="Studtable">
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Deparment</th>
			<th>Year</th>
			<th>City</th>
			<th>RollNo</th>
			<th>Mobile</th>
			<th>Mail</th>
		</tr>
		<tr>
			<td><%= sp.getId() %></td>
			<td><%= sp.getName() %></td>
			<td><%= sp.getDept() %></td>
			<td><%= sp.getYear() %></td>
			<td><%= sp.getCity() %></td>
			<td><%= sp.getRollno() %></td>
			<td><%= sp.getMobile() %></td>
			<td><%= sp.getMail() %></td>
		</tr>
	
	</table>
	
	<a href="StudentUpadate.jsp?id=<%= sp.getId() %>">Update</a>
	<a href="Delete?id=<%= sp.getId() %>">Delete</a>
	
	
 	<div class="all">
		<a href="#ALLSTudent">All Student</a>
		<a href="#ALLTeacher">All Teacher</a>
	</div>
	</div>
	
	
</div>	
 	

	
</body>
</html>