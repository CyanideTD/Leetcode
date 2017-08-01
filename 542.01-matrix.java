public class Solution {
    public int[][] updateMatrix(int[][] matrix) {
	int n = matrix.length;
	int m = matrix[0].length;
	int[][] res = new int[n][m];
	Deque<int[]> queue = new ArrayDeque<>();
	for (int i = 0; i < n; i++) {
	    for (int j = 0; j < m; j++) {
	    	if (matrix[i][j] == 0) {
		    queue.addLast(new int[]{i, j});
		} else {
		    res[i][j] = Integer.MAX_VALUE;
		}
	    }
	}
	int[][] dir = {{0, 1},{0, -1},{-1, 0},{1, 0}};
	while (!queue.isEmpty()) {
	    int[] cur = queue.poll();
	    for (int[] direc : dir) {
		int x = cur[0] + direc[0];
		int y = cur[1] + direc[1];
		if (x < 0 || x >= n || y < 0 || y >= m || res[x][y] != Integer.MAX_VALUE) {
		    continue;
		}
		res[x][y] = res[cur[0]][cur[1]] + 1;
		queue.addLast(new int[]{x, y});
	    }
	}
	return res;
    }
}
