public class Solution {
    public int threeSumClosest(int[] nums, int target) {
	int diff = Integer.MAX_VALUE;
	int res = 0;
	Arrays.sort(nums);
	for (int i = 0; i < nums.length - 2; i++) {
	    int lo = i + 1;
	    int hi = nums.length - 1;
	    while (lo < hi) {
		int sum = nums[i] + nums[lo] + nums[hi];
		if (Math.abs(sum - target) < diff) {
		    diff = Math.abs(sum - target);
		    res = sum;
		}
		if (sum - target > 0) {
		    hi--;
	  	} else if (sum - target < 0) {
		    lo++;
	 	} else {
		    return sum;
	 	}
	    }
	}
	return res;
    }
}
