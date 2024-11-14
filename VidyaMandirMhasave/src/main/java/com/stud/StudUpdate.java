package com.stud;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;
import com.pojo.StudentPojo;

/**
 * Servlet implementation class StudUpdate
 */
@WebServlet("/StudUpdate")
public class StudUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudUpdate() {
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
		
		int id = Integer.parseInt(request.getParameter("id"));
		int rno = Integer.parseInt(request.getParameter("rno"));
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		String dept = request.getParameter("dept");
		String year = request.getParameter("year");
		String mob = request.getParameter("mob");
		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");
		
		
		StudentPojo sp = new StudentPojo();
		sp.setId(id);
		sp.setName(name);
		sp.setCity(city);
		sp.setDept(dept);
		sp.setYear(year);
		sp.setRollno(rno);
		sp.setMobile(mob);
		sp.setMail(mail);
		sp.setPass(pass);
		
		StudentDao sd = new StudentDao();
		int result = sd.update(sp);
		
		if(result == 1) {
			request.setAttribute("id", id);
			request.getRequestDispatcher("Student.jsp").include(request, response);
		}else {
			pw.print("<h3>Data Not Updated!</h3>");
			request.getRequestDispatcher("StudentUpdate.jsp").include(request, response);
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
