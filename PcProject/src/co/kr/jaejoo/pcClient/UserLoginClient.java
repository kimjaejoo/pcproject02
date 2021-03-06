package co.kr.jaejoo.pcClient;

import java.awt.Component;
import java.awt.Rectangle;

import java.lang.reflect.Field;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import co.kr.jaejoo.asset.Setting;
import co.kr.jaejoo.panel.MyStarPanel;
import co.kr.jaejoo.panel.PanImgload;
import co.kr.jaejoo.panel.loginClient;

import co.kr.jaejoo.panel.*;

@SuppressWarnings({ "serial", "unused"})
public class UserLoginClient extends JFrame {

	public JLayeredPane layeredPane = new JLayeredPane();
	private PanImgload backGround = new PanImgload("img/mainHud_back.png");
	private MyStarPanel myStarPanel = new MyStarPanel();
	private loginClient loginClient = new loginClient();

	private MainProcess main;
	private loginClient login;

	public UserLoginClient() {

		// 사용장 로그인화면 만들기 - 사용자의 화면에 맟줘 적당한 크기로 중앙에 들어오게 한다.
		setLayout(null);
		setTitle("사용자 로그인 화면 입니다.");

		setSize(Setting.bDimen); // 창의 기본적인 크기를 설정합니다

		setLocation(Setting.locationX, Setting.locationY);

		add(setJLayered(backGround, loginClient, myStarPanel));
		add(layeredPane);

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 사용자가 x버튼을 눌렀을때 종료를 도와줍니다.

	}

	private JComponent setJLayered(Component... components) {
		int i = 0;
		for (Component component : components)
			layeredPane.add(component, new Integer(i++));
		return layeredPane;
	}

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

	public void setMain(MainProcess main) {
		this.main = main;
	}

	public void setMain(loginClient login) {
		this.login = login;
	}

	// 로그인을 시도할때 성공을 하면 server가 로그인한 사용자의 번호를 systemMain과 userMain으로 보냅니다.

}
