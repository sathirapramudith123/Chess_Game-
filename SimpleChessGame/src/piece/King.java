package piece;

import main.Gamepannel;

public class King extends Piece{

	public King(int color, int col, int row) {
		super(color, col, row);
		
		if(color == Gamepannel.WHITE) {
			image = getImage("/piece/w-king");
		}else {
			image = getImage("/piece/b-king");
		}
	}

	
	public boolean canMove(int tragetCol, int tragetRow) {
		
		if(isWithinBoard(tragetCol, tragetRow)) {
			if(Math.abs(tragetCol - perCol) + Math.abs(tragetRow - perRow) == 1 || 
					Math.abs(tragetCol - perCol) * Math.abs(tragetRow - perRow) == 1) {
				if(isVaildSquare(tragetCol, tragetRow)) {
					return true;
				}	
			}
		}
		return false;
	}
}
