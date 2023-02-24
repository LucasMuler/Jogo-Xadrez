package Aplication;

import Chess.ChessPiece;

public class UI {

	public static void printBoard(ChessPiece[][] pieces) {
		
		for (int i = 0; i < pieces.length; i++) {
			
			System.out.print(8-i + " ");
			
			for (int e = 0; e < pieces.length; e++) {
				
				printPiece(pieces[i][e]);

			}

			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	
	public static void printPiece(ChessPiece piece) {
		if (piece == null) {
			System.out.print("-");
		} else {
			System.out.print(piece);
		}
		System.out.print(" ");
	}

}
