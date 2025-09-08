package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import piece.Bishop;
import piece.King;
import piece.Knight;
import piece.Pawan;
import piece.Piece;
import piece.Queen;
import piece.Rook;

public class Gamepannel extends JPanel implements Runnable{

	public static final int WIDTH = 1030;
	public static final int HEIGHT = 800;
	final int FPS = 60;
	Thread gameThread;
	Board board = new Board();
	Mouse mouse = new Mouse();
	
	//piece
	public static ArrayList<Piece> pieces = new ArrayList<>();
	public static ArrayList<Piece> simPieces = new  ArrayList<>();
	Piece activeP;
	
	//color
	public static final int WHITE = 0;
	public static final int BLACK = 1;
	int currentColor =  WHITE;

	
	
	public Gamepannel() {
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		setBackground (Color.black);
		addMouseMotionListener(mouse);
		addMouseListener(mouse);
		
		setPieces();
		copyPieces(pieces, simPieces);
	}
	
	
	public void launchGame () {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	//set pieces
	public void setPieces () {
		//white pieces
		
		pieces.add(new Pawan(WHITE,0,6));
		pieces.add(new Pawan(WHITE,1,6));
		pieces.add(new Pawan(WHITE,2,6));
		pieces.add(new Pawan(WHITE,3,6));
		pieces.add(new Pawan(WHITE,4,6));
		pieces.add(new Pawan(WHITE,5,6));
		pieces.add(new Pawan(WHITE,6,6));
		pieces.add(new Pawan(WHITE,7,6));
		pieces.add(new Rook(WHITE,0,7));
		pieces.add(new Rook(WHITE,7,7));
		pieces.add(new Knight(WHITE,1,7));
		pieces.add(new Knight(WHITE,6,7));
		pieces.add(new Bishop(WHITE,2,7));
		pieces.add(new Bishop(WHITE,5,7));
		pieces.add(new Queen(WHITE,3,7));
		pieces.add(new King(WHITE,4,7));
		
		
		//black pieces
		
		pieces.add(new Pawan(BLACK,0,1));
		pieces.add(new Pawan(BLACK,1,1));
		pieces.add(new Pawan(BLACK,2,1));
		pieces.add(new Pawan(BLACK,3,1));
		pieces.add(new Pawan(BLACK,4,1));
		pieces.add(new Pawan(BLACK,5,1));
		pieces.add(new Pawan(BLACK,6,1));
		pieces.add(new Pawan(BLACK,7,1));
		pieces.add(new Rook(BLACK,0,0));
		pieces.add(new Rook(BLACK,7,0));
		pieces.add(new Knight(BLACK,1,0));
		pieces.add(new Knight(BLACK,6,0));
		pieces.add(new Bishop(BLACK,2,0));
		pieces.add(new Bishop(BLACK,5,0));
		pieces.add(new Queen(BLACK,3,0));
		pieces.add(new King(BLACK,4,0));
		
	}
	
	private void copyPieces(ArrayList<Piece> source, ArrayList<Piece> target) {
		
		target.clear();
		for(int i=0; i<source.size();i++) {
			target.add(source.get(i));
		}
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
		//moused button pressed
		if(mouse.pressed)
		{
			if(activeP == null) 
			{
				for(Piece piece : simPieces) 
				{
					if(piece.color == currentColor 
							&& piece.col == mouse.x/Board.SQUARE_SIZE
							&& piece.row == mouse.y/Board.SQUARE_SIZE)
					{
						activeP = piece;
					}
				}
			}else {
				//player is holding a pieces simulate the move 
				simulate();
			}
		}
	}
	
	private void simulate() {
		
		activeP.x = mouse.x -Board.HALF_SQUARE_SIZE;
		activeP.y = mouse.y - Board.HALF_SQUARE_SIZE;
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		//board
		board.draw(g2);
		
		//piece
		for(Piece p : simPieces) {
			p.draw(g2);
		}
	}
	
	
	
}
