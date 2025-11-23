package piece;

import main.Gamepannel;

public class Bishop extends Piece{

	public Bishop(int color, int col, int row) {
		super(color, col, row);
		
		
		if(color == Gamepannel.WHITE) {
			image = getImage("/piece/w-bishop");
		}else {
			image = getImage("/piece/b-bishop");
		}
	}
	
	public boolean canMove(int targetCol, int targetRow) {
		
		if(isWithinBoard(targetCol,targetRow) && isSameSquare(targetCol,targetRow) == false) {
			if(Math.abs(targetCol - perCol) == Math.abs(targetRow - perRow)) {
				if(isVaildSquare(targetCol, targetRow) && pieceIsOnDiagonalLine(targetCol,targetRow) == false) {
					return true;
				}
			}
		}
		return false;
	}

}
