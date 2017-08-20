class Solution {
    public List<List<String>> solveNQueens(int n) {
	char[][] board = new char[n][n];
	for (int i = 0; i < n; i++) {
	    Arrays.fill(board[i], '.');
	}
	List<List<String>> res = new ArrayList<>();
	if (n !=1 && n < 4) {
	    return res;
	}
	dfs(res, board, 0);
	return res;
    }
    public void dfs(List<List<String>> res, char[][] board, int index) {
	if (index >= board.length) {
	    List<String> path = new ArrayList<>();
	    for (int i = 0; i < board.length; i++) {
		String add = new String(board[i]);
	 	path.add(add);
	    }
	    res.add(path);
	    return;
	}	
	for (int i = 0; i < board[0].length; i++) {
	    if (check(board, index, i)) {
		board[index][i] = 'Q';
		dfs(res, board, index + 1);
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
