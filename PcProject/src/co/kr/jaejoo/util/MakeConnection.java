package co.kr.jaejoo.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MakeConnection {

	// singleton을 사용하기 위한 클래스 입니다. 
	// singleton이란 사용자가 원하는 자원을 하나만 생성하여 사용하는 것을 말합니다. DB연결과 리플렉션을 이용한 setting에서 사용되어집니다.
	
	// 먼제 이 클래스르 선언하고  아래에 유저가 원하는 데이터의 정보를 입력합니다.
	private static MakeConnection mc = new MakeConnection();

	String url = "jdbc:mysql://jsptest.cpkkponxntb7.ap-northeast-2.rds.amazonaws.com:3306/pcproject"; // 뒤의 3306은 생략이 가능하나 써주는것이 좋습니다.
	String driver = "com.mysql.jdbc.Driver";
	String user = "test";
	String password = "test1234";
	String dbName = "pcproject";
	
	private Connection connection; // db에 연결하기 위한 connection 객체를 선언합니다.
	
	public MakeConnection() {
		System.out.println("singleton 연결시도");
	}

	// makeconnection의 객페를 instance 할때 값이 없으면 이 클래스를 반환아여 줍니다.
	public static MakeConnection getInstance() {
		if(mc == null){
			mc = new MakeConnection();
		}
		return mc;
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
	
	
	public static void main(String[] args) {
		MakeConnection mc = MakeConnection.getInstance();
	}
	
 
}
