package com.foodApplication.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	
	
	
	private static final String CHECKEMAIL = "SELECT * FROM USER WHERE EMAIL = ?";
	
	private Connection con;

	private PreparedStatement pstmt;

	private ResultSet resultSet;

	
	
	
	@Override
	public void init() throws ServletException
	{
		String url = "jdbc:mysql://localhost:3310/foodapplication";
		String dbUn = "root";
		String dbPswd = "Basava@2002";
		
		try
		{

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,dbUn ,dbPswd);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		HttpSession session = req.getSession();
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		
		try
		{
			pstmt = con.prepareStatement(CHECKEMAIL);
			pstmt.setString(1, email);
			resultSet = pstmt.executeQuery();
			
			if(resultSet.next())
			{
				if(password.equals(resultSet.getString("password")))
				{
					String name = resultSet.getString("username");
					 email = resultSet.getString("email");
					 String address = resultSet.getString("address");
					 
					 
					 Cookie c2 = new Cookie("email", email);
					
					 resp.addCookie(c2);
					 
					
					session.setAttribute("name", name);
					session.setAttribute("email", email);
					session.setAttribute("address", address);
				
					
					
					req.getRequestDispatcher("GetRestaurant").forward(req, resp);
					
				}
				else
				{
					resp.getWriter().println("<h1> password Incorrect </h1>");
				}
			}
			else
			{
				resp.getWriter().println("<h1> No such email has registered.</h1>");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			resp.getWriter().println(e.getMessage());
		}
		
		
		
	}
	
	@Override
	public void destroy() {
		try
		{
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
