

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
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sudent","root","");
			String q = "SELECT * FROM stud_info";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(q); 
			
			pw.print("<a style='color: black; background-color: red; padding: 5px 10px;margin: 3px;text-decoration: none;border: 3px black solid;border-radius: 10px;' href='add.html'> Add </a>");
			
			pw.print("<a style='color: black; background-color: red; padding: 5px 10px;margin: 3px;text-decoration: none;border: 3px black solid;border-radius: 10px;' href='update.html'> Update </a>");
			
			pw.print("<a style='color: black; background-color: red; padding: 5px 10px;margin: 3px;text-decoration: none;border: 3px black solid;border-radius: 10px;' href='Delete.html'> Delete </a>");

			pw.print("<table border='1' style='margin: 10px 0px;'>"
					+ "<tr>"
					+ "<th>ID</th>"
					+ "<th>Name</th>"
					+ "<th>City</th>"
					+ "<th>Mobile no.</th>");
			
			while(rs.next())
			{
				pw.print("<tr>"
						+ "<td>"+rs.getInt("id")+"</td>"
						+ "<td>"+rs.getString("Name")+"</td>"
						+ "<td>"+rs.getString("City")+"</td>"
						+ "<td>"+rs.getInt("mob")+"</td>"
								+ "</tr>");
			}
			
			pw.print("</table>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
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
