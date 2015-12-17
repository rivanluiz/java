package br.com.nutriseg.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	protected void open() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_nutriseg", "root", "coti");
	}

	protected void close() throws SQLException{
		if(rs != null) 
			rs.close();
		if(ps != null) 
			ps.close();
		if(con != null) 
			con.close();
	}
	
}
