package Aplication;

import java.awt.Color;

import Chess.ChessPiece;
import boardGame.Board;
import boardGame.Position;

public class Program {
	public static void main(String[] args) {

		Board board = new Board(8 ,8);
		
		for (int i = 0; i < board.getRows();i++) {
			for (int e = 0; e < board.getColumns();e++) {
				
				ChessPiece p = new ChessPiece(board, Color.BLACK);
				Position position = new Position(i, e);
				board.piece(i, e);
				
				
			}
		}

		
		
	}
}
