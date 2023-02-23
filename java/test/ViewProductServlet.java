package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewProductServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {

		try {
			PrintWriter pw=response.getWriter();
			response.setContentType("text/html");
			Cookie c[] = request.getCookies();//Cookie
			if(c==null) {
				pw.println("Sorry ! Session Expied...");
				RequestDispatcher rd =request.getRequestDispatcher("home.html");

				rd.include(request, response);
			}else {
				String cName = c[0].getValue();

				pw.println("Page of Customer :"+cName+"<br>");
				RequestDispatcher rd =request.getRequestDispatcher("link1.html");
				rd.include(request, response);

				ArrayList<ProductBean> al=new RetriveProductDAO().retrive();
				if(al.size()==0) {
					pw.println("<br>Products not available...<br>");
				}else {
					Iterator<ProductBean> it=al.iterator();
					while (it.hasNext()) {
						ProductBean pb = (ProductBean) it.next();
						pw.println("<br>"+pb.getCode()+
								"&nbsp&nbsp"+pb.getName()+"&nbsp&nbsp" +pb.getPrice()+"&nbsp&nbsp"+pb.getQty());
					}//end of loop
				}//end of else
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
