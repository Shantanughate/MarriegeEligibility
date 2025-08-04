package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/validation")
public class ValidationServlet extends HttpServlet {
	private static final long serialVersionUID = -1445884048617168327L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		
		
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String country = req.getParameter("country");
		String adharNo = req.getParameter("adhar");
		String gender = req.getParameter("gender");
		
		if(name!=null && !name.isBlank() && country.equalsIgnoreCase("India") && adharNo.length()==12) {
			RequestDispatcher rd = req.getRequestDispatcher("print");
			rd.forward(req, resp);
		}else {
			RequestDispatcher rd = req.getRequestDispatcher("PersonData.html");
			rd.forward(req, resp);
		}
	}

}
