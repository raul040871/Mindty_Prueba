package com.mindty.controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mindty.persistence.DemoDataEM;

@WebServlet("/demodata")
public class DemoDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isOK = "SO BAD TT";
				try {
					DemoDataEM.getInstance().updateDemoData();
					isOK="SO GOOD :D";
				} catch (Exception e) {
					e.printStackTrace();
				}
		response.getWriter().append("Data status: ").append(isOK);
	}
}
