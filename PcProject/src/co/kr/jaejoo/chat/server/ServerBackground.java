package co.kr.jaejoo.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import co.kr.jaejoo.asset.Setting;
import co.kr.jaejoo.pcClient.MainProcess;
import co.kr.jaejoo.pcClient.SystemMainClient;

public class ServerBackground {

	// 지금까지 한일. GUi연동시키면서 서버Gui에 메시지띄움.
	// 다음 이슈. Gui 상에서 일단 1:1 채팅을 하고 싶다.
	private ServerSocket serverSocket = null;
	private Socket socket;
	private String msg;

	private ServerGui gui;
	public SystemMainClient mainClient;
	public static MainProcess mainProcess;

	/** XXX 03. 세번째 중요한것. 사용자들의 정보를 저장하는 맵입니다. */
	private Map<String, DataOutputStream> clientsMap = new HashMap<String, DataOutputStream>();

	// list , map , set
	/**
	 * list : 순서가 있는 데이터의 집합, 데이터의 중복을 허용한다. set : 순서를 유지하지 않는 데이터의 집합, 데이터의 중복을
	 * 허용하지 않는다. map : key와 value의 쌍으로 이루어진 데이터의 집합 순서는 유지되지않고 , 키는 중복을 허용하지
	 * 않으며, 값의 중복은 허용한다.
	 **/

	public void setting() throws IOException {
		Collections.synchronizedMap(clientsMap); // 이걸 교통정리 해줍니다^^
		serverSocket = new ServerSocket(7777);
		while (true) {
			/** XXX 01. 첫번째. 서버가 할일 분담. 계속 접속받는것. */
			System.out.println(getTime() + "연결요청을 기다립니다.");
			System.out.println("서버 대기중...");
			try {
			} catch (Exception e) {
				e.printStackTrace();
			}
			socket = serverSocket.accept(); // 먼저 서버가 할일은 계속 반복해서 사용자를 받는다.
			System.out.println(socket.getInetAddress() + "에서 접속했습니다.");
			// 여기서 새로운 사용자 쓰레드 클래스 생성해서 소켓정보를 넣어줘야겠죠?!
			Receiver receiver = new Receiver(socket);
			receiver.start();
		}
	}

	/*
	 * public static void main(String[] args) throws IOException {
	 * ServerBackground serverBackground = new ServerBackground();
	 * serverBackground.setting(); }
	 */

	public String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}

	// 맵의내용(클라이언트) 저장과 삭제
	public void addClient(String nick, DataOutputStream out) throws IOException {
		// String ip = InetAddress.getLocalHost().getHostAddress();
		sendMessage(nick + "님이 접속하셨습니다.");
		clientsMap.put(nick, out);
	}

	public void removeClient(String nick) {
		sendMessage(nick + "님이 나가셨습니다.");
		clientsMap.remove(nick);
	}

	// 메시지 내용 전파
	public void sendMessage(String msg) {
		Iterator<String> it = clientsMap.keySet().iterator();
		String key = "";
		while (it.hasNext()) {
			key = it.next();
			try {
				clientsMap.get(key).writeUTF(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// -----------------------------------------------------------------------------
	class Receiver extends Thread {
		private DataInputStream in;
		private DataOutputStream out;
		private String nick;

		/** XXX 2. 리시버가 한일은 자기 혼자서 네트워크 처리 계속..듣기.. 처리해주는 것. */
		public Receiver(Socket socket) throws IOException {
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			nick = in.readUTF();

			// 사용자의 닉네임과 playerNo를 뿌려준다.
			addClient(nick, out);
		}

		public void run() {
			try {// 계속 듣기만!!
				while (in != null) {
					msg = in.readUTF();
					sendMessage(msg);
					gui.appendMsg(msg);
				}
			} catch (IOException e) {
				// 사용접속종료시 여기서 에러 발생. 그럼나간거에요.. 여기서 리무브 클라이언트 처리 해줍니다.
				removeClient(nick);
			}
		}
	}

	// 서버와 gui를 연결하기 위해서 사용합니다.
	public final void setGui(ServerGui gui) {
		this.gui = gui;
	}

	public final void setSystemMainClient(SystemMainClient mainClient) throws Exception {
	
		this.mainClient = mainClient;
		
	}

	@SuppressWarnings("static-access")
	public final void setMainProcess(MainProcess mainProcess) throws Exception {
		mainClient.setRectangles(SystemMainClient.class, mainClient, Setting.class, Setting.getInstance());
		this.mainProcess = mainProcess;
	}
}
