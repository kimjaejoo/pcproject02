package co.kr.jaejoo.pcClient;


import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.accessibility.AccessibleAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class UserJoinClient extends JFrame implements ActionListener {

	CardLayout lay;
	JOptionPane pane;
	
	private MainProcess main = new MainProcess();
	
	private Pattern patternEmail, patternId, patternTel;
	private Matcher matcherEmail, matcherId, matcherTel;

	// 회원가입
	private JTextField joinEmail, joinTel, joinName;
	private JLabel email, tel, name, password;
	private JPasswordField joinPw;
	private JButton joinjoinBtn, cancleBtn;

	// 이메일, 전화번호를 사용하기위한 정규표현식
	private String emailregex = "[0-9a-zA-Z]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
	private String telregex = "^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$";

	
	public UserJoinClient() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("사용자 회원가입 화면입니다");
		setLayout(null);
		
		setSize(600, 900);

		Dimension framesize = this.getSize();
		Dimension windowsize = Toolkit.getDefaultToolkit().getScreenSize();
		
		int width = (windowsize.width - framesize.width) / 2;
		int height = (windowsize.height - framesize.height) / 2;
		
		setLocation(width, height);

		joinEmail = new JTextField();
		joinTel = new JTextField();
		joinName = new JTextField();
		joinPw = new JPasswordField();
		email = new JLabel("이메일");
		tel = new JLabel("전화번호");
		name = new JLabel("이름");
		password = new JLabel("비밀번호");
		joinjoinBtn = new JButton("SIGNUP");
		cancleBtn = new JButton("CANCLE");

		joinEmail.setBounds(250, 200, 200, 30);
		joinPw.setBounds(250, 200+80, 200, 30);
		joinName.setBounds(250, 200+80+80, 200, 30);
		joinTel.setBounds(250, 200+80+80+80, 200, 30);
		
		email.setBounds(150, 200, 200, 30);
		password.setBounds(150, 200+80, 200, 30);
		name.setBounds(150, 200+80+80, 200, 30);
		tel.setBounds(150, 200+80+80+80, 200, 30);
		
		joinjoinBtn.setBounds(135, 600, 130, 30);
		cancleBtn.setBounds(150+165, 600, 130, 30);
		
		add(joinEmail);
		add(joinPw);
		add(joinName);
		add(joinTel);
		add(email);
		add(tel);
		add(name);
		add(password);
		add(joinjoinBtn);
		add(cancleBtn);

		joinjoinBtn.addActionListener(this);
		cancleBtn.addActionListener(this);
		
		setVisible(true);
	}


	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		if(obj == joinjoinBtn){
			System.out.println("회원가입을 시도합니다");
			// 회원가입은 정규식을 따릅니다.

			String email = joinEmail.getText();
			String password = joinPw.getText();
			String name = joinName.getText();
			String tel = joinTel.getText();
			
			patternEmail = Pattern.compile(emailregex);
			patternTel = Pattern.compile(telregex);
			matcherEmail = patternEmail.matcher(email);
			matcherTel = patternTel.matcher(tel);
			System.out.println(matcherEmail.matches());
			System.out.println(matcherTel.matches());

			
			
			try {
				main.loginFrame(this);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(obj == cancleBtn){
			System.out.println("회원가입을 취소합니다");
			try {
				main.loginFrame(this);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	
	
}
