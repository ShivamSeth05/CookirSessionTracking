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
@WebServlet("/Customer")
public class CustomerLogServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		CustomerBean cb= new CustomerLogDAO().login(req);
//		System.out.println(cb);
		if(cb==null) {
			pw.println("Invalid username and password");
			RequestDispatcher rd =req.getRequestDispatcher("CustomerLogin.html");
			rd.include(req, res);
		}
		else {			
			
			pw.println("Welcome "+cb.getCname()+"<br>");
			RequestDispatcher rd =req.getRequestDispatcher("link1.html");
			rd.include(req, res);
			Cookie ck = new Cookie("cname",cb.getCname());
			res.addCookie(ck);
		}
	}
}
