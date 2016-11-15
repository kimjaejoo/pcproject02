package co.kr.jaejoo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class U {
	
	private static U u = new U();
	private String url = "jdbc:mysql://jsptest.cpkkponxntb7.ap-northeast-2.rds.amazonaws.com:3306/";
	private String driver = "com.mysql.jdbc.Driver";
	private String user = "test";
	private String password = "test1234";
	private String dbName = "pcproject";
	private Connection conn;
	
	public static U getInstance(){
		return u;
	}
	
	public Connection getConnection(){
		if(conn == null){
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url + dbName , user, password);
				System.out.println("db연결성공");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	
	
}
