package _03_polymorphs;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class MovingMorph extends Polymorph {
Random randy = new Random();
	MovingMorph(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.gray);
		g.fillRect(getX(), getY(), getWidth(), getHeight());
	}
	
	public void update() {
		int changeX = randy.nextInt(20)-10;
		int changeY = randy.nextInt(20)-10;
		setX(changeX+getX());
		setY(changeY+getY());
		if(getX()<0) {
			setX(0);
		}
		if(getX()>500-getWidth()) {
			setX(500-getWidth());
		}
		if(getY()<0) {
			setX(0);
		}
		if(getY()>500-getHeight()) {
			setX(500-getHeight());
		}
	}

}
