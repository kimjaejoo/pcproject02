package co.kr.jaejoo.pcClient;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class SeatGui extends JFrame{

	public SeatGui() {
		setTitle("사용자를 컨트롤하는 화면입니다.");
		setSize(1600, 900);
		
		Dimension framesize = this.getSize();
		Dimension windowsize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowsize.width - framesize.width) / 2, (windowsize.height - framesize.height) / 2);
		
		
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	// 좌석의 이미지를 넣기 위한 innerclass를 작성합니다.
	class MyPanel extends JFrame {
		Image image;
		
		public MyPanel() {
			image = Toolkit.getDefaultToolkit().createImage("");
		}
		
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(image, 99, 99, this);
		}
	}
	
}
