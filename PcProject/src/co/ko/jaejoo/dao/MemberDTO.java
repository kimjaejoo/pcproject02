package co.ko.jaejoo.dao;

public class MemberDTO {
	
	
	private int membernum;
	private String name ;
	private String nickname;
	private String email;
	private String password;
	private String tel;
	private String joindata;
	private int admin;
	private String totaltime;
	
	public MemberDTO() {
		System.out.println("기본생성자 호출");
	}

	public MemberDTO(int membernum, String name, String nickname, String email, String password, String tel,
			String joindata, int admin, String totaltime) {
		super();
		this.membernum = membernum;
		this.name = name;
		this.nickname = nickname;
		this.email = email;
		this.password = password;
		this.tel = tel;
		this.joindata = joindata;
		this.admin = admin;
		this.totaltime = totaltime;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getMembernum() {
		return membernum;
	}

	public void setMembernum(int membernum) {
		this.membernum = membernum;
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

	public String getJoindata() {
		return joindata;
	}

	public void setJoindata(String joindata) {
		this.joindata = joindata;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

	public String getTotaltime() {
		return totaltime;
	}

	public void setTotaltime(String totaltime) {
		this.totaltime = totaltime;
	}
	
	public Member setPlayerNo(Member playerNo){
		return playerNo ;
	}
	
	
	
		
}
