package piece;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

import main.Board;
import main.Gamepannel;

public class Piece {
    
    public BufferedImage image;
    public int x, y;
    public int col, row, perCol, perRow; // previous column and row  
    public int color; 
    public Piece hittingP;
    
    public Piece(int color, int col, int row) {
        this.color = color;
        this.col = col; 
        this.row = row;
        x = getX(col);
        y = getY(row);
        perCol = col;
        perRow = row;
    }
    
    public BufferedImage getImage(String imagePath) {
        BufferedImage image = null;
        try {
            InputStream is = Piece.class.getResourceAsStream(imagePath + ".png");
            if (is == null) {
                System.err.println("❌ Could not find image: " + imagePath + ".png");
                return null;
            }
            image = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
    
    public int getX(int col) {
        return col * Board.SQUARE_SIZE;
    }
    public int getY(int row) {
        return row * Board.SQUARE_SIZE;
    }
    public int getCol(int x) {
    	return (x + Board.HALF_SQUARE_SIZE)/Board.SQUARE_SIZE;
    }
    public int getRow(int y) {
    	return (y + Board.HALF_SQUARE_SIZE)/Board.SQUARE_SIZE;
    }
    public void updatePostion() {
    	x = getX(col);
    	y = getY(row);
    	perCol = getCol(x);
    	perRow = getRow(y);
    	
    }
    public void resetPosition() {
    	col = perCol;
    	row = perRow;
    	x = getX(col);
    	y = getY(row);
    }
    public boolean canMove(int tragetCol, int tragetRow) {
    	return false;
    }
    public boolean isWithinBoard(int targetCol, int targetRow) {
    	if(targetCol >= 0 && targetCol <= 7 && targetRow >= 0 && targetRow <= 7) {
    		return true;
    	}
    	return false;
    }
    public Piece getHittingP(int targetCol, int targetRow) {
    	for(Piece piece : Gamepannel.simPieces) {
    		if(piece.col == targetCol && piece.row == targetRow && piece != this) {
    			return piece;
    		}
    	}
    	return null;
    }
    public boolean isVaildSquare(int targetCol, int targetRow) {
    	hittingP = getHittingP(targetCol, targetRow);
    	if(hittingP ==null) {
    		return true;
    	}
    	return false;
    }
    
    public void draw(Graphics2D g2) {
        if (image != null) {
            g2.drawImage(image, x, y, Board.SQUARE_SIZE, Board.SQUARE_SIZE, null);
        }
    }
}
