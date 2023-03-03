package Chess;

import Exceptions.ChessException;
import boardGame.Position;

public class ChessPosition {

	private char column;
	private int row;

	public ChessPosition(char column, int row) {
		if (column >= 'a' && column <= 'h' && row >= 1 && row <= 8) {
			this.column = column;
			this.row = row;
		} else {
			throw new ChessException("Inexistent position");
		}

	}

	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}

	protected Position toPosition() {
		return new Position(8 - this.row, this.column - 'a');
	}

	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char) ('a' - position.getColumn()), 8 - (position.getRow()));
	}

	@Override
	public String toString() {
		return "" + column + row;
	}

}
