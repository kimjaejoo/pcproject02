package co.kr.jaejoo.pcClient;

public class MainProcess {

	// 로그인
	static UserLoginClient loginClient;
	// 회원가입
	static UserJoinClient joinClient;
	// main controller
	static UserMainClient mainClient;

	public static void main(String[] args) {
		MainProcess main = new MainProcess();
		main.loginClient = new UserLoginClient();
		main.loginClient.setMain(main);

	}

	public void mainFrame() {
		loginClient.dispose();
		System.out.println("로그인성공");
		this.mainClient = new UserMainClient();
	}

	public void joinFrame() {
		loginClient.dispose();
		System.out.println("회원가입");
		this.joinClient = new UserJoinClient();
	}
	
	
	public static void loginFrame(){
		System.out.println("로그인 화면으로 되돌아갑니다.");
		joinClient.dispose();
		main(null);
		
		//System.out.println(this);
		// 무엇을 해야하는지 모르겟다.....
		// join창을 닫으면 nullpoint가 뜨는데....
	}
}


