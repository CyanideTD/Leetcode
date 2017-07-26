public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
	int[][] dp = new int[m + 1][n + 1];
	for (String str : strs) {
	    int[] need = count(str);
	    for (int i = m ; i >= need[0]; i--) {
		for (int j = n; j >= need[1]; j--) {
		    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - need[0]][j - need[1]]);
		}
	    }
	}
	return dp[m][n];
    }
    public int[] count(String s) {
	int[] res = new int[2];
	for (int i = 0; i < s.length(); i++) {
	    if (s.charAt(i) == '0') {
		res[0]++;
	    } else {
		res[1]++;
	    }
	}
	return res;
    }

}
