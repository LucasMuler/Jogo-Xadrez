package boardGame;

import Exceptions.BoardException;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		if (rows >= 1 && columns >= 1) {
			this.rows = rows;
			this.columns = columns;
			this.pieces = new Piece[rows][columns];
		} else {
			throw new BoardException("The board rows and columns need to be mor then 1");
		}

	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public Piece piece(int row, int column) {

		if (positionExists(row, column)) {
			return pieces[row][column];
		} else {
			throw new BoardException("Position not on the board");
		}

	}

	public Piece piece(Position position) {

		if (positionExists(position)) {
			return pieces[position.getRow()][position.getColumn()];
		} else {
			throw new BoardException("Position not on the board");
		}
	}

	public void PlacePiece(Piece piece, Position c) {

		if (thereIsAPiece(c)) {
			pieces[c.getRow()][c.getColumn()] = piece;
		} else if (!positionExists(c)) {
			throw new BoardException("Position not on the board");
		}

	}

	public void RemovePiece(Piece piece, Position position) {

		if (thereIsAPiece(position)) {
			pieces[position.getRow()][position.getColumn()] = null;
		} else {
			throw new BoardException("There isn't a piece in this position");
		}

	}

	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}

	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}

	public boolean thereIsAPiece(Position position) {

		if (piece(position) == null) {
			return true;
		} else {
			throw new BoardException("There is a piece in position " + position);
		}

	}
}
