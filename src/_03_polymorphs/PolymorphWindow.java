package _03_polymorphs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PolymorphWindow extends JPanel implements ActionListener,MouseListener, MouseMotionListener{
    public static final int WIDTH = 900;
    public static final int HEIGHT = 600;
    
    private JFrame window;
    private Timer timer;
    
    
    
    ArrayList<Polymorph> array = new ArrayList<Polymorph>();
    
    public static void main(String[] args) {
   	 new PolymorphWindow().buildWindow();
    }
    
    public void buildWindow(){
   	 window = new JFrame("IT'S MORPHING TIME!");
   	 window.add(this);
   	 window.addMouseMotionListener(this);
   	 window.addMouseListener(this);
   	 window.getContentPane().setPreferredSize(new Dimension(500, 500));
   	 window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   	 window.pack();
   	 window.setVisible(true);
   	 
   	 array.add( new BluePolymorph(50, 50));
   	 array.add( new RedMorph(150,100));
   	 array.add( new MovingMorph(250,250));
   	 array.add(new CircleMorph(25,25));
   	 array.add(new MouseMorph(400,400));
   	 array.add(new ImageMorph(200,200));
   	 array.add(new MessageMorph(350,400));
   	 timer = new Timer(1000 / 30, this);
   	 timer.start();
    }
    
    public void paintComponent(Graphics g){
    //draw background
   	 g.setColor(Color.LIGHT_GRAY);
   	 g.fillRect(0, 0, 500, 500);
   	
   	 //draw polymorph
   	 for(Polymorph poly : array) {
   		 poly.draw(g);
   	 }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
   	 repaint();
   	 for(Polymorph poly : array) {
   		 poly.update();
   	 }
   //	System.out.println(e.getSource().getClass());
   	 
    }

	

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	for(Polymorph poly:array) {
		if(poly.getClass().equals(MouseMorph.class)) {
			poly.setX(e.getX());
			poly.setY(e.getY());
		}
	}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Clicked");
		System.out.println(e.getSource().getClass());
		
	   		for(Polymorph poly : array) {
	   			if(poly.getClass().equals(MessageMorph.class)) {
	      		 ((MessageMorph) poly).jop(e.getX(),e.getY());
	   			}
	      	 }
	   	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
