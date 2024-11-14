package com.stud;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudLog
 */
@WebServlet("/StudLog")
public class StudLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudLog() {
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
		
		int rollno;
        String pas = request.getParameter("pass");
        try {
            rollno = Integer.parseInt(request.getParameter("rollno"));
        } catch (NumberFormatException e) {
            pw.print("<h3>Invalid Roll Number format!</h3>");
            return;
        }
        
       
        try 
        {
        Connection conn = com.conn.dbConnection.connection();
        String q = "SELECT * FROM `stud` WHERE `rollno`=?";
             PreparedStatement pst = conn.prepareStatement(q);
             
            pst.setInt(1, rollno);
            try {
            	ResultSet rs = pst.executeQuery();
            	
                if (rs.next()) {
                    String storedPass = rs.getString("pass");
                    int id = rs.getInt("id");
                   
                    if (storedPass.equals(pas)) {
//                        response.sendRedirect("Student.jsp");
                    	 request.setAttribute("id", id);
                    	request.getRequestDispatcher("Student.jsp").include(request, response);
                    } else {
                        pw.print("<h3>Login Unsuccessful!!</h3><h2 style='color: red'>PassWord Incurrect!!</h2>");
                        request.getRequestDispatcher("StudentLogin.jsp").include(request, response);
                    }
                } else {
                    pw.print("<h3>No student found with this roll number!</h3>");
                    request.getRequestDispatcher("StudentLogin.jsp").include(request, response);
                }
            }catch(Exception e) {
            	e.printStackTrace();
            	pw.print("<h3>An error occurred.</h3>");
            	
            }
        } catch (SQLException e) {
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
