package Main;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Character {
	int x,y;
	BufferedImage image;
	BufferedImage image1, image2, image3, image4;
	int stepTimer = 0;
	int fresh = GamePanel.FRESH;
	boolean jumpState = false;
	int jumpHeight = 100;
	final int LOWEST_Y = 210;
	int jumpValue = 0;
	public Character() {
		try {
			image1= ImageIO.read(new File("src/picture/miorun/mio_run-00000.png"));
			image2 = ImageIO.read(new File("src/picture/miorun/mio_run-00001.png"));
			image3 = ImageIO.read(new File("src/picture/miorun/mio_run-00002.png"));
			image4 = ImageIO.read(new File("src/picture/miorun/mio_run-00003.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		x=50;
		y= LOWEST_Y;
		
	}
	public void move() {
		step();
		if(jumpState) {
			if(y>=LOWEST_Y) {
				System.out.println(1);
				jumpValue = -7;
				
			}
			if(y<=LOWEST_Y - jumpHeight) {
				System.out.println(2);
				jumpValue = 7;
				
			}
			y+= jumpValue;
			if(y>=LOWEST_Y) {
				jumpState = false;
				
			}
		}
	}
	void step() {
		int  tmp = (stepTimer/100) %4;
		switch(tmp) {
		case 0:image = image1;break;
		case 1:image = image2;break;
		case 2:image = image3;break;
		default:image = image4;break;
		}
		stepTimer += fresh;
	}
	public void jump() {
		jumpState = true;
	}
	public Rectangle getBodySize() {
		return new Rectangle(x+7,y,image.getWidth()-15,image.getHeight()-8);
	}
	
}
