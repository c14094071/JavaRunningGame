package Main;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Skill extends Rectangle {
	int x,y;
	BufferedImage skill_img;
	BufferedImage skill_img1,skill_img2,skill_img3,skill_img4,skill_img5;
	int fresh = GamePanel.FRESH;
	final int LOWEST_X=50;
	int stepTimer = 0;
	final int LOWEST_Y = 150;
	int jumpValue = 0;
	boolean jumpState = false;
	int jumpHeight = 100;
	public Skill(){
		try {
			skill_img1 = ImageIO.read(new File("src/picture/water_01/Water__01.png"));
			skill_img2 = ImageIO.read(new File("src/picture/water_01/Water__02.png"));
			skill_img3 = ImageIO.read(new File("src/picture/water_01/Water__03.png"));
			skill_img4 = ImageIO.read(new File("src/picture/water_01/Water__04.png"));
			skill_img5 = ImageIO.read(new File("src/picture/water_01/Water__05.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		x=100;
		y= LOWEST_Y;
	    }
	
	public void move() {
		step();
		if(jumpState) {
			if(y>=-160) {
				System.out.println(1);
				jumpValue = -7;
				y+= jumpValue;	
			}
		
			
		}
		if(jumpState) {
			if(y>=-160) {
				System.out.println(1);
				jumpValue = -7;
				y+= jumpValue;	
			}
		
		}
		
		
	}
	void step() {
		int  tmp = (stepTimer/100) %5;
		switch(tmp) {
		case 0:skill_img = skill_img1;break;
		case 1:skill_img = skill_img2;break;
		case 2:skill_img = skill_img3;break;
		case 3:skill_img = skill_img4;break;
		default:skill_img = skill_img5;break;
		}
		stepTimer += fresh;
	}
	public void jump() {
		jumpState = true;
	}
	public Rectangle getSkillSize() {
		return new Rectangle(x+7,y+40,skill_img.getWidth()-50,skill_img.getHeight()-80);
	}
		
		
		
		
	

}
