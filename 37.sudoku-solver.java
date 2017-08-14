public class Solution {
    public void solveSudoku(char[][] board) {
	int[][] col = new int[9][9];
	int[][] row = new int[9][9];
	int[][] squ = new int[9][9];
	for (int i = 0; i < 9; i++) {
	    for (int j = 0; j < 9; j++) {
		int k = i / 3 * 3 + j / 3;
		int num = board[i][j] - '0' - 1;
		if (board[i][j] != '.') {
		    col[j][num] = 1;
		    row[i][num] = 1;
		    squ[k][num] = 1;
		}
	    }
	}
	helper(board, row, col, squ, 0, 0);
    }

    public boolean helper(char[][] board, int[][] row, int[][] col, int[][] squ, int i, int j) {
	boolean flag = false;	
	for (; i < 9; i++) {
	    for (; j < 9; j++) {
		if (board[i][j] == '.') {
		    flag = true;
		    break;
		}
	    }
	    if (flag == true) {
		break;
	    }
	    j = 0;
	}
	if (!flag) {
	    return true;
	}
	int k = i / 3 * 3 + j / 3;
	for (int num = 0; num < 9; num++) {
	    if (col[j][num] == 0 && row[i][num] == 0 && squ[k][num] == 0) {
		col[j][num] = 1;
		row[i][num] = 1;
		squ[k][num] = 1;
		if (helper(board, row, col, squ, i, j + 1)) {
		    board[i][j] = (char) ('0' + num + 1);
		    return true;
		}
		col[j][num] = 0;
		row[i][num] = 0;
		squ[k][num] = 0;
	    }
	}
	return false;
    }
}
