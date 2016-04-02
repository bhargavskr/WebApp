package com.airysoft.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.airysoft.jdbc.RegisterHelper;
import com.prospect.userinfo.User;
import com.prospect.userinfo.UserValidationHibernate;

public class RegisterServlet extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	
	
		User user=new User();
		
		user.setFirstname(request.getParameter("fname"));
		user.setLastname(request.getParameter("lname"));
		user.setPassword(request.getParameter("pwd"));
		user.setUserName(request.getParameter("uname"));
		
		System.out.println("1");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
	//	if(RegisterHelper.isValidRegistration(user)){
		if(UserValidationHibernate.isValidHibernate(user)){
		//if(username.equals("bhargav")){
		out.println("<h2>Sorry you are already registered <h2><br/>");
         out.println("<a href= \"registration.html\" >press to retry</a><br/>");
		
		}
		else
		{
		
		out.println("<h2>  Registration Successful <h2><br/>");
		out.println("<h2> You entered Username as : "+user.getUserName()+" and Password as : "+user.getPassword()+" firstname as : "+user.getFirstname()+" and lastname as : "+user.getLastname()+"<h2><br/>");
		
		}
		out.println("</body>");
		out.println("</html>");
		
		
	}
	
	
		
		
}

