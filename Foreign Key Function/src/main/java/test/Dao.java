package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Dao {
	private final static String url = "jdbc:mysql://localhost:3306/bb";
	private final static String user = "root";
	private final static String password = "";
	private final static String dbloader = "com.mysql.jdbc.Driver";
	private final static String ADD = "INSERT INTO `employee`(`Name`, `DepID`) VALUES (?,?)";

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

	public static int Adduser(Model user) {
		int i = 0;
		try {
			Driver(dbloader);
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement(ADD);
			pst.setString(1, user.getName());
			pst.setInt(2, user.getDepID());

			i = pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;

	}

}
