package co.ko.jaejoo.dao;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;

import com.google.gson.Gson;

import co.kr.jaejoo.model.ReqSignUp;
import co.kr.jaejoo.model.ResSignUp;
import co.kr.jaejoo.model.UserDao;
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

	public void insert() {

		// json을 사용하기 위함
		String json = sb.toString();
		Gson gson = new Gson();
		ReqSignUp signUp = gson.fromJson(json, ReqSignUp.class);

		String sql = "INSERT INTO member (`name`,`email`,`password`,`tel`,`joindate`) "
				   + "VALUES (?,?,?,?,now()) ; ";

		int nRtn = 0;

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, signUp.getBody().getName());
			pstmt.setString(2, signUp.getBody().getEmail());
			pstmt.setString(3, signUp.getBody().getPassword());
			pstmt.setString(4, signUp.getBody().getTel());

			pstmt.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ResSignUp res = new ResSignUp();
		if (nRtn > 0) {
			res.setCode(1);
			res.setMsg("회원가입이 완료되었습니다");
		} else {
			res.setCode(-1);
			res.setMsg("회원가입을 실패했습니다");
		}

		UserDao user = new UserDao();
		user.setName(signUp.getBody().getName());
		user.setEmail(signUp.getBody().getEmail());
		user.setPassword(signUp.getBody().getPassword());
		user.setTel(signUp.getBody().getTel());
		res.setData(user);
	}

	// 로그인에 필요한 selectOne
	
}
