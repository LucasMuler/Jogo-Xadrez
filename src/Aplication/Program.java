package Aplication;

import java.util.InputMismatchException;
import java.util.Scanner;

import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition;
import Exceptions.ChessException;

public class Program {
	public static void main(String[] args) {

		ChessMatch chessMatch = new ChessMatch();
		Scanner sc = new Scanner(System.in);
		

		while (true) {
			
			try {
				
				UI.printBoard(chessMatch.getPieces());
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);

				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(sc);

				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
			} catch (ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			
			
			
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
