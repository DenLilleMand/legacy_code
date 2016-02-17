<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> JSP/Servlet Listening on chat</title>
</head>
<body>
	<form id="usernameForm" action="chat" method="POST">
            <label for="username">User name:</label>
            <input type="text" name="username" class="form-control" id="username">
             <label for="username">Start server:</label>
            <input type="text" name="startServer" class="form-control" id="startServer">
	<button type="submit" value="submit" class="btn">start client.</button>
	</form>
	
	
			<% 
				ArrayList<String> messages = (ArrayList<String>) request.getAttribute("messages");
				if(messages != null)
				{
					for(String s : messages)
					{
			%>
						<%=s %>
			<%
					}
			%>
										
			<% 	} else
				{
			%>
					we didn't receive any messages !
       		<% 	}
       		%>
	
	




</body>
</html>