/**
 * ������ݿ�
 */
package com.rcd.conn;

import java.sql.*;

public class ConnectToMySQL {
	
	private static Connection conn = null;
	
	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(ConstantRec.MYSQL_DB_HOST, ConstantRec.USERNAME, ConstantRec.PASSWORD);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}

}
