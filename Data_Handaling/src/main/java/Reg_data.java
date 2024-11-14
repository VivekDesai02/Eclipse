

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
 * Servlet implementation class Reg_data
 */
@WebServlet("/Reg_data")
public class Reg_data extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reg_data() {
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
		String city = request.getParameter("city");
//		int mob = Integer.parseInt(request.getParameter("mob"));
		int mob = Integer.parseInt(request.getParameter("mob"));
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
			String q = "INSERT INTO user_register(Name, City,mob,Email,pass) VALUES (?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(q);
			pst.setString(1, name);
			pst.setString(2, city);
			pst.setInt(3, mob);
			pst.setString(4, email);
			pst.setString(5, pass);
			
			int status = pst.executeUpdate();
			if(status == 1) {
				response.sendRedirect("Login.html");
			}else {
				pw.print("<h3>don't Registration!</h3>");
				request.getRequestDispatcher("Registration.html").include(request, response);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
				
		
	
	}

}
