package test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import co.kr.jaejoo.pcClient.UserLoginClient;

public class PCserverBackground {

	// 소켓을 열어줌으로 통신이 가능하게 만들어준다..
	private ServerSocket serverSocket;
	private Socket socket;
	// 메세지를 주고 받는다.
	// 소켓끼리 주고 받고하는 것을 설정한다.
	//
	private DataInputStream in;
	private DataOutputStream out;
	private PcServerGui gui;
	// 사용자의 정보를 보내기위해 login창이 띄어지는 순간 server가 활성화 됩니다.
	private UserLoginClient loginClient;

	public void setting() {

		try {
			serverSocket = new ServerSocket(7777); // port 7777 외부포트 설정
			System.out.println("서버 대기중");
			socket = serverSocket.accept(); // 클라이언트가 접속하기 전까지 대기한다.
			System.out.println(socket.getInetAddress() + "에게 접속했습니다.");
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			String msg = in.readUTF();
			System.out.println("클라이언트로부터 받은 메세지 : " + msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		PCserverBackground pCserverBackground = new PCserverBackground();
		pCserverBackground.setting();

	}

	public void setGui(PcServerGui gui) {
		this.gui = gui;
		System.out.println("서버를 작동합니다.");
	}

	public void setGui(UserLoginClient loginClient) {
		this.loginClient = loginClient;
		System.out.println("서버를 작동합니다.");
	}

}
