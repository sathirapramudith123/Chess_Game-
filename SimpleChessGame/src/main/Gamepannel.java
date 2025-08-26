package main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class Gamepannel extends JPanel {

	public static final int WIDTH = 1010;
	public static final int HEIGHT = 650;
	
	public Gamepannel() {
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		setBackground (Color.black);
	}
}
