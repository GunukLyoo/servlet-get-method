package edu;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/cookie3")
public class CookieTest3Servlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int cnt = 0;
		Cookie[] list = req.getCookies();
		for(int i = 0; list!=null && i < list.length; i++) {
			if(list[i].getName().equals("count")) {
				cnt = Integer.parseInt(list[i].getValue());
			}
		}
		cnt++;
		Cookie c = new Cookie("count", cnt+"" );
		c.setMaxAge(60*60*24*10);
		resp.addCookie(c);
		
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("<h1>�湮 Ƚ�� :" + cnt);
		out.close();
	}
	
}
