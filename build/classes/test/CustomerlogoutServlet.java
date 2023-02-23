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
@WebServlet("/logout")
public class CustomerlogoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse res) 
			throws IOException,ServletException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		Cookie ck[]=req.getCookies();

		if(ck==null) {
			pw.println("Sorry ! Session Expied...");
			RequestDispatcher rd =req.getRequestDispatcher("home.html");
			rd.include(req, res);
		}
		else {
			ck[0].setMaxAge(0);
			res.addCookie(ck[0]);
			pw.println("Logout Succesfully...");
			RequestDispatcher rd =req.getRequestDispatcher("home.html");
			rd.include(req, res);
		}
	}
}
