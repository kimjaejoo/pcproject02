package co.kr.jaejoo.model;

public class ResSignUp {
	int membernum, code;
	String msg;
	UserDao data;
	
	public int getMembernum() {
		return membernum;
	}
	public void setMembernum(int membernum) {
		this.membernum = membernum;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public UserDao getData() {
		return data;
	}
	public void setData(UserDao data) {
		this.data = data;
	}
	
	
	
}
