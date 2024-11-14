

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.StatementEventListener;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
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
		
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		int mobile =Integer.parseInt(request.getParameter("mobile"));
		
//		pw.print(name+ " "+ city + " "+mobile);
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sudent","root","");
			String q = "INSERT INTO `stud_info`(`Name`, `City`, `mob`) VALUES (?,?,?)";
			
			PreparedStatement pst = conn.prepareStatement(q);
			pst.setString(1, name);
			pst.setString(2, city);
			pst.setInt(3, mobile);
			
			int Status = pst.executeUpdate();
			if(Status == 1) {
				response.sendRedirect("Home");
			}else {
				pw.print("<h2>Data Not Inserted!</h2>");
				request.getRequestDispatcher("add.html").include(request, response);
			}
			
			
		}catch(Exception e) {
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
