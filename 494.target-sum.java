public class Solution {
    int result = 0;
    public int findTargetSumWays(int[] nums, int S) {
	int sum = 0;
    	for (int i = 0; i < nums.length; i++) {
	    sum += nums[i];
	    nums[i] *= 2;
	}
	int target = sum + S;
	int[] dp = new int[target + 1];
	dp[0] = 1;
	for (int i = 0; i < nums.length; i++) {
	    for (int j = target; j >= 0; j--) {
		if (j >= nums[i]) {
		    dp[j] += dp[j - nums[i]];
		}
	    }
	}
	return dp[target];
    }
}
