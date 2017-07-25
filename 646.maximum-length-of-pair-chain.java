public class Solution {
    public int findLongestChain(int[][] pairs) {
	Arrays.sort(pairs, new Comparator<int[]>(){
	    @Override
	    public int compare(int[] a, int[] b) {
		return a[0] - b[0];	
	    }
	});
	int[] dp =new int[pairs.length];
	Arrays.fill(dp, 1);
	for (int i = pairs.length - 1; i >= 0; i--) {
	    for (int j = i + 1; j < pairs.length; j++) {
		if (pairs[i][1] < pairs[j][0]) {
		    dp[i] = Math.max(dp[i], dp[j] + 1);
		}
	    }
	}
	int max = 0;
	for (int i = 0; i < dp.length; i++) {
	    max = Math.max(dp[i], max);
	}
	return max;
    }
}
