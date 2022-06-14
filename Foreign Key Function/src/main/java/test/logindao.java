package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class logindao {
	private final static String url = "jdbc:mysql://localhost:3306/bb";
	private final static String user = "root";
	private final static String password = "";
	private final static String dbloader = "com.mysql.jdbc.Driver";
	private final static String validate = "SELECT * FROM `department` WHERE DepName=?";

	public static void Driver(String dbloader) {
		try {
			Class.forName(dbloader);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;

	}

	public boolean validate(secondvalidate valid) {
		boolean status = false;
		try {

			Driver(dbloader);
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement(validate);
			pst.setString(1, valid.getDepName());

			ResultSet rs = pst.executeQuery();

			status = rs.next();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return status;

	}
}
