package _03_polymorphs;

import java.awt.Graphics;

public abstract class Polymorph {
    private int x;
    private int y;
    private int width = 50;
    private int height = 50;
    
    Polymorph(int x, int y){
   	 this.x = x;
   	 this.y = y;
    }
    
    public void update(){
   	 
    }
    
    public int getX() {
    	return x;
    }
    
    public int getY() {
    	return y;
    }
    
    public void setX(int arg) {
    	x=arg;
    }
    public void setY(int arg) {
    	y=arg;
    }
    public int getWidth() {
    	return width;
    }
    
    public int getHeight() {
    	return height;
    }
    
    public void setWidth(int arg) {
    	width=arg;
    }
    public void setHeight(int arg) {
    	height=arg;
    }
    
    public abstract void draw(Graphics g);
}
