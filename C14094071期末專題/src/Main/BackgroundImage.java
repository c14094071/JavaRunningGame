package Main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackgroundImage {
	BufferedImage image;
	BufferedImage image1, image2;
	Graphics2D g2;
	int x1, x2;
	static int SPEED = 7;
	public BackgroundImage() {
		try {
			image1 = ImageIO.read(new File("src/picture/darknight.png"));
			image2 = ImageIO.read(new File("src/picture/darknight.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		image = new BufferedImage(800,300,BufferedImage.TYPE_3BYTE_BGR);
		g2 = image.createGraphics();
		x1 = 0;
		x2 = 800;
		g2.drawImage(image1, x1, 0, null);
		g2.drawImage(image2, x2, 0, null);
	}
	public void roll() {
		x1 -= SPEED;
		x2 -= SPEED;
		if(x1<= -800) {
			x1 = 800;
		}
		if(x2<= -800) {
			x2 = 800;
		}
		g2.drawImage(image1, x1, 0, null);
		g2.drawImage(image2, x2, 0, null);
	}
	
}
