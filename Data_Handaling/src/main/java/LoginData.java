

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

/**
 * Servlet implementation class LoginData
 */
@WebServlet("/LoginData")
public class LoginData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginData() {
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
		
		String mail = request.getParameter("email");
		String pass = request.getParameter("pass");
		
//		pw.print(mail);
//		pw.print(pass);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
			String q ="SELECT * FROM `user_register` WHERE Email=? and pass=?";
			PreparedStatement pst=conn.prepareStatement(q);
			pst.setString(1, mail);
			pst.setString(2, pass);
//			Statement st = conn.createStatement();
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				response.sendRedirect("http://localhost/CITS1/home.php");
			}else {
				pw.print("<h3>Not Login</h3>");
				request.getRequestDispatcher("Login.html").include(request, response);
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
