package Chess;

import java.awt.Color;

import boardGame.Board;
import boardGame.Piece;

public class ChessPiece extends Piece{
	
	private Color color;
	
	public ChessPiece(Board board) {
		super(board);
	}
	
	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	
	
}
