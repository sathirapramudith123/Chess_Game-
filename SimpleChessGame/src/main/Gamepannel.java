package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Gamepannel extends JPanel implements Runnable{

	public static final int WIDTH = 1010;
	public static final int HEIGHT = 650;
	final int FPS = 60;
	Thread gameThread;
	
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
		
	}
	
	private void update() {
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	
	
	
}
