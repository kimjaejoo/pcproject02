package co.kr.jaejoo.pcClient;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class UserJoinClient extends JFrame {

	public static void main(String[] args) {
		new UserJoinClient();
	}
	
	JPanel join;

	Pattern patternEmail, patternId, patternTel;
	Matcher matcherEmail, matcherId, matcherTel;

	// 회원가입
	JTextField joinEmail, joinTel, joinName;
	JLabel email, tel, name, password;
	JPasswordField joinPw;

	// 프레임설정
	

	public UserJoinClient() {
		
		setSize(600, 900);
		Dimension framesize = this.getSize();
		Dimension windowsize = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println(framesize);
		System.out.println(windowsize);
		int width = (windowsize.width - framesize.width) / 2;
		int height = (windowsize.height - framesize.height) / 2;

		join = new JPanel();
		joinEmail = new JTextField();
		joinTel = new JTextField();
		joinName = new JTextField();
		joinPw = new JPasswordField();
		email = new JLabel("이메일");
		tel = new JLabel("전화번호");
		name = new JLabel("이름");
		password = new JLabel("비밀번호");

		setTitle("사용자 회원가입 화면입니다");
		setLayout(null);
		join.setLayout(null);

		
		joinEmail.setBounds(100, 500, 100, 30);
		
		join.add(joinEmail);
		add(join, "join");
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
