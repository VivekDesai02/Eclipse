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

	<div id="updateform">
	
		<h2>Upadte Data</h2>
		<form action="AddStud">
			<label>ROLL NO: </label>
			<input type="text" name="rno"   class="in"><br><br>
			<label>NAME: </label>
			<input type="text" name="name"  class="in"><br><br>
			<label>CITY: </label>
			<input type="text" name="city"  class="in"><br><br>
			<label>DEPARTMENT: </label>
			<input type="text" name="dept"  class="in"><br><br>
			<label>YEAR: </label>
			<input type="text" name="year"  class="in"><br><br>
			<label>MOBILE: </label>
			<input type="text" name="mob"  class="in"><br><br>
			<label>MAIL: </label>
			<input type="mail" name="mail"  class="in"><br><br>
			<label>PASSWORD</label>
			<input type="password" name="pass" class="in"><br><br>
			<input type="submit" value="Add" id="sub">
			<a href="Home.jsp" class="upbutten">Back</a>	
		</form>
		
	</div>
</body>
</html>