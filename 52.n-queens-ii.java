class Solution {
    int num = 0;
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
	for (int i = 0; i < n; i++) {
	    Arrays.fill(board[i], '.');
	}
	if (n !=1 && n < 4) {
	    return 0;
	}
	dfs(board, 0);   
	return num;
    }
    public void dfs(char[][] board, int index) {
	if (index >= board.length) {
	    num++;
	    return;
	}	
	for (int i = 0; i < board[0].length; i++) {
	    if (check(board, index, i)) {
		board[index][i] = 'Q';
		dfs(board, index + 1);
		board[index][i] = '.';
	    }
	}
    }
    public boolean check(char[][] board, int row, int col) {
	for (int i = row - 1; i >= 0; i--) {
	    if (board[i][col] == 'Q') {
		return false;
	    }
	    int diff = row - i;
	    if (col + diff < board[0].length) {
		if (board[i][col + diff] == 'Q') {
		    return false;
	  	}
	    }
	    if (col - diff >= 0) {
		if (board[i][col - diff] == 'Q') {
		    return false;
		}
	    }
	}
	return true;
    }
}
