public class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        long[][][] dp = new long[N + 1][m][n];
	int M = 1000000000 + 7;
	for (int k = 1; k < N + 1; k++) {
	    for (int x = 0; x < m; x++) {
		for (int y = 0; y < n; y++) {
		    long v1 = x == 0 ? 1 : dp[k - 1][x - 1][y];
		    long v2 = x == m - 1 ? 1 :dp[k - 1][x + 1][y];
		    long v3 = y == n - 1 ? 1 : dp[k - 1][x][y + 1];
		    long v4 = y == 0 ? 1 : dp[k - 1][x][y - 1];
		    long res = v1 + v2 + v3 + v4;
		    dp[k][x][y] = res % M;
		}
	    }
	}
	return (int) dp[N][i][j];    
    }
}
