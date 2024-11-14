

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
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		int mobile =Integer.parseInt(request.getParameter("mobile"));
		int id = Integer.parseInt(request.getParameter("id"));

		try {
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sudent","root","");
			String q = "UPDATE `stud_info` SET `Name`=?,`City`=?,`mob`=? WHERE id=?";
			
			PreparedStatement pst = conn.prepareStatement(q);
			pst.setString(1, name);
			pst.setString(2, city);
			pst.setInt(3, mobile);
			pst.setInt(4, id);

			int status = pst.executeUpdate();
			if(status==1)
			{
				response.sendRedirect("Home");
			}
			else
			{
				pw.print("<h2>Data not updated !</h2>");
				request.getRequestDispatcher("updated.html").include(request, response);
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
