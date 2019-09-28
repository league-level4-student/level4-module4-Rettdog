package _03_polymorphs;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageMorph extends Polymorph{
	Image image;
	private boolean needImage = true;
	private boolean gotImage = false;
	
	ImageMorph(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		
		if (needImage) {
		    loadImage ("Question.jpg");
		}
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		if (gotImage) {
			g.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
		} 
		
	}
	
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	        image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            System.out.println("missed");
	        }
	        needImage = false;
	    }
	}

}
