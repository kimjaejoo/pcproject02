package co.kr.jaejoo.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import co.ko.jaejoo.dao.MemberDTO;

@SuppressWarnings("serial")
public class PanSeat extends JPanel {

	// 좌석을 정보를 가지고있는 클래스입니다. 사용자가 로그인하면 어느 하나가 이름이 버뀐다...
	// 접속정보를 가지고 있어야하는 메소드이다....
	// 사용자의 접속정보를 배열에 넣어 저장한다. 총 50명의 user의 정보를 저장일 가능하다
	
	
	private BufferedImage image = null;
	private int numSeat;
	JLabel[] label = new JLabel[4];
	
	ArrayList<Integer> list = new ArrayList<Integer>();
	
	private MemberDTO dto;

	public PanSeat(int numSeat) {
		this.numSeat = numSeat;
		
		//System.out.println(dto.getMembernum());
		
		// 사용자 좌석 50개의 정보를 가지고 와서 메모리안에 저장합니다
		for(Integer i : list){
			list.add(i);
			System.out.println("사용자의 번호"+i);
		}
		
		
		
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		image("gameOff");
		setLayout(null);

		JPanel panImg = new InnerPanel();
		panImg.setBounds(0, 0, 99, 99);
		panImg.setOpaque(false);
		
		// 상태정보패널
		JPanel panContent = new JPanel();
		panContent.setLayout(null);
		panContent.setBounds(0, 0, 99, 99);
		int posLabel = 15;
		// 한 좌석에는 user의 상태를 알 수 있는 label이 총 4개 존재합니다. 
		for(int i = 0 ; i < 4 ; i++){
			if(i == 0){
				label[i] = new JLabel((numSeat + 1) + ".빈자리"); // 50개의 배열이 0 부터 시작하기 때문에 
			}else{
				label[i] = new JLabel("");
			}
			
			label[i].setBounds(20, posLabel, 80, 15);
			posLabel += 16;
			label[i].setForeground(new Color(36, 205, 198));
			label[i].setFont(new Font("고딕", 1, 12));
			panContent.add(label[i]);
		}
		
		panContent.setOpaque(false);
		
		JLayeredPane panLayered = new JLayeredPane();
        panLayered.setBounds(0, 0, 1600, 900);
        panLayered.setLayout(null);
        panLayered.setOpaque(false);
        panLayered.add(panImg, new Integer(0), 0);
        panLayered.add(panContent, new Integer(1), 0);
        add(panLayered);

		add(panImg);
		setVisible(true);
		setOpaque(false);
		setFocusable(true);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("좌석");
		frame.add(new PanSeat(1));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(99, 144);
		frame.setVisible(true);
	}

	class InnerPanel extends JPanel {
		private static final long serialVersionUID = 1547128190348749556L;

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(image, 0, 0, null);
		}
	}

	private void image(String fileName) {
		try {
			image = ImageIO.read(new File("img/" + fileName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("이미지 불러오기 실패");
			System.exit(0);
		}
		repaint();
	}

}
