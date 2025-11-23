package piece;

import main.Gamepannel;

public class Rook extends Piece{

	public Rook(int color, int col, int row) {
		super(color, col, row);
		
		if(color == Gamepannel.WHITE) {
			image = getImage("/piece/w-rook");
		}else {
			image = getImage("/piece/b-rook");
		}
	}
	
	
	public boolean canMove(int targetCol, int targetRow) {
		if(isWithinBoard(targetCol, targetRow) && isSameSquare(targetCol, targetRow) == false) {
			if(targetCol == perCol || targetRow == perRow) {
				if(isVaildSquare(targetCol, targetRow) && pieceIsOnStraightLine(targetCol, targetRow) == false) {
					return true;
				}
			}
			
		}
		return false;
	}

}
