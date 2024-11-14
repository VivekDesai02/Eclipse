package com.teach;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TeachLog
 */
@WebServlet("/TeachLog")
public class TeachLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeachLog() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		String userid = request.getParameter("user");
		String pass = request.getParameter("pass");
		int id = 0;
		
		try {
			
			Connection conn = com.conn.dbConnection.connection();
			String q = "SELECT `id`, `username`, `pass` FROM `teacherinfo` WHERE `username`=?";
			PreparedStatement pst = conn.prepareStatement(q);
			pst.setString(1, userid);
			try {
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					String strpass = rs.getString("pass");
					id = rs.getInt("id");
					
					if(strpass.equals(pass)) {
						request.setAttribute("id", id);
						request.getRequestDispatcher("Teacher.jsp").include(request, response);
					}else {
						 pw.print("<h3>Login Unsuccessful!!</h3><h2 style='color: red'>PassWord Incurrect!!</h2>");
						 request.getRequestDispatcher("TeachLogin.jsp").include(request, response);
					}
				}else {
					 pw.print("<h3>No student found with this roll number!</h3>");
					 request.getRequestDispatcher("TeachLogin.jsp").include(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
            	pw.print("<h3>An error occurred.</h3>");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
            pw.print("<h3>An error occurred. Please try again later.</h3>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
