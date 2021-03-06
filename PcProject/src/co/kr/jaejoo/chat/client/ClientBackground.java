package co.kr.jaejoo.chat.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import co.kr.jaejoo.pcClient.SystemMainClient;
import co.kr.jaejoo.pcClient.UserLoginClient;
import co.kr.jaejoo.pcClient.UserMainClient;

@SuppressWarnings("unused")
public class ClientBackground {

	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	private String msg;
	private String nickName;

	private ClientGui gui;
	private UserLoginClient userLoginClient;
	private UserMainClient userClient;
	private SystemMainClient systemClient;
	
	public void connet() {
		try {
			String ip = InetAddress.getLocalHost().getHostAddress();
			socket = new Socket(ip, 7777);

			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			out.writeUTF("hi");

			System.out.println("클라이언트 : 메시지 전송완료");
			while (in != null) {
				msg = in.readUTF();
				gui.appendMsg(msg);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ClientBackground clientBackground = new ClientBackground();
		clientBackground.connet();
	}

	public void sendMessage(String msg2) {
		try {
			out.writeUTF(msg2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

	public void setNickname(String nickName) {
		this.nickName = nickName;
	}

	public final void setGui(UserLoginClient userLoginClient) {
		this.userLoginClient = userLoginClient;
	}

	public final void setGui(ClientGui gui) {
		this.gui = gui;
	}

	public final void setGui(UserMainClient userClient) {
		this.userClient = userClient;
	}
	
	public final void setUserClient(UserMainClient userClient) {
		this.userClient = userClient;
	}

	public final void setSystemClient(SystemMainClient systemClient) {
		this.systemClient = systemClient;
	}

	
	

	
	
}
