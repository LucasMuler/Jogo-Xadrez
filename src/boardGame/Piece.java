package boardGame;

public abstract class Piece {

	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
	}
	
	protected Board getBoard() {
		return board;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position postition) {
		this.position = postition;
	}
	
	public abstract boolean[][] PossibleMoves();
	
	public boolean possibleMove(Position position){
		return PossibleMoves()[position.getRow()][position.getColumn()];
	}
	
	public boolean isThereAnyPossibleMove() {
		boolean mat[][]= PossibleMoves();
		for (int i = 0; i < mat.length;i++) {
			for (int j = 0; j < mat.length; j++) {
				Position p = new Position(i,j);
				if (possibleMove(p)) {
					return true;
				}
			}
		}
		return false;
	}
	
}
