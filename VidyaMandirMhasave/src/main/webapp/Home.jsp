<%@page import="com.dao.TeacherDao"%>
<%@page import="com.pojo.TeacherPojo"%>
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

</head>
<body>
	<ul>
        <label id="NavHeader">VIDYA MANDIR MHASAVE</label>
        <li><a href="#contact"><i class="fa-solid fa-phone"></i>Contact</a></li>
        <li><a href="#contact"><i class="fa-solid fa-address-card"></i>AboutUs</a></li>
        <li><a href="#Location"><i class="fa-solid fa-location-dot"></i>Location</a></li>
    </ul>
    
    <div class="left">
    	<ol>
    		<li class="List"><a href="StudentLogin.jsp">Student</a></li>
    		<li class="List"><a href="TeacherLogin.jsp">Teacher</a></li>
    		<li class="List"><a href="#student">Admin</a></li>
    		<li class="List"><a href="#student">Collage Info</a></li>
    	</ol>
    </div>
    
    <h1>Student Data</h1>
<table>
	
	
<%
		List<StudentPojo> stud1 = new ArrayList<>();
		StudentDao st = new StudentDao();
		stud1 = st.viweData();
		
		List<TeacherPojo> teach = new ArrayList<>();
		TeacherDao td = new TeacherDao();
		teach = td.viweData();
		for(TeacherPojo i:teach){	
%>
			<tr>
			<td><%= i.getId() %></td>
			<td><%= i.getName() %></td>
			
			</tr>
			
			
<%
		}

%>

</table>
	
    
   
</body>
</html>