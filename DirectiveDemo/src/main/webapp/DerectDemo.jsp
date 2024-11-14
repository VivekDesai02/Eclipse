<%@page import="org.apache.catalina.SessionEvent"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.* " %>

 <%@ taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%=new Date() %>
<%@include file="header.jsp" %>

<p:set var="x" value="23"></p:set>
<p:out value="Hello"></p:out>
<p:out value="${x }"></p:out>
<p:if test="${x >10}">
x is greater
</p:if>

</body>
</html>