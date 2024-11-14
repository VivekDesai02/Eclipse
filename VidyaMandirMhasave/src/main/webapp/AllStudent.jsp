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
<title>AllStudent</title>
	
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
	<link rel="stylesheet" type="text/css" href="HomeStyle.css">
	<link rel="stylesheet" type="text/css" href="StudentStyle.css">
	
	<style type="text/css">
	.Studtable{
		border: 1px solid red;
		width: auto;
		margin: 0px 5px 5px 300px;
		font-size:  x-large;
		padding: 5px;
		float: right;
		
	}
	.main{
		margin: 38px 0px 0px 0px;
		display: inline-flex;
	}
	
	.left{
		float: left;
		background-color: pink;
		width: 200px;
		top:0;
		left:0;
		display: flex;
		position: fixed;
		
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
	<%
		int id = Integer.parseInt(request.getParameter("id"));
	
	
		List<StudentPojo> lsp = new ArrayList<>();
		StudentDao st = new StudentDao();
		lsp = st.viweData();
		for(StudentPojo sp:lsp){
	%>
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
	<% }%>
	</table>
	
	<a href="Teacher.jsp?id1=<%= id %>">back</a>
	</div>

</body>
</html>