package co.kr.jaejoo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
	
	// singleton으로 연결을 하기위한 설정을합니다. 
	private Connection conn = null;
	
	// 이 클래스를 instance합니다.
	private static SingletonConnection sc = new SingletonConnection();
	
	// 연결할 db의 정보를 입력합니다.
	String url = "jdbc:mysql://jsptest.cpkkponxntb7.ap-northeast-2.rds.amazonaws.com:3306/pcproject"; // 뒤의 3306은 생략이 가능하나 써주는것이 좋습니다.
	String driver = "com.mysql.jdbc.Driver";
	String user = "test";
	String password = "test1234";
	
	private SingletonConnection(){} // 기본생성자
	
	public static SingletonConnection getInstance(){
		// 위에서 singletonConnection클래스를 instance화 하지않고도 다른 방법으로 연결이 가능하다.
		return sc;
	}
	
	public Connection getConnection(){
		if(conn == null){
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("드라이버 로딩실패");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("DB연결 실패");
			}
			
		}
		return conn;
	}
	// singleton은 하나의 객체만  생성하기 때문에 자원의 낭비를 막을 수 있는 패턴중에 하나입니다. 사용자가원하는 자원을 하나만 생성하며 다 사용하고난 후에는 자원을 반납합니다.
}
