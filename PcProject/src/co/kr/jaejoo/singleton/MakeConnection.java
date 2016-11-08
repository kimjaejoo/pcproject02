package co.kr.jaejoo.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MakeConnection {
	private static MakeConnection mc = new MakeConnection();

	String url = "jdbc:mysql://jsptest.cpkkponxntb7.ap-northeast-2.rds.amazonaws.com:3306/Tacademy?user=test&password=test1234";
	Connection conn;

	public MakeConnection() {
	}

	public static MakeConnection getInstance() {
		return mc;
	}
	
	public Connection getConnection(){
		if(conn == null){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(url);
				System.out.println("db연결성공");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("드라이버로딩 실패");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("DB연결 실패");
			}
			
		}
		return conn;
	}

}
