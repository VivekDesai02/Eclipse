

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FetchData
 */
@WebServlet("/FetchData")
public class FetchData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchData() {
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
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","");
		String q = " ";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(q); 
		

		
		pw.print("<a style='background-color: blue; color: white;padding: 2px; text-decoration: none;' href='insert.html'>Add New</a>");
		
		pw.print("<a style='background-color: white; color: black;padding: 2px; text-decoration: none;' href='update.html'>upadate</a>");
		
		pw.print("<a style='background-color: blue; color: black;padding: 2px; text-decoration: none;' href='delete.html'>delete</a>");
		
		pw.print("<table border='1'>"
				+ "<tr>"
				+ "<th>ID</th>"
				+ "<th>Name</th>"
				+ "<th>City</th>"
				+ "<th>Salary</th>"
				+ "</tr>");
		
		while(rs.next())
		{
			pw.print("<tr>"
					+ "<td>"+rs.getInt("id")+"</td>"
					+ "<td>"+rs.getString("name")+"</td>"
					+ "<td>"+rs.getString("city")+"</td>"
					+ "<td>"+rs.getInt("salary")+"</td>"
							+ "</tr>");
		}
			
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	
	
	}



}
