<%@page import="com.dao.TeacherDao"%>
<%@page import="com.pojo.TeacherPojo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
	<link rel="stylesheet" type="text/css" href="HomeStyle.css">
	<link rel="stylesheet" type="text/css" href="StudUpStyle.css">
</head>
<body>
	
	<ul>
        <label id="NavHeader">VIDYA MANDIR MHASAVE</label>
        <li><a href="#contact"><i class="fa-solid fa-phone"></i>Contact</a></li>
        <li><a href="#contact"><i class="fa-solid fa-address-card"></i>AboutUs</a></li>
        <li><a href="#Location"><i class="fa-solid fa-location-dot"></i>Location</a></li>
    </ul>

	<%
		TeacherPojo tp = new TeacherPojo();
		int id = Integer.parseInt(request.getParameter("id"));
		TeacherDao td = new TeacherDao();
		tp = td.viewId(id);
	%>
	<div id="updateform">
	
		<h2>Upadte Data</h2>
		<form action="TeachUpdate">
			<label>ID: </label>
			<input type="text" name="id" value=<%= tp.getId() %> readonly="readonly" class="in"><br><br>
			<label>REGISTER NO: </label>
			<input type="text" name="rno" value=<%= tp.getRno() %> readonly="readonly" class="in"><br><br>
			<label>NAME: </label>
			<input type="text" name="name" value=<%= tp.getName() %> class="in"><br><br>
			<label>CITY: </label>
			<input type="text" name="city" value=<%= tp.getCity() %> class="in"><br><br>
			<label>DEPARTMENT: </label>
			<input type="text" name="dept" value=<%= tp.getDept() %> class="in"><br><br>
			<label>MOBILE: </label>
			<input type="text" name="mob" value=<%= tp.getMob() %> class="in"><br><br>
			<label>SUB1: </label>
			<input type="text" name="sub1" value=<%= tp.getSub1() %> class="in"><br><br>
			<label>SUB2: </label>
			<input type="text" name="sub2" value=<%= tp.getSub2() %> class="in"><br><br>
			<label>USER ID: </label>
			<input type="text" name="user" value=<%= tp.getUserid() %> class="in"><br><br>
			<label>PASSWORD</label>
			<input type="password" name="pass" value=<%= tp.getPass() %> class="in"><br><br>
			<input type="submit" value="Update" id="sub">
			<a href="Home.jsp" class="upbutten">Back</a>	
		</form>
		
	</div>
	
</body>
</html>