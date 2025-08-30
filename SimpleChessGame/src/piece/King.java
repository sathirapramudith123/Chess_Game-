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

}
