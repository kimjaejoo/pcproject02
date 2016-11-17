package co.kr.jaejoo.pcClient;

public class MainProcess {

	// 로그인
	private static UserLoginClient loginClient;
	// 회원가입
	private static UserJoinClient joinClient;
	// main controller
	private static SystemMainClient mainClient;
	// UserUi
	private static UserMainClient userClient; 
	
	
	public static void main(String[] args) {
		MainProcess main = new MainProcess();
		main.loginClient = new UserLoginClient();
		main.loginClient.setMain(main);

	}

	// 되돌아가는 버튼을 활성화합니다.
	public static void loginFrame(){
		System.out.println("로그인 화면으로 되돌아갑니다.");
		joinClient.dispose();
		main(null);
	}

	public void mainFrame() {
		loginClient.dispose();
		System.out.println("로그인성공");
		this.mainClient = new SystemMainClient();
	}

	public void joinFrame() {
		loginClient.dispose();
		System.out.println("회원가입");
		this.joinClient = new UserJoinClient();
	}
	
	public void userFrame(){
		loginClient.dispose();
		System.out.println("사용자 권한으로 UserUI에 접속합니다");
		this.userClient = new UserMainClient();
	}

	
	
	
		
		
}


