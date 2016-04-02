package com.prospect.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.catalina.core.ApplicationContext;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.AbstractApplicationContext;
import com.prospect.userinfo.User;
import com.prospect.userinfo.UserValidationHibernate;

public class RegisterAction extends Action  {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
      ApplicationContext context = new ClassPathXmlApplicationContext("com/prospect/spring/bean-core.xml");
		
		User user=(User)context.getBean("user");
		
		
		user.setFirstname(request.getParameter("fname"));
		user.setLastname(request.getParameter("lname"));
		user.setPassword(request.getParameter("pwd"));
		user.setUserName(request.getParameter("uname"));
		System.out.println("*******RegisterSubmitAction****************");
		System.out.println("11");
		
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
		
		return mapping.findForward("newregister");
	}
	
	
	

}
