package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/admin")
public class AdminLoginServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		    PrintWriter pw=res.getWriter();
		    res.setContentType("text/html");
		    AdminBean ab=new AdminLoginDAO().login(req);
		    if(ab==null) {
		    	pw.println("Invalid login");
		    	RequestDispatcher rd=req.getRequestDispatcher("AdminLogin.html");
		    	rd.include(req, res);
		    }
		    else {
		    	pw.println("Welcome "+ab.getId());
		    	RequestDispatcher rd=req.getRequestDispatcher("Admin.html");
		    	rd.include(req, res);
				Cookie ck= new Cookie("uname", ab.getId());
				res.addCookie(ck);
				
			}
		    
	}
}
