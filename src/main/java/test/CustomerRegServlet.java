package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/reg")
@SuppressWarnings("serial")
public class CustomerRegServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException{
		PrintWriter pw =res.getWriter();
		res.setContentType("text/html");
		CustomerBean cb = new CustomerBean();
		cb.setCname(req.getParameter("cname"));
		cb.setCmid(req.getParameter("cmid"));
		cb.setPhon(Long.parseLong(req.getParameter("cphno")));
		cb.setCcity(req.getParameter("ccity"));
		cb.setCstate(req.getParameter("cstate"));
		cb.setCpincode(Integer.parseInt(req.getParameter("cpcode")));
		cb.setCpass(req.getParameter("cpword"));
		int k=new RegisterDAO().resgier(cb);
		if(k>0) {
			pw.println("Costomer added Successfully..<br>");
			RequestDispatcher rd=req.getRequestDispatcher("home.html");
			rd.include(req, res);
		}


	}
}
