package co.kr.jaejoo.model;

public class UserDao {
	int num;
	String name, email, password, tel, joindate;

	public UserDao() {

	}

	public UserDao(int num, String name, String email, String password, String tel, String joindate) {
		super();
		this.num = num;
		this.name = name;
		this.email = email;
		this.password = password;
		this.tel = tel;
		this.joindate = joindate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getJoindate() {
		return joindate;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}

}