package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
	static final String driverName_MySQL="com.mysql.cj.jdbc.Driver";
	static final String url_MySQL="jdbc:mysql://localhost/kimdb";
	static final String userName="root";
	static final String passwd="12345678";

	public static Connection connect() {
		Connection conn=null;
		
		try {
			Class.forName(driverName_MySQL);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			conn=DriverManager.getConnection(url_MySQL, userName, passwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	public static void disconnect(PreparedStatement pstmt,Connection conn) {
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void disconnect(ResultSet rs,PreparedStatement pstmt,Connection conn) {
		try {
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
