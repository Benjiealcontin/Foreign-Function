package test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class loginservlet
 */
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loginservlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		final String url = "jdbc:mysql://localhost:3306/bb";
		final String users = "root";
		final String password = "";
		final String dbloader = "com.mysql.jdbc.Driver";
		final String sql = "SELECT * FROM `department` WHERE DepName=?";

		String name = request.getParameter("name");

		/*
		 * loginmodel mod = new loginmodel(); mod.setStudentname(name);
		 */
		secondvalidate valid = new secondvalidate();
		valid.setDepName(name);
		logindao dao = new logindao();

		try {
			Connection con;
			PreparedStatement pst;
			ResultSet rs;

			Class.forName(dbloader);
			con = DriverManager.getConnection(url, users, password);
			pst = con.prepareStatement(sql);
			pst.setString(1, name);
			rs = pst.executeQuery();

			if (dao.validate(valid)) {
				while (rs.next()) {
					String id = rs.getString("DepartID");
					HttpSession session = request.getSession();
					request.setAttribute("id", id);
					RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
					rd.include(request, response);
				}
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
				rd.include(request, response);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
