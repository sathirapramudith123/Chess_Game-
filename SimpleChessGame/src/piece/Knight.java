package piece;

import main.Gamepannel;

public class Knight extends Piece {

	public Knight(int color, int col, int row) {
		super(color, col, row);
		
		if(color == Gamepannel.WHITE) {
			image = getImage("/piece/w-knight");
		}else {
			image = getImage("/piece/b-knight");
		}
	}

}
