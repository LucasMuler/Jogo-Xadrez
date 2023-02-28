package Aplication;

import java.util.Scanner;

import Chess.ChessMatch;
import Chess.ChessPosition;
import boardGame.Board;

public class Program {
	public static void main(String[] args) {

		ChessMatch chessMatch = new ChessMatch();
		Scanner sc = new Scanner(System.in);
		

		while (true) {
			
			UI.printBoard(chessMatch.getPieces());
			System.out.println("source:");
			System.out.println();
			ChessPosition source = UI.readChessPosition(sc);
			
			System.out.println("target:");
			System.out.println();
			ChessPosition target = UI.readChessPosition(sc);
			
			chessMatch.performChessMove(source, target);
			
		}

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
