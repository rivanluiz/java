package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {

	Connection con;
	PreparedStatement stmt;
	ResultSet rs;
	
	protected void open() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "root", "coti");
	}
	
	protected void close() throws Exception{
		if (con != null)
			con.close();
		if (stmt != null)
			stmt.close();
		if (rs != null)
			rs.close();
	}
}
