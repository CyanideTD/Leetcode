public class Solution {
    public int longestPalindromeSubseq(String s) {
	int n = s.length();
	if (n == 0) {
	    return 0;
	}        
	int[][] dp = new int[n][n];
	for (int i = 0; i < n; i++) {
	    dp[i][i] = 1;
	    for (int j = i - 1; j >= 0; j--) {
		if (s.charAt(i) == s.charAt(j)) {
		    dp[j][i] = dp[j + 1][i - 1] + 2;
		} else {
		    dp[j][i] = Math.max(dp[j][i - 1], dp[j + 1][i]);
		}
	    }
	}
	return dp[0][n - 1];
    }
}
