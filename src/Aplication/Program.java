package Aplication;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition;
import Exceptions.ChessException;

public class Program {
	public static void main(String[] args) {

		ChessMatch chessMatch = new ChessMatch();
		Scanner sc = new Scanner(System.in);
		List<ChessPiece> captured = new ArrayList<>();

		while (true) {
			
			try {
				
				UI.clearScreen();
				UI.printMatch(chessMatch, captured);
				System.out.println("source:");
				System.out.println();
				ChessPosition source = UI.readChessPosition(sc);
				
				// create a matrix that see the possible moves of source position
				
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(), possibleMoves);
				
				System.out.println("target:");
				System.out.println();
				ChessPosition target = UI.readChessPosition(sc);
				
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
				
				if(capturedPiece != null) {
					captured.add(capturedPiece);
				}
				
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
