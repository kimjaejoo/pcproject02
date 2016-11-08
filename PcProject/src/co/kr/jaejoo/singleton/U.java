package co.kr.jaejoo.singleton;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class U {
	private static U self;

	public U() {
	}

	public static U getInstance() {
		if (self == null) {
			self = new U();
		}
		return self;
	}
	
	public Connection getConnection(){
		Context iniCtx;
		
		try {
			iniCtx = new InitialContext();
			Context envCtx = (Context)iniCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)envCtx.lookup("jdbc/java");
			System.out.println("DB연결 성공");
			return ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void returnConnection(Connection conn){
		if(conn == null)return;
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
