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

}
