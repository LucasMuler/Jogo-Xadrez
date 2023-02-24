package Aplication;

import java.awt.Color;

import Chess.ChessMatch;
import Chess.ChessPiece;
import boardGame.Position;

public class Program {
	public static void main(String[] args) {

		ChessMatch chessMatch = new ChessMatch();
		UI.printBoard(chessMatch.getPieces());

		
		
//		for (int i = 0; i < chessMatch.getPieces().length; i++) {
//			for (int e = 0; e < chessMatch.getPieces().length; e++) {
//
//				ChessPiece p = new ChessPiece(chessMatch.getBoard(), Chess.Color.BLACK);
//				Position position = new Position(i, e);
//				chessMatch.getBoard().PlacePiece(p, position);
//
//			}
//		}



	}
}
