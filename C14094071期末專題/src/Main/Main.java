package Main;

import java.awt.Container;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Main extends JFrame{
	GamePanel p;
	static int h=0;
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p = new GamePanel();
		Container c = getContentPane();
		c.add(p);
		
		addKeyListener(p);
	}
	
	public static void main(String[] args) {
		Main frame = new Main();
		frame.setBounds(340, 150, 800, 340);
		frame.setVisible(true);
		
		
	}

}
