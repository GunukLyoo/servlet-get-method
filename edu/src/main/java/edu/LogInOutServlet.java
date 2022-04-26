package edu;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/logProc")
public class LogInOutServlet extends HttpServlet{
	//login
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		if(id.isEmpty() || pwd.isEmpty()) {
			out.print("ID �Ǵ� ��й�ȣ�� �Է����ּ���.");
			return;
		}
		
		HttpSession session = req.getSession();
		if(session.isNew() || session.getAttribute("id") == null) {
			session.setAttribute("id", id);
			out.print("�α����� �Ϸ��Ͽ����ϴ�.");
		} else {
			out.print("���� �α��� �����Դϴ�.");
		}
		out.close();
	}
	
	//logout
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession(false);
		if(session != null && session.getAttribute("id") != null) {
			session.invalidate();
			out.print("�α׾ƿ� �۾� �Ϸ��Ͽ����ϴ�.");
		} else {
			out.print("���� �α��� ���°� �ƴմϴ�.");
		}
		out.close();
	}

	
}