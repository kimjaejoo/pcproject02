package co.kr.jaejoo.pcClient;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class SystemMainClient extends JFrame {

	public SystemMainClient() {
		setTitle("사용자를 컨트롤하는 화면입니다.");
		setSize(1600, 900);
		Dimension framesize = this.getSize();
		Dimension windowsize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowsize.width - framesize.width) / 2, (windowsize.height - framesize.height) / 2);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
