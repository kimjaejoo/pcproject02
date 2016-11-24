package co.kr.jaejoo.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MakeConnection {
	private static MakeConnection mc = new MakeConnection();

	String url = "jdbc:mysql://jsptest.cpkkponxntb7.ap-northeast-2.rds.amazonaws.com:3306/pcproject";
	String driver = "com.mysql.jdbc.Driver";
	String user = "test";
	String password = "test1234";
	String dbName = "pcproject";
	
	private Connection connection;
	private static MakeConnection myObj;
	
	public MakeConnection() {
		System.out.println("singleton 연결시도");
	}

	public Connection getConnection(){
		Connection conn = null;
			try {
				Class driver_class = Class.forName(driver);
				Driver driver = (Driver) driver_class.newInstance();
				DriverManager.registerDriver(driver);
				conn = DriverManager.getConnection(url , user, password);
			//	System.out.println("db연결성공");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("드라이버로딩 실패");
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return conn; // 자원반납
	}
	
	public static MakeConnection getInstance() {
		if(myObj == null){
			myObj = new MakeConnection();
		}
		return myObj;
	}
	
	public static void main(String[] args) {
		MakeConnection mc = MakeConnection.getInstance();
	}
	

}
