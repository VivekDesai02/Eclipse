

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class updatedata
 */
@WebServlet("/updatedata")
public class updatedata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatedata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		String name = request.getParameter("name");
		String ct = request.getParameter("city");
		int sal = Integer.parseInt(request.getParameter("salary"));
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","");
			String q = "UPDATE emp_info SET name=?,city=?,salary=? WHERE id=?";
			PreparedStatement prs = conn.prepareStatement(q);
			prs.setString(1, name);
			prs.setString(2, ct);
			prs.setInt(3, sal);
			prs.setInt(4, id);
			
			int status = prs.executeUpdate();
			if(status == 1) {
				response.sendRedirect("FetchData");
			}
			else {
				pw.print("<h3 style='color:red;'>Data Not Updated</h3>");
				request.getRequestDispatcher("update.html").include(request, response);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
