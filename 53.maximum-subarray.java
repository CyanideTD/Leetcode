class Solution {
    public int maxSubArray(int[] nums) {
	int max = Integer.MIN_VALUE;
	int prev = 0;
	for (int i = 0; i < nums.length; i++) {
	    int cur = Math.max(prev + nums[i], nums[i]);
	    max = Math.max(cur, max);
	    prev = cur;
	}
	return max;
    }
}
