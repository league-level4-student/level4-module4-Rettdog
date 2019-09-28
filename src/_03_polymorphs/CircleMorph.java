package _03_polymorphs;

import java.awt.Color;
import java.awt.Graphics;

public class CircleMorph extends Polymorph{
int counter = 0;
	CircleMorph(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.PINK);
		g.fillRect(getX(), getY(), getWidth(), getHeight());
		
	}
	public void update() {
		setX((int) (250*Math.cos(counter/4)+225));
		setY((int) (250*Math.sin(counter/4)+225));
		counter++;
	}

}
