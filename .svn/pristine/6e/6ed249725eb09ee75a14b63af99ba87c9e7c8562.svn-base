package com.rcd.model;


import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.model.JDBCDataModel;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.rcd.conn.ConstantRec;

public class MyDataModel {

	public static JDBCDataModel myDataModel() {
		MysqlDataSource dataSource = new MysqlDataSource();
		JDBCDataModel dataModel = null;
		try {
			dataSource.setServerName(ConstantRec.DB_HOST);
			dataSource.setUser(ConstantRec.USERNAME);
			dataSource.setPassword(ConstantRec.PASSWORD);
			dataSource.setDatabaseName(ConstantRec.DB_NAME);
			// use JNDI
			//dataModel = new MySQLJDBCDataModel(DataBaseUtil.getDataSource(),"movie_preferences", "userID", "movieID","preference","timestamp");
			//不使用JNDI
			dataModel = new MySQLJDBCDataModel(dataSource,"movie_preferences", "userID", "movieID","preference","timestamp");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dataModel;
	}

}
