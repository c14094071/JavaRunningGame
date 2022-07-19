package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener{
	BufferedImage image;
	Graphics2D g2;
	Character witch;
	Skill sk;
	Music mu = new Music("src/picture/wav/Voices - Patrick Patrikios (online-audio-converter.com).wav");
	static boolean finish = false;
	final static int FRESH = 20;////refresh time
	BackgroundImage background;
	boolean skill_work = false;

	List<Monster> list = new ArrayList<>();
	int addMonsterTimer = 0;
	Monster tmp = new Monster();
	public GamePanel() {
		image = new BufferedImage(800,300,BufferedImage.TYPE_3BYTE_BGR);
		g2 = image.createGraphics();
		witch = new Character();
		sk = new Skill();
		background = new BackgroundImage();
		list.add(new Monster());
		Activity a = new Activity(this);
		a.start();
	}
	private void paintImage() {
		sk.move();
		witch.move();
		background.roll();
		
		g2.drawImage(background.image, 0, 0, this);  // draw background
		
		Rectangle rec = witch.getBodySize();
		Rectangle rec1 = sk.getSkillSize();
	
		if(skill_work == true) {
			
			g2.drawImage(sk.skill_img, sk.x, sk.y ,this);
		}
		
		
		
		g2.drawImage(witch.image, witch.x, witch.y ,this); // draw witch
		
		if(addMonsterTimer >= 700) {
			Random r =new Random();
			if(r.nextInt(100)>90) {
				list.add(new Monster());
				addMonsterTimer = 0;
			}
			
		}
		
		
		for(int i =0;i<list.size();i++) {
			Monster mo = list.get(i);
			mo.move();
			rec = mo.getMonsterSize();
			
			g2.drawImage(mo.image, mo.x, mo.y, this); //draw monsters
			if(mo.getMonsterSize().intersects(witch.getBodySize())) {
				finish = true;
				mu.stop_music();
				JOptionPane.showMessageDialog(null,"Game Over!!");
				
			}
			if(mo.getMonsterSize().intersects(sk.getSkillSize()) && skill_work ==true) {
				finish = true;
				mu.stop_music();
				JOptionPane.showMessageDialog(null,"Game Over!!");
			}
			
		}
		addMonsterTimer += FRESH;
	

		
	}
	public void paint(Graphics g) {
		paintImage();
		g.drawImage(image, 0, 0, this);
	}
	
	public boolean isFinish() {
		return finish;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			witch.jump();
		}
		
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			skill_work = true;
			BackgroundImage.SPEED = 14;
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			skill_work = false;
			BackgroundImage.SPEED = 7;
		}
	}
	


}
