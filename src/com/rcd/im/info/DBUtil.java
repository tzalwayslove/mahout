package com.rcd.im.info;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

import com.rcd.conn.ConstantRec;


public class DBUtil {

	public static Connection getJDBCConnection() {
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = ConstantRec.MYSQL_DB_HOST;
		String username = ConstantRec.USERNAME;
		String password = ConstantRec.PASSWORD;
		Connection conn = null;
		try {
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

}