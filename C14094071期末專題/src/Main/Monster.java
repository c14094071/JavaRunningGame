package Main;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;



public class Monster extends Rectangle{
	int x,y;
	BufferedImage image;
	BufferedImage monster1,monster2,monster3;
	
	int speed;
	public Monster() {
		
		try {
			monster1 = ImageIO.read(new File("src/picture/monster1/standing111.png"));
			monster2 = ImageIO.read(new File("src/picture/monster2/idle111.png"));
			monster3 = ImageIO.read(new File("src/picture/monster3/idle-animation111.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Random r = new Random();
		int temp = r.nextInt(3);
		if(temp == 0) {
			image = monster1;
		}
		else if(temp ==1) {
			image = monster2;
		}
		else {
			image = monster3;
		}
		speed = BackgroundImage.SPEED;
		x = 800;
		y = 230;
	}
	public void move() {
		x -=speed;
	}
	public Rectangle getMonsterSize() {
		return new Rectangle(x,y,image.getWidth(),image.getHeight());
	}

}
