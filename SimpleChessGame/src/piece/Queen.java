package piece;

import main.Gamepannel;

public class Queen extends Piece{

	public Queen(int color, int col, int row) {
		super(color, col, row);
		
		if(color == Gamepannel.WHITE) {
			image = getImage("/piece/w-queen");
		}else {
			image = getImage("/piece/b-queen");
		}
	}

}
