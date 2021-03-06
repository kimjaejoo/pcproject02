package co.ko.jaejoo.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.ArrayList;

import co.kr.jaejoo.util.MakeConnection;
import co.kr.jaejoo.util.U;

public class Member {

	private Connection conn;

	private PreparedStatement pstmt;

	private ResultSet rs;

	private StringBuffer sb = new StringBuffer();

	// 기본생성자에 싱글톤을 불러옴으로서 연결을 시도한다.
	public Member() {
		conn = U.getInstance().getConnection();
	}

	// 모든 정보를 불러오기위한 메서드

	public ArrayList<MemberDTO> selectAll() {

		// 리스트의 정보를 담기위해 Arraylist를 선언한다.

		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();

		// 앞에서 사용한 sql문을 초기화 한다.

		sb.setLength(0);

		sb.append(" SELECT `membernum`, `name`, `nickname`, `email`, `password`, `tel`, `joindata`, `admin`, `totaltime` ");

		sb.append(" FROM `pcproject`.`member` ");

		// 전체를 조회하기위해 결과값을 resultset에 넣어주고 그것을 list 안에 넣어주었다.

		try {

			pstmt = conn.prepareStatement(sb.toString());

			rs = pstmt.executeQuery();

			while (rs.next()) {

				int membernum = rs.getInt("membernum");

				String name = rs.getString("name");
				
				String nickname = rs.getString("nickname");

				String email = rs.getString("email");

				String password = rs.getString("password");

				String tel = rs.getString("tel");

				String joindata = rs.getString("joindata");

				int admin = rs.getInt("admin");

				String totaltime = rs.getString("totaltime");

				MemberDTO memberdto = new MemberDTO(membernum, name, nickname, email, password, tel, joindata, admin, totaltime);

				list.add(memberdto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 로그인을 위한 메서드
	// 이메일과 password로login을 시도할때 admin을 가지고 올수 있나??selectOne??? 아래의 쿼리문에서 admin을 추가했다.

	public ArrayList<MemberDTO> loginAll(String email, String password) {

		// 리스트의 정보를 담기위해 Arraylist를 선언한다.

		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();

		// 앞에서 사용한 sql문을 초기화 한다.

		sb.setLength(0);

		sb.append(" SELECT `membernum`, `name`, `nickname`, `email`, `password`, `tel`, `joindata`, `admin`, `totaltime` ");

		sb.append(" FROM `pcproject`.`member` ");

		sb.append(" WHERE email = ? and password = ? ");

		// 전체를 조회하기위해 결과값을 resultset에 넣어주고 그것을 list 안에 넣어주었다.

		try {

			pstmt = conn.prepareStatement(sb.toString());

			pstmt.setString(1, email);

			pstmt.setString(2, password);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				int membernum = rs.getInt("membernum");

				String name = rs.getString("name");
				
				String nickname = rs.getString("nickname");

				String tel = rs.getString("tel");

				String joindata = rs.getString("joindata");

				int admin = rs.getInt("admin");

				String totaltime = rs.getString("totaltime");

				MemberDTO memberdto = new MemberDTO(membernum, name, nickname, email, password, tel, joindata, admin, totaltime);

				list.add(memberdto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 전체의 정보중에 하나만 조회하기 위함으로 사용한다. return은 dto로한다.

	public MemberDTO selectOne(int membernum) {

		MemberDTO memberdto = null;

		sb.setLength(0);

		sb.append(" SELECT `membernum`, `nickname`, `name`, `email`, `password`, `tel`, `joindata`, `admin`, `totaltime` ");

		sb.append(" FROM `pcproject`.`member` ");

		sb.append(" WHERE membernum = ? ");

		try {

			pstmt = conn.prepareStatement(sb.toString());

			pstmt.setInt(1, membernum);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				String name = rs.getString("name");
				
				String nickname = rs.getString("nickname");

				String email = rs.getString("email");

				String password = rs.getString("password");

				String tel = rs.getString("tel");

				String joindata = rs.getString("joindata");

				int admin = rs.getInt("admin");

				String totaltime = rs.getString("totaltime");

				memberdto = new MemberDTO(membernum, name, nickname, email, password, tel, joindata, admin, totaltime);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberdto;
	}

	// login에대한 정보를 입력하는데 필요한 메서드를 만들어야한다.

	public MemberDTO loginData(String email, String password) {

		// 기본의 정보에 id와 password를 비교하여 로그인을 시도한다.

		MemberDTO memberdto = null;

		sb.setLength(0);

		sb.append(" SELECT `membernum`, `nickname`, `name`, `email`, `password`, `tel`, `joindata`, `admin`, `totaltime` ");

		sb.append(" FROM `pcproject`.`member` ");

		sb.append(" WHERE email = ? and password = ? ");
		
		try {

			pstmt = conn.prepareStatement(sb.toString());
	
			pstmt.setString(1, email);

			pstmt.setString(2, password);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				int membernum = rs.getInt("membernum");

				String name = rs.getString("name");
				
				String nickname = rs.getString("nickname");

				String tel = rs.getString("tel");

				String joindata = rs.getString("joindata");

				int admin = rs.getInt("admin");

				String totaltime = rs.getString("totaltime");

				memberdto = new MemberDTO(membernum, name, nickname, email, password, tel, joindata, admin, totaltime);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberdto;
	}

	public void insertOne(MemberDTO memberdto) {

		sb.setLength(0);

		sb.append("INSERT INTO `pcproject`.`member` (`name`, `nickname`, `email`, `password`, `tel`, `joindata`, `totaltime`) ");

		sb.append("VALUES (?, ? ,?, ?, ?, now(), null) ;");
		
		try {

			pstmt = conn.prepareStatement(sb.toString());

			pstmt.setString(1, memberdto.getName());
			pstmt.setString(2, memberdto.getNickname());
			pstmt.setString(3, memberdto.getEmail());
			pstmt.setString(4, memberdto.getPassword());
			pstmt.setString(5, memberdto.getTel());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 회원정보를 수정하는데 사용이 가능한 메서드

	public void updateOne(MemberDTO memberdto) {

		sb.setLength(0);

		sb.append(" UPDATE `pcproject`.`member`  ");

		sb.append(" SET `name`='?', `nickname` = ? , `email`='?', `password`='?', `tel`='?' ");

		sb.append(" WHERE `memberNum`=? ; ");

		 
		
		
		try {

			pstmt = conn.prepareStatement(sb.toString());

			pstmt.setString(1, memberdto.getName());
			
			pstmt.setString(2, memberdto.getNickname());

			pstmt.setString(3, memberdto.getEmail());

			pstmt.setString(4, memberdto.getPassword());

			pstmt.setString(5, memberdto.getTel());

			pstmt.setInt(6, memberdto.getMembernum());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 회원정보를 삭제하는 메서드
	public void deleteOne(int membernum) {

		sb.setLength(0);

		sb.append(" DELETE FROM `pcproject`.`member`  ");

		sb.append(" WHERE  `memberNum`=? ");
		
		try {

			pstmt = conn.prepareStatement(sb.toString());

			pstmt.setInt(1, membernum);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 사용한 자원을 닫아준다. 원래의 네트웤연결 방식과는 달리 한번만 닫아주면 된다.
	public void close() {
		try {
			if (conn != null)
				conn.close();
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}