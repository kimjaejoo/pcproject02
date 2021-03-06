package co.kr.jaejoo.pcClient;

import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import co.ko.jaejoo.dao.Member;
import co.ko.jaejoo.dao.MemberDTO;
import co.kr.jaejoo.asset.Setting;
import co.kr.jaejoo.chat.client.ClientBackground;
import co.kr.jaejoo.panel.PanSeat;
import co.kr.jaejoo.panel.userMain;

@SuppressWarnings("serial")
public class UserMainClient extends JFrame {
	// 사용자가 로그인을하고 userFrame을 띄우면 서버에 접속합니다. client가 되어지는 부분이다.
	
	private Member member = new Member();
	private MemberDTO dto;
	
	private MainProcess main;

	public void setMain(MainProcess main) {
		this.main = main;
	}

	private ClientBackground client = new ClientBackground();
	
	int playerNo;

	public JLayeredPane userLayeredPane = new JLayeredPane();

	// 사용자의 정보를 나타내는 곳을 정합니다.
	//private JButton chatOn;
	private userMain userMain;
	private SystemMainClient systemMainClient;
	// 로그인시 사용자의 값을 받아와야합니다.
	private PanSeat panSeat;
	
	
	
	public UserMainClient(int playerNo) throws Exception {
		this.playerNo = playerNo;
		// mainProcess 에서 받아온 값입니다.
		userMain = new userMain(playerNo);
		
		//systemMainClient = new SystemMainClient(playerNo);
		// 사용자가 넘긴 값을 이용하여 dao에 접근합니다.
		System.out.println("userFrame으로 넘겨받은 사용자번호  " + playerNo);
		dto = member.selectOne(playerNo);
		
		// 기본적인 ui를 setting 합니다.
		//System.out.println("사용자 ui가 호출됩니다.");
		setTitle("사용자UI");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);
		setSize(Setting.cDimen);
		setLocation(Setting.userLocationX, Setting.userLocationY);
		
		add(setJLayered(userMain));
		add(userLayeredPane);
		
	}

	// 리플렉션을 이용한 Setting 클래스의 정보를 불러오기위해서 사용합니다.
	private JComponent setJLayered(Component... components) {
		int i = 0;
		for (Component component : components)
			userLayeredPane.add(component, new Integer(i++));
		return userLayeredPane;
	}

	// Setting Class의 변수들을 사용하기 위하여 작성합니다.
	// Reflection Practice 다른 클래스의 정보를 가지고 와서 사용한다. 변수의 이름을 같게하면 된다
	public void setRectangles(Class<?> clazz, Object instance, Class<?> targetClass, Object target) throws Exception {
		Object tempObject = null;
		for (Field field : clazz.getDeclaredFields()) {
			if ((tempObject = field.get(instance)) instanceof JComponent) {
				((JComponent) tempObject)
						.setBounds((Rectangle) targetClass.getDeclaredField(field.getName()).get(target));
				((JComponent) tempObject).setOpaque(false);
				((JComponent) tempObject).setLayout(null);
			}
			if (tempObject instanceof Runnable)
				new Thread((Runnable) tempObject).start();
		}
	}
}
