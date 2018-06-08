package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectionUtils {

	
	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO nekim log framework-om ovo bi trebalo da se upisuje u log
			e.printStackTrace();
		}
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/si", "root", "");
		} catch (SQLException e) {
			// TODO nekim log framework-om ovo bi trebalo da se upisuje u log
			e.printStackTrace();
		}

		return null;
	}
	
	public static void closeConnection(Connection conn){
		if (conn == null) {
			return;
		}

		try {
			conn.close();
		} catch (SQLException e) {
			// TODO nekim log framework-om ovo bi trebalo da se upisuje u log
			e.printStackTrace();
		}
	}
	
		
}