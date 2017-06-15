public class Solution {
    public void solve(char[][] board) {
	if (board == null || board.length == 0) {
		return;
	}
	int[] directionX = {0, 0, -1, 1};
	int[] directionY = {1, -1, 0, 0};
    	int n = board.length;
    	int m = board[0].length;
	int[] lable = new int[n * m];
	for (int i = 0; i < lable.length; i++) {
		lable[i] = i;
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (board[i][j] != 'O') {
				continue;
			}
			for (int k = 0; k < 4; k++) {
				int x = i + directionX[k];
				int y = j + directionY[k];
				if (x >= 0 && x < n && y >= 0 && y < m) {
					if (board[x][y] == 'O') {
						union(lable, i, j, x, y, m);
					}
				}
			}
		}
	}
	Set<Integer> root = new HashSet<>();
	for (int i = 0; i < m; i++) {
		if (board[0][i] == 'O') {
			root.add(find(lable, 0, i, m));
		}
		if (board[n - 1][i] == 'O') {
			root.add(find(lable, n - 1, i, m));
		}
	}
	for (int i = 0; i < n; i++) {
		if (board[i][0] == 'O') {
			root.add(find(lable, i, 0, m));
		}
		if (board[i][m - 1] == 'O') {
			root.add(find(lable, i, m - 1, m));
		} 
	}
	for (int i = 1; i < n - 1; i++) {
		for (int j = 1; j < m - 1; j++) {
			if (board[i][j] == 'O' &&!root.contains(find(lable, i, j, m))) {
				board[i][j] = 'X';
			}
		}
	}
    }
    public void union(int[] lable, int i, int j, int x, int y, int m) {
    	int parent = find(lable, i, j, m);
	int child = find(lable, x, y, m);
	if (parent == child) {
		return;
	}
	lable[child] = parent;
    }
    public int find(int[] lable, int i, int j, int m) {
    	int index = i * m + j;
	while (index != lable[index]) {
		lable[index] = lable[lable[index]];
		index = lable[index];
	}
	return index;
    }
}
