package wantHome;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class GameMain extends JFrame {
	
	public GameMain() {

		Container container = this.getContentPane();
		container.setLayout(null);

		GameStart gs = new GameStart();
		
		gs.setBounds(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		container.add(gs);
		
		
		gs.setFocusable(true);
		this.setBounds(0,0,Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT+35);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}	
}
