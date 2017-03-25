
public class CrosswordPuzzle {
	private Square[][] puzzle;

	public CrosswordPuzzle(boolean[][] blacksquares) {
		puzzle = new Square[blacksquares.length][blacksquares[0].length];
		int num = 1;
		for (int r = 0; r < blacksquares.length; r++) {
			for (int c = 0; c < blacksquares[0].length; c++) {
				if (!toBeLabeled(r, c, blacksquares)) {
					if (blacksquares[r][c]) {
						puzzle[r][c] = new Square(true, 0);
					}

				} else if (toBeLabeled(r, c, blacksquares)) {
					puzzle[r][c] = new Square(false, num);
					num += 1;
				} else {
					puzzle[r][c] = new Square(false, 0);
				}
			}
		}
	}

	private boolean toBeLabeled(int r, int c, boolean[][] blackSquares) {

		if (!blackSquares[r][c]) {

			if ((r == 0 || blackSquares[r - 1][c]) || (c == 0 || blackSquares[r][c - 1])) {
				return true;
			}
		}

		return false;
	}
}