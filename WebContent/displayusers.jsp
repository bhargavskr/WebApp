<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import="java.util.ArrayList" %>
  <%@ page import="java.io.*" %>
  
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


			
	  <table align="center">		
	  <tr><th>Users Registered</th></tr>
<%
ArrayList<String> users=(ArrayList)request.getAttribute("users"); 
for(int i=0;i<users.size();i++)
				out.println("<tr><td>"+users.get(i)+"</td></tr>");
						
%>
</table>







</body>
</html>