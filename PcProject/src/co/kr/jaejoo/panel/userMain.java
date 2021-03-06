package co.kr.jaejoo.panel;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import co.kr.jaejoo.asset.Setting;
import co.kr.jaejoo.pcClient.UserMainClient;

@SuppressWarnings("serial")
public class userMain extends JPanel implements ActionListener{
	// 하나의 판넬....여기서 내가 추가할 내용들의 label, textfiled들을 설정한다? 그리고 한번에 용한다...?
	private JLabel playerSeatNo, playerName, playTime, playerCoin;
	private JButton chatOn;
	
	private int playerNo;
	
	public userMain(int playerNo) {
		//this.playerNo = playerNo;
		System.out.println("사용자 번호를 받아서 사용"+playerNo);
		// 사용자의 번호를 받아서 사용합니다.
		
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		setLayout(null);
		
		playerSeatNo = new JLabel("자리번호 : ");
		playerName = new JLabel("사용자 이름 : ");
		playerCoin = new JLabel("사용금액 : ");
		playTime = new JLabel("사용시간 : ");
		chatOn = new JButton("1:1 대화");
		
		setLable(playerSeatNo).setBounds(Setting.playerSeatNo);
		setLable(playerName).setBounds(Setting.playerName);
		setLable(playerCoin).setBounds(Setting.playerCoin);
		setLable(playTime).setBounds(Setting.playTime);
		setLable(chatOn).setBounds(Setting.chatOn);
		
		chatOn.addActionListener(this);
		
		add(playerSeatNo);
		add(playerName);
		add(playerCoin);
		add(playTime);
		add(chatOn);
		
	}
	private JComponent setLable(JComponent component){
		component.setForeground(Setting.bColor);
		component.setFont(Setting.bFont);
		return component;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		
		if(obj == chatOn){
			System.out.println("chtting을 시작합니다.");
		}
		
	}
	
}
