<%@page import="com.dao.TeacherDao"%>
<%@page import="com.pojo.TeacherPojo"%>
<%@page import="com.dao.StudentDao"%>
<%@page import="com.pojo.StudentPojo"%>
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
    <div class="left">
    	<ol>
    		<li class="List"><a href="StudentLogin.jsp">Student</a></li>
    		<li class="List"><a href="TeacherLogin.jsp">Teacher</a></li>
    		<li class="List"><a href="#student">Admin</a></li>
    		<li class="List"><a href="#student">Collage Info</a></li>
    	</ol>
    </div>
    
	<%
		Object Studid = request.getAttribute("id");
		int id2 = Integer.parseInt(request.getParameter("id1"));
		int id1 =0;
		try{
			if(Studid != null){
				String id = Studid.toString();
				id1 = Integer.parseInt(id);
			}
		}catch(NumberFormatException e){
			System.out.print("error");
		}
		
		
		TeacherPojo tp = new TeacherPojo();
		TeacherDao td = new TeacherDao();
		tp = td.viewId(id1);
		
	%>

	<div   class="Studtable">
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>City</th>
			<th>Deparment</th>
			<th>Mobile</th>
			<th>Sub1</th>
			<th>Sub2</th>
			<th>Register No</th>
			<th>User ID</th>
		</tr>
		<tr>
			<td><%= tp.getId() %></td>
			<td><%= tp.getName() %></td>
			<td><%= tp.getCity() %></td>
			<td><%= tp.getDept()%></td>
			<td><%= tp.getMob() %></td>
			<td><%= tp.getSub1() %></td>
			<td><%= tp.getSub2() %></td>
			<td><%= tp.getRno() %></td>
			<td><%= tp.getUserid() %></td>
		</tr>
	
	</table>
	
	<a href="TeachUpdate.jsp?id=<%= tp.getId() %>">Update</a>
	<a href="TeachDelete?id=<%= tp.getId() %>">Delete</a>
	
 	<div class="all">
		<a href="AllStudent.jsp?id=<%= tp.getId() %>">All Student</a>
		<a href="AllTeacher.jsp">All Teacher</a>
		<a href="AddStudent.jsp">Add Student</a>
	</div>
	
	</div>
		
</div>	
 	
</body>
</html>