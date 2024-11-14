<%@page import="com.dao.TeacherDao"%>
<%@page import="com.pojo.TeacherPojo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Teacher</title>
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
			<th>City</th>
			<th>Deparment</th>
			<th>Mobile</th>
			<th>Sub1</th>
			<th>Sub2</th>
			<th>Register No</th>
			<th>User ID</th>
		</tr>
	<%
			
	List<TeacherPojo> teach = new ArrayList<>();
	TeacherDao td = new TeacherDao();
	teach = td.viweData();
	for(TeacherPojo tp:teach){	
	%>
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
	<% }%>
	</table>
	</div>

</body>
</html>