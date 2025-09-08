package piece;

import main.Gamepannel;

public class Pawan extends Piece {

	public Pawan(int color, int col, int row) {
		super(color, col, row);
		
		if(color == Gamepannel.WHITE) {
			image = getImage("/piece/w-pawn");
		}else {
			image = getImage("/piece/b-pawn");
		}
	}

	
}
