package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Gamepannel extends JPanel implements Runnable{

	public static final int WIDTH = 1010;
	public static final int HEIGHT = 650;
	final int FPS = 60;
	Thread gameThread;
	Board board = new Board();
	
	public Gamepannel() {
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		setBackground (Color.black);
	}
	
	
	public void launchGame () {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	
	@Override
	public void run() {
		//game loop
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lestTime = System.nanoTime();
		long currentTime;
		
		while(gameThread != null) {
			currentTime = System.nanoTime();
			
			delta += (currentTime - lestTime)/drawInterval;
			lestTime = currentTime;
			
			if(delta >= 1) {
				update();
				repaint();
				delta--; 
			}
		}
	}
	
	private void update() {
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		board.draw(g2);
	}
	
	
	
}
