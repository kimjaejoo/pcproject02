package co.ko.jaejoo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import co.kr.jaejoo.singleton.MakeConnection;

public class MemberDao {
	
	Connection conn;
	ResultSet rs;
	PreparedStatement pstmt;
	StringBuffer sb = new StringBuffer();
	
	public MemberDao() {
		conn = MakeConnection.getInstance().getConnection();
	}
	
	// 회원가입에 필요한 dataInsert
	// 회원가입 정보는 json data로 전송됨
	
	
	
	// 로그인에 필요한 selectOne
	
}
