package test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class displayservlet
 */
public class displayservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public displayservlet() {
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

		String id = (String) request.getAttribute("id");
		try {
			final String url = "jdbc:mysql://localhost:3306/bb";
			final String users = "root";
			final String password = "";
			final String dbloader = "com.mysql.jdbc.Driver";
			final String sql = "SELECT employee.name,department.DepName FROM employee JOIN department ON employee.DepID = department.DepartID WHERE employee.DepID='"
					+ id + "'";

			Connection con;
			PreparedStatement pst;
			ResultSet rs;

			Class.forName(dbloader);
			con = DriverManager.getConnection(url, users, password);
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {

				String one = rs.getString("Name");
				String w = rs.getString("DepName");

				request.setAttribute("F", one);
				request.setAttribute("L", w);
				request.setAttribute("ID", id);

				request.getRequestDispatcher("display.jsp").forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
