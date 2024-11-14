package com.teach;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.TeacherDao;
import com.pojo.TeacherPojo;

/**
 * Servlet implementation class TeachUpdate
 */
@WebServlet("/TeachUpdate")
public class TeachUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeachUpdate() {
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
		String mob = request.getParameter("mob");
		
		String sub1 = request.getParameter("sub1");
		String sub2 = request.getParameter("sub2");
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		
		TeacherPojo tp = new TeacherPojo();
		tp.setId(id);
		tp.setRno(rno);
		tp.setName(name);
		tp.setCity(city);
		tp.setDept(dept);
		tp.setMob(mob);
		tp.setSub1(sub1);
		tp.setSub2(sub2);
		tp.setUserid(user);
		tp.setPass(pass);
		
		TeacherDao td = new TeacherDao();
		int result = td.update(tp);
		
		if(result == 1) {
			request.setAttribute("id", id);
			request.getRequestDispatcher("Teacher.jsp").include(request, response);
		}else {
			pw.print("<h3>Data Not Updated!</h3>");
			request.getRequestDispatcher("TeachUpdate.jsp").include(request, response);
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
