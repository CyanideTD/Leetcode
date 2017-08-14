public class Solution {
    public boolean isValidSudoku(char[][] board) {
	int[][] rows = new int[9][9];
	int[][] square = new int[9][9];
	int[][] col = new int[9][9];
	for (int i = 0; i < 9; i++) {
	    for (int j = 0; j < 9; j++) {
		if (board[i][j] != '.') {
		    int num = board[i][j] - '0';
		    if (rows[i][num - 1] == 1) {
			return false;
		    } else {
			rows[i][num - 1] = 1;
		    }

		    if (col[j][num - 1] == 1) {
			return false;
		    } else {
			col[j][num - 1] = 1;
		    }

		    int k = i / 3 * 3 + j / 3;
		    if (square[k][num - 1] == 1) {
		 	return false;
		    } else {
			square[k][num - 1] = 1;
		    }
		}
	    }
	}
	return true;
    }
}
