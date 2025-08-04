package com.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/print")
public class EligibilityServlet extends HttpServlet{
	private static final long serialVersionUID = 5282760347897930595L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		ServletOutputStream pw = resp.getOutputStream();
		
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String country = req.getParameter("country");
		String adharNo = req.getParameter("adhar");

		String gender = req.getParameter("gender");
		
		if((age>21 && age<60 && gender.equalsIgnoreCase("male")) || (age>18 && age<60 && gender.equalsIgnoreCase("female"))) {
			pw.println("<h2>Valid User Data</h2>");
			pw.println("<h2>Name : "+name+"</h2>");
			pw.println("<h2>Age : "+age+"</h2>");
			pw.println("<h2>Country Name : "+country+"</h2>");
			pw.println("<h2>Adhar Number : "+adharNo+"</h2>");
			
			if(gender.equalsIgnoreCase("male")) {
				pw.println("<h2>For Male : </h2>");
				pw.println("<h2>Mr."+ name +" Eligible for marriage thinnk one<br> more time before taking the decision.</h2>");
			}
			else {
				pw.println("<h2>For Female</h2>");
				pw.println("<h2>Ms."+ name +" Eligible for marriage thinnk one<br> more time before taking the decision.</h2>");
			}
			
		}
		else {
			pw.println("<h2>Valid User Data</h2>");
			pw.println("<h2>Name : "+name+"</h2>");
			pw.println("<h2>Age : "+age+"</h2>");
			pw.println("<h2>Country Name : "+country+"</h2>");
			pw.println("<h2>Adhar Number : "+adharNo+"</h2>");
			
			if(gender.equalsIgnoreCase("male")) {
				pw.println("<h2>For Male : </h2>");
				pw.println("<h3>Mr."+ name +" Not Eligible for marriage stay<br> happy Don't be in Hurry</h3>");
			}
			else {
				pw.println("<h2>For Female</h2>");
				pw.println("<h3>Ms."+ name +" Not Eligible for marriage stay<br> happy Don't be in Hurry.</h3>");
			}
		}
	}

}
