<%@page import="com.dao.StudentDao"%>
<%@page import="com.pojo.StudentPojo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upadte Student</title>

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
		StudentPojo sp = new StudentPojo();
		int id = Integer.parseInt(request.getParameter("id"));
		StudentDao sd = new StudentDao();
		sp = sd.viewId(id);
	%>
	<div id="updateform">
	
		<h2>Upadte Data</h2>
		<form action="StudUpdate">
			<label>ID: </label>
			<input type="text" name="id" value=<%= sp.getId() %> readonly="readonly" class="in"><br><br>
			<label>ROLL NO: </label>
			<input type="text" name="rno" value=<%= sp.getRollno() %> readonly="readonly" class="in"><br><br>
			<label>NAME: </label>
			<input type="text" name="name" value=<%= sp.getName() %> class="in"><br><br>
			<label>CITY: </label>
			<input type="text" name="city" value=<%= sp.getCity() %> class="in"><br><br>
			<label>DEPARTMENT: </label>
			<input type="text" name="dept" value=<%= sp.getDept() %> class="in"><br><br>
			<label>YEAR: </label>
			<input type="text" name="year" value=<%= sp.getYear() %> class="in"><br><br>
			<label>MOBILE: </label>
			<input type="text" name="mob" value=<%= sp.getMobile() %> class="in"><br><br>
			<label>MAIL: </label>
			<input type="mail" name="mail" value=<%= sp.getMail() %> class="in"><br><br>
			<label>PASSWORD</label>
			<input type="password" name="pass" value=<%= sp.getPass() %> class="in"><br><br>
			<input type="submit" value="Update" id="sub">
			<a href="Student.jsp" class="upbutten">Back</a>	
			
		</form>
		
	</div>

</body>
</html>